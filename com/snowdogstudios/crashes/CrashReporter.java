package com.snowdogstudios.crashes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class CrashReporter {
    public static double id;
    
    public CrashReporter() {
        this.id = Math.random();
    }
  
    public static void report(String reason) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[yyyy/MM/dd HH:mm:ss]");  
        LocalDateTime now = LocalDateTime.now();  
        try{
            File file = new File("crashreport.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dtf.format(now)+" "+reason);
            bw.flush();
            bw.close();

        }catch(IOException e){
        e.printStackTrace();
        }
    }
}
