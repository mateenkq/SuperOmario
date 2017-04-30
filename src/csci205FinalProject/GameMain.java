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
 *
 *
 */
public class GameMain extends Application {

    public static double SCENE_HEIGHT = 360;
    public static double SCENE_WIDTH = 750;

    //initialize a gameWorld object here, eventually will be SuperOmar.io
    GameWorld gameWorld;

    // This is the main gameLoop
    private AnimationTimer gameLoop;

    // This is a container for the background image
    ImageView backgroundImageView;

    @Override
    public void init() throws Exception {
        super.init();
        gameWorld = new SuperOmario(60, "GameTest");
        if (gameWorld.isRestart()) {
            gameWorld = new SuperOmario(60, "GameTest");
        }

    }

    @Override
    public void start(Stage primaryStage) {

        gameWorld.initialize(primaryStage);

        // create scene
        Scene scene = gameWorld.getGameScene();

        // show the stage
        primaryStage.setScene(scene);
        primaryStage.show();

        // if we want a full screen game
//        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
