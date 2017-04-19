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

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * Rendering visual components of game objects
 *
 * @author Morgan
 */
public class GameView {

    //create a root node
    StackPane root;

    // create layer for the background
    public static Pane backgroundLayer;

    // ImageView object for the background
    ImageView backgroundImageView;

    public GameView() {
//        this.root = new Group();
//        backgroundLayer = new Pane();
//        root.getChildren().add(backgroundLayer);

//        backgroundImageView = new ImageView(getClass().getResource(
//                ("src/resources/background.png")).toExternalForm());
//
//        backgroundImageView.relocate(0,
//                                     -backgroundImageView.getImage().getHeight() + GameMain.SCENE_HEIGHT);
//        backgroundLayer.getChildren().add(backgroundImageView);
    }

    public StackPane getRoot() {
        return root;
    }

    public Pane getBackgroundLayer() {
        return backgroundLayer;
    }

}
