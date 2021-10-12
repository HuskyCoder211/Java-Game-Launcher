package com.snowdogstudios.utl;

public class Logger {
  public Logger() {
    this.id = Math.random(); 
  }
  
  public static void log(String data) {
    System.out.println(data);
  }
}
