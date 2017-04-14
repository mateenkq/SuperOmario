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
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class GameMain extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Super Omar.io");
        primaryStage.setScene(scene);
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
