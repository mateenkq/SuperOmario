/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Still going to decide on
 * Date: Apr 14, 2017
 * Time: 2:35:02 AM
 *
 * Project: csci205FinalProject
 * Package: csci205FinalProject
 * File: GameMain
 * Description:
 *
 * ****************************************
 */
package csci205FinalProject;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 * @see
 * http://wecode4fun.blogspot.com/2015/01/scrolling-background-we-create.html
 */
public class GameMain extends Application {

    public static double SCENE_HEIGHT = 240;
    public static double SCENE_WIDTH = 500;

    //initialize a gameWorld object here, eventually will be SuperOmar.io
    GameWorld gameWorld;

    // This is the main gameLoop
    private AnimationTimer gameLoop;

    // This is a container for the background image
    ImageView backgroundImageView;

    // This defines the scrolling speed of the background
    double backgroundScrollSpeed = 0.5;

    // Defines the visible components of the GUI
    public static GameView theView;

    @Override
    public void init() throws Exception {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        gameWorld = new SuperOmario(60, "GameTest");
        theView = new GameView();
    }

    @Override
    public void start(Stage primaryStage) {

        gameWorld.initialize(primaryStage);

        // create scene
        Scene scene = gameWorld.getGameScene();

        // show the stage
//        primaryStage.setScene(scene);
        primaryStage.show();

//        loadGame();
//        startGameLoop();
//        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    /**
     * loads the Game
     */
//    public void loadGame() {
//        backgroundImageView = new ImageView(getClass().getResource(
//                "/background.png").toExternalForm());
//
//        backgroundImageView.relocate(0,
//                                     -backgroundImageView.getImage().getHeight() + GameMain.SCENE_HEIGHT);
//        this.theView.getBackgroundLayer().getChildren().add(backgroundImageView);
//
//    }
    public void startGameLoop() {
        // game loop
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                // scroll background
                //calculate new position
                double y = backgroundImageView.getLayoutY() + backgroundScrollSpeed;

                // check bounds. Scrolling upwards
                if (Double.compare(y, 0) >= 0) {
                    y = 0;
                }

                // move the background
                backgroundImageView.setLayoutY(y);
            }
        };
        gameLoop.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
