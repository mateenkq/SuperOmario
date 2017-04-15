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
package csci205FinalProject.Sprite;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author Morgan and Mateen
 * @see
 * https://github.com/tutsplus/Introduction-to-JavaFX-for-Game-Development/blob/master/Sprite.java
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

    public Sprite() {
        positionX = 0;
        positionY = 0;
        velocityX = 0;
        velocityY = 0;
    }

    public void setImage(Image i) {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    public void setImage(String fileName) {
        Image i = new Image(fileName);
        setImage(i);
    }

    public void setPostion(double x, double y) {
        positionX = x;
        positionY = y;
    }

    public void setVelocity(double x, double y) {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y) {
        velocityX += x;
        velocityY += y;
    }

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

    /**
     * Given a GraphicsContext object, draws an image at the location specified
     * by the positionX and positionY of the Sprite object using the width and
     * the height of the given image
     *
     * @param gc
     */
    public void render(GraphicsContext gc) {
        gc.drawImage(image, positionX, positionY);
    }

    /**
     *
     * @return a new Rectangle2D object
     */
    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX, positionY, width, height);
    }

    /**
     * A method to determine if the boundary of the current Sprite class
     * intersects with that of another Sprite object
     *
     * @param s is a Sprite object
     * @return a boolean that shows if intersection occurs.
     */
    public boolean intersects(Sprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

    public String toString() {
        return "Current Position: (" + positionX + "," + positionY + ")" + "Current Velocity: (" + velocityX + "," + velocityY + ")";
    }

}
