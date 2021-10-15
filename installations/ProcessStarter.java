package installations;

import com.snowdogstudios.util.Logger;
import com.snowdogstudios.crashes.CrashReporter;

public class ProcessStarter {
  public static Process current;
  CrashReporter reporter = new CrashReporter();
  Logger processLogger = new Logger();
  
  public static void start(String packagePath) {
    try {
      Process gameProcess = Runtime.getRuntime().exec("java -cp "+PackagePath);
      Process current = gameProcess;
    } catch(Exception e) {
      reporter.report("Failled to start game process: "+e.toString());
      processLogger.log("Failed to start game process: "+e.toString());
    }
  }
  
  public static Process getCurrentRunningProcess() {
    return current;
    processLogger.log("Returned current running process");
  }
}
