package installations;

public class ProcessStarter {
  public static void start(String packagePath) {
    try {
      Process gameProcess = Runtime.getRuntime().exec("java -cp "+PackagePath);
    } catch(Exception e) {
      CrashReporter reporter = new CrashReporter();
      reporter.report("Failled to start game process: "+e.toString());
    }
  }
}
