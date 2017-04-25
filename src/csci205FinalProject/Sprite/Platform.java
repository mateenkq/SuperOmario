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
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Morgan
 */
public class Platform extends Sprite {

    GameWorld game;

//    ReadOnlyDoubleProperty propHeight;
    Double propHeight;
    Double propWidth;

    public Platform(GameWorld g, double width, double height, double x, double y) {
        super();
        game = g;
        this.node = new Rectangle(width, height);
        this.setPosition(x, y);

        this.propHeight = y / g.getGameScene().getHeight();
        propWidth = x / g.getGameScene().getWidth();

//        propHeight = new ReadOnlyDoubleWrapper(y / g.getGameScene().getHeight()).getReadOnlyProperty();
        this.setDimensions(width, height);

        g.getSceneNodes().getChildren().add(node);
    }

    @Override
    public Rectangle getNode() {
        return (Rectangle) this.node;
    }

    public Double getPropHeight() {
        return propHeight;
    }

    public Double getPropWidth() {
        return propWidth;
    }

    @Override
    public void update(double time) {
        positionX = this.getNode().xProperty().getValue();
        positionY = this.getNode().yProperty().getValue();
//        this.changeVelocity(time);
//        positionX += velocityX * time;
//        positionY += velocityY * time;
        node.relocate(positionX, positionY);

    }

}
