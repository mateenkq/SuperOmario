/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Still going to decide on
* Date: Apr 15, 2017
* Time: 8:54:00 PM
*
* Project: csci205FinalProject
* Package: csci205FinalProject.Sprite
* File: Player
* Description:
*
* ****************************************
 */
package csci205FinalProject.Sprite;

import csci205FinalProject.GameWorld;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Morgan
 */
public class Player extends Sprite implements EventHandler<KeyEvent> {

    private int lives;

    private GameWorld game;

    public Player(GameWorld g) {
        super();
        game = g;
        System.out.println(game.toString());
        System.out.println(game.getSceneNodes().toString());
        System.out.println(game.getSceneNodes().getChildren().toString());
        game.getSceneNodes().getChildren().add(node);

    }

    @Override
    public void handle(KeyEvent key) {
        if (key.getCode() == KeyCode.RIGHT && key.getEventType() == KeyEvent.KEY_PRESSED) {
            System.out.println("RIGHT");
        }
    }

}
