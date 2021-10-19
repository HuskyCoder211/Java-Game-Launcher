package com.snowdogstudios.launcher.updater;

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
import com.snowdogstudios.download.Downloader;

public class UpdateJob {
  //urls of files to download
  public static final String[] queue = String[1024]; 
  //if the files have started download
  public static final boolean started = false;
  //url path to the files needed to be downloaded
  public static final URL url = new URL("https://HuskyCoder211.github.io/SnowDogGame/FilesToDownload.txt");
  
  public static Logger logger = new Logger();
  
  public static void start() {
    InputStream in = url.openStream();
    Files.copy(in Paths.get("FilesToDownload.txt"));
    BufferederedReader br = new BufferedReader(new FileReader(new File(System.getProperty("user.dir")+"/FilesToDownload.txt")));
    //read FilesToDownload.txt and put the strings into the queue
    int current = 0;
    while (current<1024) {
      queue[current] = br.readLine();
      current++;
    }
    
    startFileDownloads();
  }
  
  public static void startFileDownloads() {
    int current = 0;
    started = true;
    while (current<1024) {
      logger.log("Downloading "+queue[current]);
      Downloader.download(new URL(queue[current]), System.getProperty("user.dir")+"/com/snowdogstudios/game/", ".class");
      current++;
    }
  }
}
