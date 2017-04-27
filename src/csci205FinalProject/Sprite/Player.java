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
import javafx.scene.image.ImageView;

/**
 *
 * @author Morgan
 */
public class Player extends Sprite {

    private int lives;

    private GameWorld game;

    private boolean onGround;

    private Double propYPos;
    private Double propXPos;

    public Player(GameWorld g) {
        super();
        this.setAccelerationY(400);
        game = g;
        this.setImage(getClass().getResource("/jm_stand.png").toExternalForm());
        this.node = new ImageView(image);
        this.node.relocate(this.getPositionX(), this.getPositionY());
//        this.nod.setRotate(r);
//        this.render(game.getGc());

        //half of ratio of height to width over intial dimensions of the game
        this.propYPos = (this.getHeight() / this.getWidth()) / (game.getGameScene().getHeight() * 2);
        propXPos = (this.getHeight() / this.getWidth()) / (game.getGameScene().getWidth() * 2);

        this.node = this.node;
        game.getSceneNodes().getChildren().add(this.node);

    }

    public void isOnGround() {
//        System.out.println("Y: " + getPositionY() + ", X: " + getPositionX());
        if (this.getPositionY() > 180) {
            this.setVelocityY(0);
            this.setPosition(getPositionX(), 179.9);
        }

    }

    public boolean onGround() {
        return onGround;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public Double getPropYPos() {
        return propYPos;
    }

    public Double getPropXPos() {
        return propXPos;
    }

}
