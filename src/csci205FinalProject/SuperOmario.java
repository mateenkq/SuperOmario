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

import csci205FinalProject.Sprite.Player;
import csci205FinalProject.Sprite.PlayerManager;
import csci205FinalProject.Sprite.Sprite;
import csci205FinalProject.Sprite.SpriteAnimate;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class SuperOmario extends GameWorld {

    //number of sprites currently in frame
    private final static Label NUM_SPRITES = new Label();

    /**
     * The Sprite Manager (to be built later)
     *
     */
    private SpriteAnimate playerManager;
    private Sprite player;

    public SuperOmario(int framesPerSec, String title) {
        super(framesPerSec, title);
        playerManager = null;
        player = null;
    }

    @Override
    public void handle(Event event) {
        {
            switch (getGameLoop().getStatus()) {
                case RUNNING:
                    getGameLoop().stop();
                    System.out.println("stopped");
                    break;
                case STOPPED:
                    getGameLoop().play();
                    System.out.println("resumed");
                    break;
            }
        }
    }

    public void initialize(final Stage primaryStage) {

        //Set the game's title
        primaryStage.setTitle(getTitle());

        //Create the scene
        setSceneNodes(new Group());
        setGameScene(new Scene(getSceneNodes()));
        primaryStage.setScene(getGameScene());

        playerManager = new PlayerManager(this);
        player = new Player(this);

        //create a button to freeze the gameLoop
        final Timeline gameLoop = getGameLoop();
        Button freezeBtn = new Button("Freeze/Resume");
        freezeBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
        getSceneNodes().getChildren().add(freezeBtn);
    }

}
