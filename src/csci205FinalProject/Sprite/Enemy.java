/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Still going to decide on
* Date: Apr 24, 2017
* Time: 4:43:05 PM
*
* Project: csci205FinalProject
* Package: csci205FinalProject.Sprite
* File: Enemy
* Description:
*
* ****************************************
 */
package csci205FinalProject.Sprite;

import csci205FinalProject.GameWorld;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Laura
 */
public class Enemy extends Sprite {

    private GameWorld game;
    private double width;
    private double height;
    private double rightEdge;
    private double leftEdge;

    public Enemy(GameWorld g, double velocity, Platform p) {
        super();
        game = g;
        width = 7;
        height = 15;
        this.node = new Rectangle(height, width, Color.RED);

        //set on top of platform
        this.rightEdge = p.getPositionX() + p.getWidth();
        this.leftEdge = p.getPositionX();
        this.setPosition(leftEdge,
                         (p.getPositionY() - (this.getHeight() / 2)));

        //bind to platform height
        //this.getNode().scaleXProperty().bind(p.getPositionY());
        this.setDimensions(width, height);
        this.setVelocityX(velocity);

        g.getSceneNodes().getChildren().add(node);
    }

    //reverse direction at end of platform
    public void updateVelocity() {
        boolean nearRightEdge = ((rightEdge - (this.getWidth() * 2) - 1) <= this.getPositionX());
        boolean nearLeftEdge = (this.getPositionX() <= (leftEdge + 1));
        if ((nearRightEdge && (this.getVelocityX() > 0)) || (nearLeftEdge && (this.getVelocityX() < 0))) {
            this.setVelocityX(-(this.getVelocityX()));
        }
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public final double getHeight() {
        return height;
    }

}
