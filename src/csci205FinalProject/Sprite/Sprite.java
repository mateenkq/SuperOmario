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
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 *
 * @author Morgan and Mateen
 * @see
 * https://github.com/tutsplus/Introduction-to-JavaFX-for-Game-Development/blob/master/Sprite.java
 */
public class Sprite {

    protected Image image;
    protected ImageView imageView;
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double accelerationX;
    private double accelerationY;
    private double width;
    private double height;

    public Node node;

    public Sprite() {
        positionX = 0;
        positionY = 0;
        velocityX = 0;
        velocityY = 0;

        node = new Circle();

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
        node.setTranslateX(positionX);
        node.setTranslateY(positionY);
    }

    public void setVelocity(double x, double y) {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocityX(double x) {
        velocityX += x;
    }

    public void addVelocityY(double y) {
        velocityY += y;
    }

    public void setAccelerationX(double accelerationX) {
        this.accelerationX = accelerationX;

    }

    public void setAccelerationY(double accelerationY) {
        this.accelerationY = accelerationY;
    }

    public void changeVelocity(double time) {
        velocityX += (this.accelerationX * time);
        velocityY += (this.accelerationY * time);
    }

    /**
     * Takes in the current time and calculates what the new position should be
     * based on the current velocity
     *
     * @param time
     */
    public void update(double time) {
        this.changeVelocity(time);
        positionX += velocityX * time;
        positionY += velocityY * time;
        node.setTranslateX(positionX);
        node.setTranslateY(positionY);
        this.imageView.setX(positionX);
        this.imageView.setY(positionY);

    }

    /**
     * Given a GraphicsContext object, draws an image at the location specified
     * by the positionX and positionY of the Sprite object using the width and
     * the height of the given image
     *
     * @param gc
     */
//    public void render(GraphicsContext gc) {
//
//        gc.drawImage(image, positionX, positionY);
//    }
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

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public Image getImage() {
        return this.image;
    }

}
