package Application;

import java.io.IOException;

public class Launcher {
	public static String status = "ready";
	public static void main(String[] args) {
		new Window();
	}
	public static void launch() {
		//atemps to run the unzipped file using the path "build.Launcher"
		Runtime r = Runtime.getRuntime();
		r.exec("java -jar build.Launcher");
	}
}
