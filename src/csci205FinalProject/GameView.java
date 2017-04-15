/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Still going to decide on
* Date: Apr 10, 2017
* Time: 10:24:01 AM
*
* Project: csci205FinalProject
* Package: csci205FinalProject
* File: GameView
* Description:
*
* ****************************************
 */
package csci205FinalProject;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;

/**
 * Rendering visual components of game objects
 *
 * @author Morgan
 */
public class GameView {

    /* size of the view */
    public static final ReadOnlyDoubleProperty WIDTH = new ReadOnlyDoubleWrapper(
            480).getReadOnlyProperty();
    public static final ReadOnlyDoubleProperty HEIGHT = new ReadOnlyDoubleWrapper(
            240).getReadOnlyProperty();

    /* LIMITS FOR SCROLLING */
    public static final ReadOnlyDoubleProperty LIMIT_LOW = new ReadOnlyDoubleWrapper(
            80).getReadOnlyProperty();
    public static final ReadOnlyDoubleProperty LIMIT_HIGH = new ReadOnlyDoubleWrapper(
            240).getReadOnlyProperty();

    /* POSITION IN WORLD (BOTTOM LEFT CORNER) */
    private final DoubleProperty x = new SimpleDoubleProperty(-80);
    private final DoubleProperty y = new SimpleDoubleProperty(-32);

    private Group sceneNodes;
    private AnchorPane root = new AnchorPane();

    private GameWorld world;

    public GameView(GameWorld w) {
        sceneNodes = new Group();
        this.world = w;

        Scale viewScale = Transform.scale(1, 1, 0, 0);
        viewScale.xProperty().bind(root.widthProperty().divide(GameView.WIDTH));
        viewScale.yProperty().bind(root.heightProperty().divide(GameView.HEIGHT));
        sceneNodes.getTransforms().add(viewScale);

        sceneNodes.setFocusTraversable(true);

        root.getChildren().add(sceneNodes);

    }

    public void loadView() {
        sceneNodes.getChildren().add(world.getBackground().getNode());
    }

    public Group getSceneNodes() {
        return sceneNodes;
    }

    public AnchorPane getRoot() {
        return root;
    }

    public static ReadOnlyDoubleProperty getWIDTH() {
        return WIDTH;
    }

    public static ReadOnlyDoubleProperty getHEIGHT() {
        return HEIGHT;
    }

    public static ReadOnlyDoubleProperty getLIMIT_LOW() {
        return LIMIT_LOW;
    }

    public static ReadOnlyDoubleProperty getLIMIT_HIGH() {
        return LIMIT_HIGH;
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public DoubleProperty yProperty() {
        return y;
    }

}
