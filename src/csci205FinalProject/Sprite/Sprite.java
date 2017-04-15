/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Still going to decide on
* Date: Apr 12, 2017
* Time: 10:29:45 AM
*
* Project: csci205FinalProject
* Package: csci205FinalProject
* File: Sprite
* Description:
*
* ****************************************
 */
package csci205FinalProject;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author Morgan
 */
public class Sprite {

    private Image image;
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
//    private double accelerationX;
//    private double accelerationY;
    private double width;
    private double height;

    /**
     * Takes in the current time and calculates what the new position should be
     * based on the current velocity
     *
     * @param time
     */
    public void update(double time) {
        positionX += velocityX * time;
        positionY += velocityY * time;
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX, positionY, width, height);
    }

    public boolean intersects(Sprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

}
