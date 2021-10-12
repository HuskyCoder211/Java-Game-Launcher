package Application;

import build.Game;
import Application.Log.Logger;

public class Launcher {
	public static String status = "ready";
	public static void main(String[] args) {
		new Window();
	}
	public static void launch() {
		
		//atemps to run the unzipped file using the path "build.Launcher"
		Game game = new Game();
		game.start();
		
	}
}
