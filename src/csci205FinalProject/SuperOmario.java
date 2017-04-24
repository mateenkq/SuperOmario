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

import csci205FinalProject.Sprite.BackgroundManager;
import csci205FinalProject.Sprite.EnemyManager;
import csci205FinalProject.Sprite.Platform;
import csci205FinalProject.Sprite.Player;
import csci205FinalProject.Sprite.SpriteManager;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    private SpriteManager playerManager;
    private Player player;

    private Button freezeBtn;

    private int lives;
    private Text livesDisplay;
    private boolean collision = false;

    Pane backgroundLayer;

    ImageView imageViewMario;

    public SuperOmario(int framesPerSec, String title) {
        super(framesPerSec, title);
        playerManager = null;
        player = null;
    }

    @Override
    public void handle(KeyEvent key) {
        if (key.getCode() == KeyCode.RIGHT) {
            player.setVelocityX(80);
            imageViewMario = (ImageView) player.node;
            this.anim = new ImageViewSprite(imageViewMario,
                                            new Image(
                                                    "/spritesheet.png"),
                                            7,
                                            1, 7,
                                            60, 95,
                                            7);
            anim.start();
            key.consume();
            /// this will (eventually) call a function that makes the player go right
        }
        else if (key.getCode() == KeyCode.LEFT) {
            player.setVelocityX(-80);
            key.consume();

        }
        else if (key.getCode() == KeyCode.UP && player.onGround() == true) {
            player.addVelocityY(-200);
            player.setOnGround(false);
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
        backgroundManager = new BackgroundManager(this);
        enemyManager = new EnemyManager(this);

        this.getGameScene().addEventHandler(KeyEvent.KEY_PRESSED, this);
        final Timeline gameLoop = getGameLoop();
//        freezeBtn = new Button("Freeze/Resume");
//        getSceneNodes().getChildren().add(freezeBtn);

        //display lives left
        lives = 3;
        livesDisplay = new Text(0, 12, String.format("Lives Left: %d",
                                                     lives));
        livesDisplay.setFont(new Font("Arial", 15));
        livesDisplay.setFill(Color.WHITE);
        getSceneNodes().getChildren().add(livesDisplay);

        setKeyReleasedHandler();
    }
    private BackgroundManager backgroundManager;
    private EnemyManager enemyManager;

    private void setKeyReleasedHandler() {
        this.getGameScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent key) {
                if (key.getCode() == KeyCode.RIGHT) {
                    /// change to acceleration
//                    ImageView imageViewMario = (ImageView) player.node;
//
//                    anim = new ImageViewSprite(imageViewMario,
//                                               new Image(
//                                                       "/jm_stand.png"),
//                                               1,
//                                               1, 1,
//                                               14, 30,
//                                               0);
                    anim.stop();

                    player.setVelocityX(0);
                }
                else if (key.getCode() == KeyCode.LEFT) {
                    player.setVelocityX(0);
                }

            }
        });
    }

    @Override
    public void updateSprites(double time) {
        if (player != null) {
            player.isOnGround();
            player.update(time);
//          player.render(this.getGc());
        }
        if (enemyManager != null) {
            for (int i = 0; i < enemyManager.getFireballs().size(); i++) {
                this.enemyManager.getFireballs().get(i).update(time);
            }
        }
    }

    @Override
    public void checkCollisons() {
        if (backgroundManager != null) {
            int j = 0;
            for (Platform i : backgroundManager.getPlatforms()) {
                if (i.intersects(player) && (player.getVelocityY() >= 0)) {
                    player.setVelocityY(0);
                    // Y position for both sprites is at the top left corner
                    // set position at current location of rectangle - height of player
                    double newY = i.getPositionY() - player.getHeight();
                    player.setPosition(player.getPositionX(), newY);
                    player.setOnGround(true);
                }
            }
        }
        if (enemyManager != null) {
            boolean setOpaque = false;
            //check if the player has hit any fireballs
            for (int i = 0; i < enemyManager.getFireballs().size(); i++) {
                if (enemyManager.getFireballs().get(i).intersects(player)) {
                    setOpaque = true;
                    if (!collision) {
                        lives -= 1;
                        livesDisplay.setText(String.format("Lives Left: %d",
                                                           lives));
                        collision = true;
                    }
                }
            }
            if (setOpaque) {
                player.getNode().setOpacity(0);
            }
            else {
                player.getNode().setOpacity(1);
                collision = false;
            }
        }
    }

}
