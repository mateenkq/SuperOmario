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
import csci205FinalProject.Sprite.ImageViewSprite;
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

    private ImageViewSprite anim;

    Pane backgroundLayer;

    ImageView imageViewMario;

    private BackgroundManager backgroundManager;
    private EnemyManager enemyManager;

    public SuperOmario(int framesPerSec, String title) {
        super(framesPerSec, title);
        playerManager = null;
        player = null;

    }

    @Override
    public void handle(KeyEvent key) {
        if (key.getCode() == KeyCode.RIGHT) {
            player.setVelocityX(80);

            if (player.onGround()) {
                this.anim.getImageView().setImage(new Image(
                        "/spritesheet.png"));

                anim.start();

            }
            key.consume();

        }
        else if (key.getCode() == KeyCode.LEFT) {
            player.setVelocityX(-80);
            if (player.onGround()) {
                this.anim.getImageView().setImage(new Image(
                        "/spritesheet_flipped.png"));
                anim.start();
            }
            key.consume();

        }
        else if (key.getCode() == KeyCode.UP && player.onGround() == true) {
            player.addVelocityY(-300);
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
        setGameScene(new Scene(getSceneNodes(), GameMain.SCENE_WIDTH,
                               GameMain.SCENE_HEIGHT));
        primaryStage.setScene(getGameScene());

        backgroundLayer = new Pane();

        this.setCanvas(new Canvas(GameMain.SCENE_WIDTH, GameMain.SCENE_HEIGHT));
        getSceneNodes().getChildren().add(getCanvas());
        backgroundLayer.getChildren().add(
                backgroundImageView);

        this.getSceneNodes().getChildren().add(backgroundLayer);
        backgroundLayer.toBack();

        this.setGc(getCanvas().getGraphicsContext2D());

        player = new Player(this);

        imageViewMario = (ImageView) player.node;
        this.anim = new ImageViewSprite(imageViewMario,
                                        new Image(
                                                "/spritesheet.png"),
                                        7,
                                        1, 7,
                                        19, 30,
                                        7);
        backgroundManager = new BackgroundManager(this);
        enemyManager = new EnemyManager(this);

        backgroundImageView.fitWidthProperty().bind(
                getGameScene().widthProperty().multiply(2));
        backgroundImageView.fitHeightProperty().bind(
                getGameScene().heightProperty());

        for (Platform i : backgroundManager.getPlatforms()) {

            i.getNode().xProperty().bind(
                    getGameScene().widthProperty().multiply(
                            i.getPropXPos()));
            i.getNode().yProperty().bind(
                    getGameScene().heightProperty().multiply(
                            i.getPropYPos()));

        }
        player.getNode().scaleXProperty().bind(
                getGameScene().widthProperty().multiply(player.getPropXPos()));
        player.getNode().scaleYProperty().bind(
                getGameScene().heightProperty().multiply(player.getPropYPos()));

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
                    anim.stop();
                }

            }
        });
    }

    @Override
    public void updateSprites(double time) {
        if (player != null) {
//            player.isOnGround();
            player.update(time);
//          player.render(this.getGc());
        }
        if (enemyManager != null) {
            for (int i = 0; i < enemyManager.getEnemies().size(); i++) {
                this.enemyManager.getEnemies().get(i).update(time);
                this.enemyManager.getEnemies().get(i).updateVelocity();
            }
        }
        if (backgroundManager != null) {
            int j = 0;
            for (Platform i : backgroundManager.getPlatforms()) {
                i.update(time);

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
            boolean topCollision = false;
            int enemyNum = 0;
            //check if the player has hit any fireballs
            for (int i = 0; i < enemyManager.getEnemies().size(); i++) {
                if (enemyManager.getEnemies().get(i).intersects(player)) {
                    setOpaque = true;
                    //if it killed the enemy
                    if (isTopCollision(i)) {
                        topCollision = true;
                        enemyNum = i;
                    }
                    //only lose life when collision begins, not continuously throughout collision
                    else if (!collision) {
                        lives -= 1;
                        livesDisplay.setText(String.format("Lives Left: %d",
                                                           lives));

                        collision = true;
                    }
                }
            }
            if (topCollision) {
                //enemy dissapears
                enemyManager.remove(enemyManager.getEnemies().get(
                        enemyNum));
                //bounce off enemy
                player.addVelocityY(-400);
                player.setOnGround(false);
            }
            else if (setOpaque) {
                player.getNode().setOpacity(0);
            }
            else {
                player.getNode().setOpacity(1);
                collision = false;
            }
        }
    }

    public boolean isTopCollision(int i) {
        double enemyXPos = enemyManager.getEnemies().get(i).getPositionX();
        //if the player is over the enemy
        boolean xInRange = ((enemyXPos - 5) <= player.getPositionX()) && (player.getPositionX() < (enemyXPos + 5));
        //and the player is moving down (jumping on top of enemy)
        if ((xInRange) && (player.getVelocityY() > 0)) {
            return true;
        }
        else {
            return false;
        }
    }

    public BackgroundManager getBackgroundManager() {
        return backgroundManager;
    }

}
