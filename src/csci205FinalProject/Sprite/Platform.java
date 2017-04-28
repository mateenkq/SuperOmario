/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Still going to decide on
* Date: Apr 20, 2017
* Time: 10:38:51 PM
*
* Project: csci205FinalProject
* Package: csci205FinalProject.Sprite
* File: Platform
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
 * @author Morgan
 */
public class Platform extends Sprite {

    private GameWorld game;

    private Double propYPos;
    private Double propXPos;

    Double propHeight;
    Double propWidth;

    public Platform(GameWorld g, double width, double height, double x, double y) {
        super();
        game = g;
        this.node = new Rectangle(width, height, Color.DARKGREEN);
        this.setPosition(x, y);

        this.propYPos = y / g.getGameScene().getHeight();
        propXPos = x / g.getGameScene().getWidth();

        propHeight = height / g.getGameScene().getHeight();
        propWidth = width / g.getGameScene().getWidth();

//        propYPos = new ReadOnlyDoubleWrapper(y / g.getGameScene().getHeight()).getReadOnlyProperty();
        this.setDimensions(width, height);

        g.getSceneNodes().getChildren().add(node);
    }

    @Override
    public Rectangle getNode() {
        return (Rectangle) this.node;
    }

    public Double getPropYPos() {
        return propYPos;
    }

    public Double getPropXPos() {
        return propXPos;
    }

    public Double getPropHeight() {
        return propHeight;
    }

    public Double getPropWidth() {
        return propWidth;
    }

    @Override
    public void update(double time) {
        positionX += velocityX * time;
        positionY += velocityY * time;
        node.relocate(positionX, positionY);
//        positionX = this.getNode().xProperty().getValue();
        positionY = this.getNode().yProperty().getValue();

    }

}
