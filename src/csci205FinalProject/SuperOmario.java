/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Still going to decide on
 * Date: Apr 15, 2017
 * Time: 2:22:50 AM
 *
 * Project: csci205FinalProject
 * Package: csci205FinalProject
 * File: SuperOmario
 * Description:
 *
 * ****************************************
 */
package csci205FinalProject;

import csci205FinalProject.Sprite.Player;
import csci205FinalProject.Sprite.SpriteAnimate;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class SuperOmario extends GameWorld {

    //number of sprites currently in frame
    private final static Label NUM_SPRITES = new Label();

    /**
     * The Sprite Manager (to be built later)
     *
     */
    private SpriteAnimate playerManager;
    private Player player;
    private Button freezeBtn;

    Pane backgroundLayer;

    public SuperOmario(int framesPerSec, String title) {
        super(framesPerSec, title);
        playerManager = null;
        player = null;
    }

    @Override
    public void handle(KeyEvent key) {
        System.out.println(key.getEventType().toString());
        if (key.getCode() == KeyCode.RIGHT) {
            player.setVelocityX(40);
            key.consume();
            /// this will (eventually) call a function that makes the player go right
        }
        else if (key.getCode() == KeyCode.LEFT) {
            if (key.getEventType() == KeyEvent.KEY_PRESSED) {
                player.setVelocityX(-40);
                key.consume();
            }
            else if (key.getEventType() == KeyEvent.KEY_RELEASED) {
                player.setVelocityX(0);
            }
        }
        else if (key.getCode() == KeyCode.UP && player.getPositionY() > 176) {
            player.addVelocityY(-200);
        }
        else if (key.getCode() == KeyCode.P) {
            switch (getGameLoop().getStatus()) {
                case RUNNING:
                    getGameLoop().stop();
                    System.out.println("stopped");
                    break;
                case STOPPED:
                    getGameLoop().play();
                    System.out.println("resumed");
                    break;
            }
        }
        else if (key.getEventType() == KeyEvent.KEY_RELEASED) {
            player.setVelocityX(0);
        }

    }

    @Override
    public void initialize(final Stage primaryStage) {

        //Set the game's title
        primaryStage.setTitle(getTitle());

        //Create the scene
        setSceneNodes(new Group());
        setGameScene(new Scene(getSceneNodes()));
        primaryStage.setScene(getGameScene());

        backgroundLayer = new Pane();

        this.setCanvas(new Canvas(GameMain.SCENE_HEIGHT, GameMain.SCENE_WIDTH));
        getSceneNodes().getChildren().add(getCanvas());
        backgroundLayer.getChildren().add(
                backgroundImageView);

        this.getSceneNodes().getChildren().add(backgroundLayer);
        backgroundLayer.toBack();

        this.setGc(getCanvas().getGraphicsContext2D());

        player = new Player(this);

        this.getGameScene().addEventHandler(KeyEvent.KEY_PRESSED, this);
        final Timeline gameLoop = getGameLoop();
//        freezeBtn = new Button("Freeze/Resume");
//        getSceneNodes().getChildren().add(freezeBtn);
    }

    public ImageView getBackgroundImageView() {
        return backgroundImageView;
    }

    @Override
    public void updateSprites(double time) {
        if (player != null) {
            player.isOnGround();
            player.update(time);
//            player.render(this.getGc());
        }
    }

}
