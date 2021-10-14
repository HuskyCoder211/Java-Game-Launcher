package com.snowdogstudios.launcher;

import com.snowdogstudios.util.Logger;
import com.snowdogstudios.crashes.CrashReporter;
import com.snowdogstudios.launcher.window.Window;
import com.snowdogstudios.launcher.updater.Updater;

public class Launcher {
	public static String status = "ready";
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
			Runtime r = Runtime.getRuntime();
			r.exec("java build.Main");
		} catch (Exception e) {
			reporter.report(e.toString());
		}
	}
}
