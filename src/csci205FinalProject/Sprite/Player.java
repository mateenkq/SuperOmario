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

    public Player(GameWorld g) {
        super();
        this.setAccelerationY(100);
        game = g;
        this.setImage(".\\csci205FinalProject\\resources\\jm_stand.png");
        this.imageView = new ImageView(image);
        this.imageView.relocate(this.getPositionX(), this.getPositionY());
//        this.imageView.setRotate(r);
//        this.render(game.getGc());
        game.getSceneNodes().getChildren().add(this.imageView);

    }

    public void isOnGround() {
//        System.out.println("Y: " + getPositionY() + ", X: " + getPositionX());
        if (this.getPositionY() > 180) {
            this.setVelocityY(0);
//            this.setAccelerationY(0);
            this.setPostion(getPositionX(), 179);
        }

    }

}
