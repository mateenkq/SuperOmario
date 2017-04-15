/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Still going to decide on
* Date: Apr 15, 2017
* Time: 1:10:52 PM
*
* Project: csci205FinalProject
* Package: csci205FinalProject
* File: Background
* Description:
*
* ****************************************
 */
package csci205FinalProject;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Morgan
 */
public class Background {

    private final ImageView node = new ImageView();
    private GameView theView;

    public Background() {

        node.setImage(new Image(
                "C:\\Users\\Morgan\\Documents\\csci205\\csci205FinalProject\\src\\csci205FinalProject\\resources\\background.png"));
        bindNode();
    }

    /**
     * This method binds the size of the background and its position in the view
     * to the dimensions of the view, and implements the "scrolling" feature
     */
    private void bindNode() {

        node.translateXProperty().bind(new DoubleBinding() {
            {
                super.bind(theView.xProperty());
            }

            @Override
            protected double computeValue() {
                double offset = theView.xProperty().get() % GameView.WIDTH.get();
                if (offset < 0) {
                    offset += GameView.WIDTH.get();
                }

                return -offset;
            }
        });
        node.translateYProperty().bind(new SimpleDoubleProperty(32).add(
                theView.yProperty()));

    }

    public Node getNode() {
        return node;
    }

}
