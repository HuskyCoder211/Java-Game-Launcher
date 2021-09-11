package Application;

import java.io.IOException;

public class Launcher {
	public static String status = "ready";
	public static void main(String[] args) {
		new Window();
	}
	public static void launch() {
		Runtime r = Runtime.getRuntime();
		try {
			r.exec("cd "+System.getProperty("user.dir"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
