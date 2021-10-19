package installations;

import com.snowdogstudios.util.Logger;
import com.snowdogstudios.crashes.CrashReporter;
import java.io.OutputStream;

public class ProcessStarter {
  public static Process current;
  public static CrashReporter reporter = new CrashReporter();
  public static Logger processLogger = new Logger();
  
  public static void start() {
    try {
      Process gameProcess = Runtime.getRuntime().exec("java -jar build.jar");
      current = gameProcess;
    } catch(Exception e) {
      reporter.report("Failled to start game process: "+e.toString());
      processLogger.log("Failed to start game process: "+e.toString());
    }
  }
  
  public static Process getCurrentRunningProcess() {
    processLogger.log("Returned current running process");
    return current;
  }

  public static OutputStream getCurrentProcessOutputstream() {
    return current.getOutputStream();
  }
}
