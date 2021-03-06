package ch.digitalmeat.ld28;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		Config gameConfig = new Config(640, 480);
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "LD28: Concert Crashers";
		cfg.useGL20 = true;
		cfg.width = gameConfig.xResolution;
		cfg.height = gameConfig.yResolution;
		
		new LwjglApplication(new ConcertSmugglers(gameConfig), cfg);
	}
}
