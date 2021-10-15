package installations;

import com.snowdogstudios.util.Logger;
import com.snowdogstudios.crashes.CrashReporter;

public class ProcessStarter {
  public static void start(String packagePath) {
    try {
      Process gameProcess = Runtime.getRuntime().exec("java -cp "+PackagePath);
    } catch(Exception e) {
      CrashReporter reporter = new CrashReporter();
      Logger processLogger = new Logger();
      reporter.report("Failled to start game process: "+e.toString());
      processLogger.log("Failed to start game process: "+e.toString());
    }
  }
}
