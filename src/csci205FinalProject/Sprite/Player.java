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

/**
 *
 * @author Morgan
 */
public class Player extends Sprite {

    private int lives;

    private GameWorld game;

    public Player(GameWorld g) {
        super();
        game = g;
        this.setImage(".\\csci205FinalProject\\resources\\jm_stand.png");
        this.render(game.getGc());
        game.getSceneNodes().getChildren().add(node);

    }

}
