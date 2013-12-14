package ch.digitalmeat.ld28;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		Config gameConfig = new Config(400, 300);
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "ld28";
		cfg.useGL20 = true;
		cfg.width = gameConfig.xResolution;
		cfg.height = gameConfig.yResolution;
		
		new LwjglApplication(new ConcertSmugglers(gameConfig), cfg);
	}
}
