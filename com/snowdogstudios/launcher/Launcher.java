package com.snowdogstudios.launcher;

import build.Game;
import com.snowdogstudios.util.Logger;
import build.com.snowdogstudio.launcher.Main;

public class Launcher {
	public static String status = "ready";
	public static void main(String[] args) {
		new Window();
	}
	public static void launch() {
		Main.main();
		System.exit(0);
	}
}
