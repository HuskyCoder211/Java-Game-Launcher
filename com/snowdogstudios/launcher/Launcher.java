package com.snowdogstudios.launcher;

import com.snowdogstudios.util.Logger;
import com.snowdogstudios.crashes.CrashReporter;
import com.snowdogstudios.launcher.window.Window;
import com.snowdogstudios.launcher.updater.Updater;
import installations.ProcessStarter;

public class Launcher {
	public static String status = "ready";
	public static CrashReporter reporter = new CrashReporter();
	public static Logger launchLogger = new Logger();
	public static CrashReporter reporter = new CrashReporter();
	public static void main(String[] args) {
		try {
			Updater.checkForUpdate();
		} catch(Exception e) {
			reporter.report(e.toString());
		}
		new Window();
	}
	public static void launch() {
		try {
			ProcessStarter.start("build.com.snowdogstudios.Main");
			Process game = ProcessStarter.getCurrentRunningProcess();
		} catch(Exception e) {
			launchLogger.log("Launch Failled: "+e.toString());
			reporter.report("Launch Failled: "+e.toString());
		}
	}
}
