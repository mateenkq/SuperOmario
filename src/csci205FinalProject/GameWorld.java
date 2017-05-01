/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Still going to decide on
 * Date: Apr 14, 2017
 * Time: 6:48:11 PM
 *
 * Project: csci205FinalProject
 * Package: csci205FinalProject
 * File: GameWorld
 * Description:
 * Source: https://dzone.com/articles/javafx-2-game-tutorial-part-2
 * ****************************************
 */
package csci205FinalProject;

import csci205FinalProject.Sprite.Background;
import csci205FinalProject.Sprite.BackgroundManager;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Laura
 */
public abstract class GameWorld implements EventHandler<KeyEvent> {

    //the JavaFX scene
    private Scene gameScene;

    //all nodes in the scene
    private Group sceneNodes;

    //Timeline is a subclass of animation which runs a certain number of frames per second
    private static AnimationTimer gameLoop;

    //Number of frames per second
    private final int framesPerSec;

    //The title of the game window
    private final String title;

    ImageView backgroundImageView;

    Background background;

    double scrollSpeed;

    /**
     * GameWorld constructor, sets the gameLoop
     *
     * @param framesPerSec
     * @param title
     */
    public GameWorld(final int framesPerSec, final String title) {
        this.framesPerSec = framesPerSec;
        this.title = title;

        buildAndSetGameLoop();

        //this method will come later
        background = new Background(this);
        backgroundImageView = background.getNode();

    }

    /**
     * Build and set the gameLoop
     */
    protected final void buildAndSetGameLoop() {

        //convert framesPerSec into duration of each frame
        final Duration frameDuration = Duration.millis(
                1000 / getFramesPerSecond());

        final long startNanoTime = System.nanoTime();

        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                updateSprites(frameDuration.toSeconds());
                checkCollisons();
            }
        };

        gameLoop.start();

    }

    public abstract void updateSprites(double time);

    public abstract void checkCollisons();

    /**
     * Initialize the gameWorld
     *
     * @param primaryStage
     */
    public abstract void initialize(final Stage primaryStage);

    /**
     * Starts game loop
     */
    public void beginGameLoop() {
        getGameLoop().start();
    }

    private int getFramesPerSecond() {
        return this.framesPerSec;
    }

    public String getTitle() {
        return title;
    }

    public static AnimationTimer getGameLoop() {
        return gameLoop;
    }

    public static void setGameLoop(AnimationTimer gameLoop) {
        GameWorld.gameLoop = gameLoop;
    }

    public Scene getGameScene() {
        return gameScene;
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public Group getSceneNodes() {
        return sceneNodes;
    }

    public void setSceneNodes(Group sceneNodes) {
        this.sceneNodes = sceneNodes;
    }

    public abstract BackgroundManager getBackgroundManager();

    @Override
    public void handle(KeyEvent event) {

    }

    public abstract boolean isScrolling();

    public double getScrollSpeed() {
        return scrollSpeed;
    }

    public void setScrollSpeed(double scrollSpeed) {
        this.scrollSpeed = scrollSpeed;
    }

    public Background getBackground() {
        return background;
    }

}
