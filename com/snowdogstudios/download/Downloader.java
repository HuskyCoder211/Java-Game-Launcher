package com.snowdogstudios.download;

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

public class Downloader {
  public static void download(URL url, String dest, String name) throws IOException {
    InputStream in = url.openStream();
    Files.copy(in, Paths.get(name));
    File file = new File(System.getProperty("user.dir")+"/"+name);
    file.renameTo(dest+"/"+name);
  }
}
