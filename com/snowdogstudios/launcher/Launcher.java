package com.snowdogstudios.launcher;

import com.snowdogstudios.util.Logger;
import com.snowdogstudios.crashes.CrashReporter;

public class Launcher {
	public static String status = "ready";
	public static void main(String[] args) {
		new Window();
	}
	public static void launch() {
		Runtime r = Runtime.getRuntime();
		r.exec("java versions.latestrelease.Main");
	}
}
