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

    private double propHeight;
    private double propWidth;

    private Platform platform;

    //either 80 or -80 depending on direction of scroll
    private static double scrollSpeed;
    private static double BASE_VELOCITY = 50;

    public Enemy(GameWorld g, Platform p) {
        super();
        game = g;
        width = 15;
        height = 7;
        this.node = new Rectangle(height, width, Color.RED);

        //set on top of platform
        this.rightEdge = p.getPositionX() + p.getWidth();
        this.leftEdge = p.getPositionX();

        this.setPosition(leftEdge,
                         (p.getPositionY() - (this.getHeight())));

        this.setDimensions(width, height);
        this.setVelocityX(BASE_VELOCITY);

        //ratios for bindings based on initial game dimensions
        propHeight = this.getHeight() / game.getGameScene().getHeight();
        propWidth = this.getWidth() / game.getGameScene().getWidth();

        this.platform = p;

        scrollSpeed = game.getScrollSpeed();

        g.getSceneNodes().getChildren().add(node);

    }

    public void updateEdges() {

        this.rightEdge = this.platform.getPositionX() + this.platform.getWidth();
        this.leftEdge = this.platform.getPositionX();
    }

    //reverse direction at end of platform
    public void updateVelocity() {
        boolean nearRightEdge = ((rightEdge - this.getWidth() - 1) <= this.getPositionX());
        boolean nearLeftEdge = (this.getPositionX() <= leftEdge + 1);

        //if we start scrolling
        if (game.isScrolling()) {
            scrollSpeed = game.getScrollSpeed();
            //going left
            if (this.getVelocityX() < 0) {
                this.setVelocityX((scrollSpeed / 2) - BASE_VELOCITY);
                //if near left edge
                if (nearLeftEdge) {
                    this.setVelocityX((scrollSpeed / 2) + BASE_VELOCITY);
                }
            }
            //going right
            else if (this.getVelocityX() > 0) {
                this.setVelocityX((scrollSpeed / 2) + BASE_VELOCITY);
                //if near right edge
                if (nearRightEdge) {
                    this.setVelocityX((scrollSpeed / 2) - BASE_VELOCITY);
                }
            }
        }
        //if we stop scrolling
        else if (!game.isScrolling()) {
            scrollSpeed = game.getScrollSpeed();
            //going left
            if (this.getVelocityX() < 0) {
                this.setVelocityX(-(BASE_VELOCITY));
                //if near left edge
                if (nearLeftEdge) {
                    this.setVelocityX(BASE_VELOCITY);
                }
            }
            else if (this.getVelocityX() > 0) {
                this.setVelocityX(BASE_VELOCITY);
                if (nearRightEdge) {
                    this.setVelocityX(-BASE_VELOCITY);
                }
            }
        }
        //if near edges, reverse direction
        else if ((nearRightEdge && (this.getVelocityX() > 0)) || (nearLeftEdge && (this.getVelocityX() < 0))) {
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

    public Platform getPlatform() {
        return platform;
    }

    public double getPropHeight() {
        return propHeight;
    }

    public double getPropWidth() {
        return propWidth;
    }

    @Override
    public Rectangle getNode() {
        return (Rectangle) this.node;
    }

    @Override
    public void update(double time) {
        super.update(time);

        updateEdges();
        updateVelocity();

        super.update(time);

        this.setPosition(this.getPositionX(),
                         (this.platform.getPositionY() - (this.getHeight())));

    }

}
