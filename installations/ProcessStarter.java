package installations;

import com.snowdogstudios.util.Logger;
import com.snowdogstudios.crashes.CrashReporter;

public class ProcessStarter {
  public static Process current;
  public static CrashReporter reporter = new CrashReporter();
  public static Logger processLogger = new Logger();
  
  public static void start(String packagePath) {
    try {
      Process gameProcess = Runtime.getRuntime().exec("java -cp "+PackagePath);
      Process current = gameProcess;
    } catch(Exception e) {
      reporter.report("Failed to start game process: "+e.toString());
      processLogger.log("Failed to start game process: "+e.toString());
    }
  }
  
  public static Process getCurrentRunningProcess() {
    processLogger.log("Returned current running process");
    return current;
  }
  
  public static OutputStream getCurrentProcessOutput() {
    return current.getOutputStream(); 
  }
}
