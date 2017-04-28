/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Still going to decide on
* Date: Apr 28, 2017
* Time: 1:25:03 AM
*
* Project: csci205FinalProject
* Package: csci205FinalProject.Sprite
* File: Background
* Description:
*
* ****************************************
 */
package csci205FinalProject.Sprite;

import csci205FinalProject.GameWorld;
import javafx.scene.image.ImageView;

/**
 *
 * @author Morgan
 */
public class Background extends Sprite {

    public Background(GameWorld g) {
        super();
        this.node = new ImageView(getClass().getResource(
                "/background.png").toExternalForm());
        node.relocate(0, 0);
    }

    @Override
    public ImageView getNode() {
        return (ImageView) node;
    }

    public void update(double time) {
        super.update(time);
        node.relocate(positionX, positionY);

    }

}
