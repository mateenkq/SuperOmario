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

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Laura
 */
public class GameWorld {

    //the JavaFX scene
    private Scene gameScene;

    //all nodes in the scene
    private Group sceneNodes;

    //Timeline is a subclass of animation which runs a certain number of frames per second
    private static Timeline gameLoop;

    //Number of frames per second
    private final int framesPerSec;

    //The title of the game window
    private final String title;

    private GameView theView;

    private Background scrollingBackground;

    /**
     * The Sprite Manager (to be built later)
     *
     */
    //private final SpriteManager spriteManager = new SpriteManager();
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
        this.scrollingBackground = new Background();

        //this method will come later
        //buildAndSetGameLoop();
    }

    /**
     * Build and set the gameLoop
     */
    protected final void buildAndSetGameLoop() {

        //convert framesPerSec into duration of each frame
        final Duration frameDuration = Duration.millis(
                1000 / getFramesPerSecond());
        //create frame
        final KeyFrame frame = new KeyFrame(frameDuration,
                                            new EventHandler() {

                                        @Override
                                        public void handle(Event event) {
                                            //updateSprites();
                                            //checkCollisions();
                                            //cleanupSprites();
                                        }
                                    });

        //sets the gameLoop
        setGameLoop(
                TimelineBuilder.create().cycleCount(Animation.INDEFINITE).keyFrames(
                        frame).build());
    }

    /**
     * Initialize the gameWorld
     *
     * @param primaryStage
     */
    public void initialize(final Stage primaryStage) {
        // This is where we will set up all of the visuals
        primaryStage.setTitle(getTitle());

        theView = new GameView(this);

        setSceneNodes(theView.getSceneNodes());

        setGameScene(new Scene(theView.getRoot(), GameView.WIDTH.get() * 2,
                               GameView.HEIGHT.get() * 2));

        theView.loadView();

        primaryStage.setScene(getGameScene());

        // this is where we set up the game loop
        // and we make all our environments
    }

    /**
     * Starts game loop
     */
    public void beginGameLoop() {
        getGameLoop().play();
    }

    private int getFramesPerSecond() {
        return this.framesPerSec;
    }

    public String getTitle() {
        return title;
    }

    public static Timeline getGameLoop() {
        return gameLoop;
    }

    public static void setGameLoop(Timeline gameLoop) {
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

    public Background getBackground() {
        return this.scrollingBackground;
    }

}
