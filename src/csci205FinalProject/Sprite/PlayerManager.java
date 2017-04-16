/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Still going to decide on
* Date: Apr 15, 2017
* Time: 8:59:22 PM
*
* Project: csci205FinalProject
* Package: csci205FinalProject.Sprite
* File: PlayerManager
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
public class PlayerManager extends SpriteAnimate implements
        EventHandler<KeyEvent> {

    private Sprite playerSprite;
    private GameWorld game;

    public PlayerManager(GameWorld g) {
        super(1);
        game = g;
        this.playerSprite = new Player(game);
        this.playerSprite.node.addEventHandler(KeyEvent.ANY, this);
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println("Key Pressed");
        if (event.getCode() == KeyCode.DOWN) {
            System.out.println("DOWN");
        }
    }

}
