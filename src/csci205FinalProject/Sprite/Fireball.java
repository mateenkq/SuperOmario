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
* File: Fireball
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
public class Fireball extends Sprite {

    GameWorld game;
    double RADIUS;

    public Fireball(GameWorld g, double velocity, double x,
                    double y) {
        super();
        game = g;
        RADIUS = 7;
        this.node = new Circle(RADIUS, Color.RED);
        this.setPosition(x, y);

        this.setDimensions(RADIUS, RADIUS);
        this.setVelocityX(velocity);

        g.getSceneNodes().getChildren().add(node);
    }

}
