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

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class GameMain extends Application {

    //initialize a gameWorld object here, eventually will be SuperOmar.io
    GameWorld gameWorld = new GameWorld(60, "GameTest");

    @Override
    public void start(Stage primaryStage) {

        gameWorld.initialize(primaryStage);

        gameWorld.beginGameLoop();

        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
