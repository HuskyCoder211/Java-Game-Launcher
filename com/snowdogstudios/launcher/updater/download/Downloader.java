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

public class Downloader {
  public static Logger logger = new Logger();
  public static void download(String path, String name) {
    try {
      InputStream in = new URL(path).openStream();
      Files.copy(in, Paths.get(name));
    } catch(IOException e) {
      logger.log(e.toString());
    }
  }
}
