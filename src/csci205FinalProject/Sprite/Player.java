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

    private GameWorld game;

    private boolean onGround;

    private Double propWidth;
    private Double propHeight;

    private double propRatio;

    public Player(GameWorld g) {
        super();
        this.setAccelerationY(400);
        game = g;
        this.setImage(getClass().getResource("/jm_stand.png").toExternalForm());
        this.node = new ImageView(image);
        this.node.relocate(this.getPositionX(), this.getPositionY());

        this.node = this.node;

        //base bindings off of ratio between initial image dimensions, and initial game dimensions
        propWidth = this.getNode().getImage().getWidth() / g.getGameScene().getWidth();
        propHeight = this.getNode().getImage().getHeight() / g.getGameScene().getHeight();

        propRatio = (this.getNode().getImage().getWidth() / this.getNode().getImage().getHeight());

        game.getSceneNodes().getChildren().add(this.node);

    }

    public void isOnGround() {
//        System.out.println("Y: " + getPositionY() + ", X: " + getPositionX());
        if (this.getPositionY() > 180) {
            this.setVelocityY(0);
            this.setPosition(getPositionX(), 179.9);
        }

    }

    /**
     * Takes in the current time and calculates what the new position should be
     * based on the current velocity
     *
     * @param time
     */
    @Override
    public void update(double time) {

        super.update(time);

        this.height = this.getNode().getFitHeight();
        this.width = this.getNode().getFitWidth();
    }

    public boolean onGround() {
        return onGround;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    @Override
    public ImageView getNode() {
        return (ImageView) this.node;
    }

    public Double getPropWidth() {
        return propWidth;
    }

    public Double getPropHeight() {
        return propHeight;
    }

    public double getPropRatio() {
        return propRatio;
    }

}
