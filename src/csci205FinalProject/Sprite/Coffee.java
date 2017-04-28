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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Laura
 */
public class Coffee extends Sprite {

    private GameWorld game;

    public Coffee(GameWorld g, double width, double height) {
        super();
        game = g;
        this.node = new Circle(width, Color.YELLOW);

        this.setDimensions(width, height);

        g.getSceneNodes().getChildren().add(node);

    }

    @Override
    public Circle getNode() {
        return (Circle) this.node;
    }

    @Override
    public void update(double time) {
        positionX = this.getNode().centerXProperty().getValue();
        positionY = this.getNode().centerYProperty().getValue();
//        this.changeVelocity(time);
//        positionX += velocityX * time;
//        positionY += velocityY * time;
        node.relocate(positionX, positionY);

    }

}
