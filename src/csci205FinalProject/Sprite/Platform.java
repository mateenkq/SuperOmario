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

    public Platform(GameWorld g, double width, double height, double x, double y) {
        super();
        game = g;
        this.node = new Rectangle(width, height);
        this.setPostion(x, y);

        this.setDimensions(width, height);

        g.getSceneNodes().getChildren().add(node);
    }

}
