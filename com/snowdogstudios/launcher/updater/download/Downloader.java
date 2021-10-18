package com.snowdogstudios.launcher.updater.download;

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
import com.snowdogstudios.util.Logger;
import com.snowdogstudios.util.FileUnziper;

public class Downloader {
  public static Logger logger = new Logger();
  public static void download(String path, String dest, String name) {
    try {
      InputStream in = new URL(path).openStream();
      Files.copy(in, Paths.get(name));
      File file = new File(System.getProperty("user.dir") + "/" + name);
      file.renameTo(new File(dest + "/" + name));
    } catch(IOException e) {
      logger.log(e.toString());
    }
  }
  
  public static void downloadAssets(String assetZip, String dest) {
    download(assestZip, dest, "assets.zip");
    Unziper.unzip(System.getProperty("user.dir")+"/assets.zip", System.getProperty("user.dir")+"/assets/");
    File assetzip = new File(System.getProperty("user.dir")+"/assets.zip");
    assetzip.delete();
  }
}
