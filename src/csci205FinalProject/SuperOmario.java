/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Still going to decide on
* Date: Apr 15, 2017
* Time: 2:22:50 AM
*
* Project: csci205FinalProject
* Package: csci205FinalProject
* File: SuperOmario
* Description:
*
* ****************************************
 */
package csci205FinalProject;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class SuperOmario extends GameWorld {

    //number of sprites currently in frame
    private final static Label NUM_SPRITES = new Label();

    public SuperOmario(int framesPerSec, String title) {
        super(framesPerSec, title);
    }

    public void initialize(final Stage primaryStage) {

        //Set the game's title
        primaryStage.setTitle(getTitle());

        //Create the scene
        setSceneNodes(new Group());
        setGameScene(new Scene(getSceneNodes()));
        primaryStage.setScene(getGameScene());

        //create a button to freeze the gameLoop
        final Timeline gameLoop = getGameLoop();
        Button freezeBtn = new Button("Freeze/Resume");
        freezeBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                switch (gameLoop.getStatus()) {
                    case RUNNING:
                        gameLoop.stop();
                        break;
                    case STOPPED:
                        gameLoop.play();
                        break;
                }
            }
        }
        );
    }

    //idk why the handle method inside the initialize method wasn't enough, but apparently not all abstract methods have been declared without this
    @Override
    public void handle(ActionEvent event) {
        System.out.println("handled");
    }
}
