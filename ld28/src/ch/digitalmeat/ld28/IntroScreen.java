package ch.digitalmeat.ld28;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class IntroScreen implements Screen {
	private Stage stage;
	private ParticleEffect effect;
	private SpriteBatch batch;
	private boolean started = false;
	public IntroScreen(){
		this.batch = new SpriteBatch();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		if(started){
			effect.update(delta);
			batch.begin();
			effect.draw(batch);
			batch.end();
		}
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		Config cfg = ConcertSmugglers.instance.config;
		stage = new Stage(cfg.xTarget, cfg.yTarget, true);
		Assets assets = ConcertSmugglers.instance.assets;
		Image image = new Image(assets.trance);
		this.effect = assets.introEffect();
		this.effect.setPosition(cfg.xTarget / 2, 0);
		Skin skin = assets.skin;
		image.scale(2f);
		float x = cfg.xTarget/2 - image.getWidth() ;
		image.setPosition(x, - image.getHeight() * 3);
		image.addAction(Actions.alpha(0));
		image.act(10);
		
		image.addAction(
				Actions.parallel(
					Actions.sequence(
						Actions.parallel(
							Actions.moveTo(x, 0, 8f)
							, Actions.alpha(1f, 3f)
						)
						, Actions.forever(
							Actions.sequence(
								Actions.moveBy(0, 30, 2.5f)
								, Actions.moveBy(0, -30, 2.5f)
							)
						)

					)
					, Actions.forever(
						Actions.sequence(
							Actions.rotateTo(-1, 3f)
							, Actions.rotateTo(1, 3f)
						)
					)
				)
		);
		Label label = new Label("You only\nget one...", skin);
		label.setPosition(20, cfg.yTarget / 2 - 5 - label.getHeight() / 2);
		label.addAction(Actions.alpha(0));
		label.act(10f);
		label.addAction(
			Actions.sequence(
				Actions.delay(10f)
				, Actions.parallel(
					Actions.fadeIn(2f)
					, Actions.run(new Runnable() {							
						@Override
						public void run() {
							effect.start();
							started = true;
						}
					})
					, Actions.forever(
						Actions.sequence(
							Actions.moveBy(0, 50f, 2f)
							, Actions.moveBy(0, -50f, 2f)
						)
					)
					, Actions.forever(
							Actions.sequence(
								Actions.rotateBy(10f, 2f)
								, Actions.rotateBy(-10f, 2f)
							)
						)
				)
			)
		);
		Label label2 = new Label("Ticket", skin);
		label2.setPosition(cfg.xTarget - label2.getWidth() - 10, cfg.yTarget / 2 - 5 - label2.getHeight() / 2);
		label2.addAction(Actions.alpha(0));
		label2.act(10f);
		label2.addAction(
			Actions.sequence(
				Actions.delay(10f)
				, Actions.parallel(
					Actions.fadeIn(2f)
					, Actions.forever(
						Actions.sequence(
							Actions.moveBy(0, 50f, 2f)
							, Actions.moveBy(0, -50f, 2f)
						)
					)
					, Actions.forever(
							Actions.sequence(
								Actions.rotateBy(10f, 2f)
								, Actions.rotateBy(-10f, 2f)
							)
						)
				)
			)
		);
		stage.addActor(image);
		stage.addActor(label);
		stage.addActor(label2);
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}

}
