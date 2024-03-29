package com.snowdogstudios.launcher.updater;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import com.snowdogstudios.util.FileUnzipper;
import com.snowdogstudios.util.Logger;
import com.snowdogstudios.crashes.CrashReporter;
import com.snowdogstudios.launcher.window.UpdateWindow;
import com.snowdogstudios.launcher.Launcher;
import com.snowdogstudios.crashes.CrashReporter;

public class Updater {
	public static int version;
	public static int onlineVersion;
	public static File versionFile;
	public static File onlineVersionFile;
	public static Logger updateLogger = new Logger();
	
	public static void checkForUpdate() throws Exception {
		Launcher.status = "Checking for updates";
		
		try {
			File onlineVersionFile = new File(System.getProperty("user.dir") + "/onlineVersion.txt");
            onlineVersionFile.delete();
		} catch(Exception e2) {
			e2.printStackTrace();
		}
		
		try (InputStream in = new URL("https://HuskyCoder211.github.io/Java-Game-Launcher/LatestVersion.txt").openStream()) {

            Files.copy(in, Paths.get("onlineVersion.txt"));
            
            onlineVersionFile = new File(System.getProperty("user.dir")+"/onlineVersion.txt");
            BufferedReader onlineVersionBr = new BufferedReader(new FileReader(onlineVersionFile));
            String onlineVersionStr = onlineVersionBr.readLine();
            onlineVersion = Integer.parseInt(onlineVersionStr);
            
            try {
            	versionFile = new File(System.getProperty("user.dir") + "/version.txt");
            	BufferedReader versionBr = new BufferedReader(new FileReader(versionFile));
            	String versionStr = versionBr.readLine();
            	version = Integer.parseInt(versionStr);
            } catch(Exception e4) {
            	versionFile.renameTo(onlineVersionFile);
            }
            
            System.out.println(version);
            System.out.println(onlineVersion);
            
            if (version<onlineVersion) {
            	downloadUpdate();
            } else {
            	Launcher.status = "ready";
            	updateLogger.log("No updates available");
            }
        }
	}
	
	public static void downloadUpdate() {
		System.out.println("Downloading Update");
		Launcher.status = "updating";
		
		UpdateWindow.create();
		
		try {
			versionFile = new File(System.getProperty("user.dir") + "/version.txt");
			
			UpdateJob.start();
			
			System.out.println("Finalizing");
			versionFile.delete();
			onlineVersionFile.renameTo(versionFile);
			
		} catch (Exception e3) {
			updateLogger.log("Update download failed: "+e3.toString());
			CrashReporter r = new CrashReporter();
			r.report("Update download failed: "+e3.toString());
		}
		
		Launcher.status = "ready";
		UpdateWindow.close();
	}
}
