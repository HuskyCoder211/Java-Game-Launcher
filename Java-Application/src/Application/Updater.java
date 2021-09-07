package Application;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Updater {
	public static String version;
	public static String onlineVersion;
	public static File versionFile;
	public static File onlineVersionFile;
	
	public static void checkForUpdate(URL versionUrl) throws Exception {
		Launcher.status = "Checking for updates";
		try {            
			File onlineVersionFile = new File(System.getProperty("user.dir") + "/onlineVersion.txt");
            onlineVersionFile.delete();
		} catch(Exception e2) {
			e2.printStackTrace();
		}
		
		try (InputStream in = versionUrl.openStream()) {
            Files.copy(in, Paths.get("onlineVersion.txt"));
            
            onlineVersionFile = new File(System.getProperty("user.dir")+"/onlineVersion.txt");
            BufferedReader onlineVersionBr = new BufferedReader(new FileReader(onlineVersionFile));
            onlineVersion = onlineVersionBr.readLine();
            
            versionFile = new File(System.getProperty("user.dir") + "/version.txt");
            BufferedReader versionBr = new BufferedReader(new FileReader(versionFile));
            version = versionBr.readLine();
            System.out.println(version);
            System.out.println(onlineVersion);
            
            if (version==onlineVersion) {
            	downloadUpdate();
            } else {
            	return;
            }
        }
	}
	
	public static void downloadUpdate() {
		System.out.println("Downloading Update");
		Launcher.status = "updating";
		
		UpdateWindow.create();
		
		try {
			File oldUpdate = new File(System.getProperty("user.dir") + "/update.jar");
			oldUpdate.delete();
			
			InputStream in = new URL("https://drive.google.com/uc?export=download&id=1bdRXCVTkFHiMsmrtiMHOfCQ-YvrCUvH4").openStream();
			Files.copy(in, Paths.get("update.jar"));
			
			System.out.println("Finalizing");
			versionFile.delete();
			onlineVersionFile.renameTo(versionFile);
			
			
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		
		Launcher.status = "ready";
		UpdateWindow.close();
		
	}
}
