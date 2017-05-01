/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Still going to decide on
 * Date: Apr 27, 2017
 * Time: 6:48:08 PM
 *
 * Project: csci205FinalProject
 * Package: csci205FinalProject.Sprite
 * File: Coffee
 * Description:
 *
 * ****************************************
 */
package csci205FinalProject.Sprite;

import csci205FinalProject.GameWorld;
import javafx.scene.image.ImageView;

/**
 *
 * @author Laura
 */
public class Coffee extends Sprite {

    private GameWorld game;
    private double width;
    private double height;

    private double center;

    private double propWidth;
    private double propHeight;
    private double propRatio;
    private double propXPos;
    private double propCenter;

    public Coffee() {

    }

    public Coffee(GameWorld g, double x, double y) {
        super();
        game = g;
        this.width = 6;
        this.height = 10;

        this.setImage(getClass().getResource("/coffee.png").toExternalForm());
        this.node = new ImageView(image);

        this.setPosition(x, y);

        this.setDimensions(width, height);
        this.setVelocityY(20);

        center = y;

        //base bindings off of ratio between initial image dimensions, and initial game dimensions
        propWidth = this.getNode().getImage().getWidth() / g.getGameScene().getWidth();
        propHeight = this.getNode().getImage().getHeight() / g.getGameScene().getHeight();

        propRatio = (this.getNode().getImage().getWidth() / this.getNode().getImage().getHeight());

        propCenter = (this.getCenter() / g.getGameScene().getHeight());
        propXPos = this.getPositionX() / g.getGameScene().getWidth();

        g.getSceneNodes().getChildren().add(node);

    }

    @Override
    public ImageView getNode() {
        return (ImageView) this.node;
    }

    @Override
    public void update(double time) {
        super.update(time);

        updateVelocity();

        center = this.getNode().yProperty().getValue();
    }

    public void updateVelocity() {
        boolean belowBottom = this.getPositionY() >= (this.center + 2);
        boolean aboveTop = this.getPositionY() <= (this.center - 2);

        if (this.getVelocityY() > 0 && belowBottom) {
            this.setVelocityY(-getVelocityY());
        }
        else if (this.getVelocityY() < 0 && aboveTop) {
            this.setVelocityY(-getVelocityY());
        }
    }

    public double getPropHeight() {
        return propHeight;
    }

    public double getPropWidth() {
        return propWidth;
    }

    public double getPropXPos() {
        return propXPos;
    }

    public double getCenter() {
        return center;
    }

    public double getPropCenter() {
        return propCenter;
    }

}
