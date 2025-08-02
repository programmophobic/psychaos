package io.github.programmophobic.psychaos;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.programmophobic.psychaos.screens.GameScreen;

public class PsychaosGame extends Game {

    private static final String TITLE = "Project Psion";
    private static final String VERSION = "v0.1";
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;

    private SpriteBatch batch;
    private AssetManager assetManager;
    private OrthographicCamera camera;

    @Override
    public void create() {
        camera = new OrthographicCamera(1000f, 1000f * ((float) Gdx.graphics.getHeight() / Gdx.graphics.getWidth()));
        batch = new SpriteBatch();
        assetManager = new AssetManager();

        super.setScreen(new GameScreen(this));
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration conf = new Lwjgl3ApplicationConfiguration();
        conf.setTitle("Project Psion " + VERSION);
        conf.setWindowedMode(WIDTH, HEIGHT);
        new Lwjgl3Application(new PsychaosGame(), conf);
    }
}
