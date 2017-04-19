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

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
    private static Timeline gameLoop;

    //Number of frames per second
    private final int framesPerSec;

    //The title of the game window
    private final String title;

    private GraphicsContext gc;

    private Canvas canvas;

    ImageView backgroundImageView;
    // This defines the scrolling speed of the background
    double backgroundScrollSpeed = 0.5;

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
        backgroundImageView = new ImageView(getClass().getResource(
                "/background.png").toExternalForm());
        backgroundImageView.relocate(0,
                                     -backgroundImageView.getImage().getHeight() + GameMain.SCENE_HEIGHT);

    }

    /**
     * Build and set the gameLoop
     */
    protected final void buildAndSetGameLoop() {

        //convert framesPerSec into duration of each frame
        final Duration frameDuration = Duration.millis(
                1000 / getFramesPerSecond());
        //create frame
//        final KeyFrame frame = new KeyFrame(frameDuration,
//                                            new EventHandler() {
//
//                                        @Override
//                                        public void handle(long currentTime) {
//                                            updateSprites(
//                                                    frameDuration.toSeconds());
//                                            //checkCollisions();
//                                            //cleanupSprites();
//                                            // scroll background
//                                            //calculate new position
//                                            double y = backgroundImageView.getLayoutY() + backgroundScrollSpeed;
//
//                                            // check bounds. Scrolling upwards
//                                            if (Double.compare(y, 0) >= 0) {
//                                                y = 0;
//                                            }
//
//                                            // move the background
//                                            backgroundImageView.setLayoutY(y);
//                                        }
//                                    });
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                updateSprites(frameDuration.toSeconds());
            }
        }.start();

//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long l
//            ) {
//                updateSprites()
//            }
//
//        };
        //sets the gameLoop
//        final Timeline timeline = new Timeline();
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.getKeyFrames().add(frame);
//        setGameLoop(timeline);s
    }

    public abstract void updateSprites(double time);

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

    public GraphicsContext getGc() {
        return gc;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void handle(KeyEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
