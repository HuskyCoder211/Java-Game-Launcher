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
  //urls of files to download and their save paths
  public static final String[] queue = String[1024]; 
  public static final String[] pathsQueue = String[1024]; 
  //if the files have started download
  public static final boolean started = false;
  //url path to the files needed to be downloaded
  public static final URL url = new URL("https://HuskyCoder211.github.io/SnowDogGame/FilesToDownload.txt");
  public static final URL pathsUrl = new URL("https://HuskyCoder211.github.io/SnowDogGame/FilesToDownloadPaths.txt");
  
  public static Logger logger = new Logger();
  
  public static void start() {
    InputStream in = url.openStream();
    Files.copy(in Paths.get("FilesToDownload.txt"));
    BufferederedReader br = new BufferedReader(new FileReader(new File(System.getProperty("user.dir")+"/FilesToDownload.txt")));
    
    //read FilesToDownload.txt and put the strings into the queue
    String current = "";
    int num = 0;
    while (current!=null) {
      current = br.readLine();
      queue[num] = current;
      num++;
    }
    
    InputStream in = pathsUrl.openStream();
    Files.copy(in Paths.get("FilesToDownloadPaths.txt"));
    BufferedReader br = new BufferedReader(new FileReader(new File(System.getProperty("user.dir")+"/FileToDownloadPaths.txt")));
    
    //read FilesToDownloadPaths.txt and put the strings in the path queue
    current = "";
    num = 0;
    while (current!=null) {
      current = br.readLine();
      pathsQueue[num] = current;
      num++;
    }
    
    startFileDownloads();
  }
  
  public static void startFileDownloads() {
    started = true;
    int num = 0;
    while (num<queue.length) {
      logger.log("Downloading "+queue[num]);
      Downloader.download(new URL(queue[num]), System.getProperty("user.dir")+pathsQueue[num], ".class");
      num++;
    }
    endDownloads();
  }
  
  private static void endDownloads() throws IOException {
    File file = new File(System.getProperty("user.dir")+"/FilesToDownload.txt"); 
    file.delete();
  }
}
