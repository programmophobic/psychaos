package io.github.programmophobic.psychaos.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.programmophobic.psychaos.PsychaosGame;

public class GameScreen implements Screen {

    private final PsychaosGame game;
    private Sprite sprite;
    private InputProcessor inputProcessor;

    public GameScreen(PsychaosGame game) {
        this.game = game;

        inputProcessor = new InputProcessor() {
            @Override
            public boolean keyDown(int i) {
                return false;
            }

            @Override
            public boolean keyUp(int i) {
                return false;
            }

            @Override
            public boolean keyTyped(char c) {
                return false;
            }

            @Override
            public boolean touchDown(int i, int i1, int i2, int i3) {
                return false;
            }

            @Override
            public boolean touchUp(int i, int i1, int i2, int i3) {
                return false;
            }

            @Override
            public boolean touchCancelled(int i, int i1, int i2, int i3) {
                return false;
            }

            @Override
            public boolean touchDragged(int i, int i1, int i2) {
                return false;
            }

            @Override
            public boolean mouseMoved(int i, int i1) {
                return false;
            }

            @Override
            public boolean scrolled(float v, float v1) {
                return false;
            }
        };

        game.getAssetManager().load("player.png", Texture.class);

        game.getAssetManager().finishLoading();

        sprite = new Sprite(game.getAssetManager().get("player.png", Texture.class));

        Gdx.input.setInputProcessor(inputProcessor);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        if(game.getAssetManager().update()) {
            game.getCamera().update();
            game.getBatch().setProjectionMatrix(game.getCamera().combined);

            ScreenUtils.clear(Color.BLACK);

            game.getBatch().begin();
            sprite.draw(game.getBatch());
            game.getBatch().end();
        }
    }

    @Override
    public void resize(int i, int i1) {
        game.getCamera().viewportWidth = 1000f;
        game.getCamera().viewportHeight = 1000f * ((float) Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
        game.getCamera().update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
