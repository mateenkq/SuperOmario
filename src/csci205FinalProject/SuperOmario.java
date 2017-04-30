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
import csci205FinalProject.Sprite.Coffee;
import csci205FinalProject.Sprite.Enemy;
import csci205FinalProject.Sprite.EnemyManager;
import csci205FinalProject.Sprite.ImageViewSprite;
import csci205FinalProject.Sprite.Life;
import csci205FinalProject.Sprite.Platform;
import csci205FinalProject.Sprite.Player;
import csci205FinalProject.Sprite.SpriteManager;
import java.net.URL;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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

    private static MediaPlayer mediaPlayer;
    private int lives;
    private Text livesDisplay;
    private boolean collision = false;

    private boolean scrolling = false;

    private int coffees;
    private Text coffeesDisplay;

    private ImageViewSprite anim;

    Pane backgroundLayer;

    ImageView imageViewMario;

    ImageView startMenu;
    private Text pauseText;

    private BackgroundManager backgroundManager;
    private EnemyManager enemyManager;

    private boolean gameOver = false;

    public SuperOmario(int framesPerSec, String title) {
        super(framesPerSec, title);
        playerManager = null;
        player = null;

    }

    @Override
    public void handle(KeyEvent key) {
        if (key.getCode() == KeyCode.RIGHT) {

            this.anim.getImageView().setImage(new Image(
                    "/spritesheet2.png"));
            if (player.onGround()) {

                anim.start();

            }
            if (player.getPositionX() >= (this.getGameScene().getWidth() / 2)) {

                //make sure game scene won't scroll beyond background image
                if (-(this.background.getPositionX()) >= (this.background.getNode().getFitWidth() - this.getGameScene().getWidth())) {

                    stopScrolling();
                    player.setVelocityX(80);

                    //make sure player cant go past edge of image
                    if (player.getPositionX() >= this.getGameScene().getWidth()) {
                        player.setVelocityX(0);
                    }
                }
                else {
                    scroll(-80);
                }
            }
            else {
                player.setVelocityX(80);
            }

            key.consume();

        }
        else if (key.getCode() == KeyCode.LEFT) {

            this.anim.getImageView().setImage(new Image(
                    "/spritesheet_flipped2.png"));
            if (player.onGround()) {

                anim.start();
            }
            if (player.getPositionX() <= (this.getGameScene().getWidth() / 4)) {
                //make sure game scene won't scroll beyond background image
                if (-(this.background.getPositionX()) <= 0) {

                    stopScrolling();
                    player.setVelocityX(-80);

                    //make sure player cant go past edge of image
                    if (player.getPositionX() <= 0.0) {
                        player.setVelocityX(0);
                    }

                }
                else {
                    scroll(80);
                }
            }
            else {
                player.setVelocityX(-80);
            }
            key.consume();

        }
        else if (key.getCode() == KeyCode.UP && player.onGround() == true) {
            player.addVelocityY(-300);
            player.setOnGround(false);
        }
        else if (key.getCode() == KeyCode.P) {
            getGameLoop().stop();
        }
        else if (key.getCode() == KeyCode.S && !this.gameOver) {
            getSceneNodes().getChildren().remove(startMenu);
            getGameLoop().start();
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

        backgroundLayer.getChildren().add(
                backgroundImageView);

        this.getSceneNodes().getChildren().add(backgroundLayer);
        backgroundLayer.toBack();

        player = new Player(this);

        //set player image
        imageViewMario = (ImageView) player.node;
        this.anim = new ImageViewSprite(imageViewMario,
                                        new Image(
                                                "/spritesheet2.png"),
                                        7,
                                        1, 7,
                                        38, 60,
                                        7);
        backgroundManager = new BackgroundManager(this);
        enemyManager = new EnemyManager(this);

        //play music
        playMusic();

        //do bindings
        bindBackground();

        bindPlatforms();

        bindEnemies();

        bindPlayer();

        bindCoffees();

        bindLives();

        //add event handler for key press
        this.getGameScene().addEventHandler(KeyEvent.KEY_PRESSED, this);

        final AnimationTimer gameLoop = getGameLoop();

        //display lives left
        livesDisplay();

        //display number coffees had
        coffeesDisplay();

        //add event handler for key release
        setKeyReleasedHandler();

        //image that comes up at beginning of game to introduce it, press S to start
        addStartMenu();

        //text on background to explain keys
        addKeyInstructions();

        //pause game until player starts it
        getGameLoop().stop();
    }

    public void addKeyInstructions() {
        pauseText = new Text((getGameScene().getWidth() - 110), 12,
                             "Arrow keys to move\nPress 'p' to pause\nPress 's' to start");
        pauseText.setFont(new Font("Arial", 12));
        pauseText.setFill(Color.WHITE);
        getSceneNodes().getChildren().add(pauseText);

        double propXPos = pauseText.getX() / getGameScene().getWidth();

        pauseText.xProperty().bind(
                getGameScene().widthProperty().multiply(propXPos));
    }

    public void addStartMenu() {
        startMenu = new ImageView(
                getClass().getResource("/spritesheet2.png").toExternalForm());
        startMenu.setX((getGameScene().getWidth() / 3));
        startMenu.setY(
                (getGameScene().getHeight() / 3));

        getSceneNodes().getChildren().add(startMenu);
    }

    public void scroll(double velocity) {
        setScrollSpeed(velocity);
        player.setVelocityX(0);
        this.background.setVelocityX(getScrollSpeed());
        for (Platform i : this.backgroundManager.getPlatforms()) {
            i.setVelocityX(getScrollSpeed());
        }
        for (Coffee i : this.backgroundManager.getCoffees()) {
            i.setVelocityX(getScrollSpeed());
        }
//        for (Enemy j : this.enemyManager.getEnemies()) {
        if (!scrolling) {
//                j.addVelocityX(-80);
            scrolling = true;
        }
//        }
    }

    public void stopScrolling() {
        this.background.setVelocityX(0);
        for (Platform i : this.backgroundManager.getPlatforms()) {
            i.setVelocityX(0);
        }
        for (Coffee i : this.backgroundManager.getCoffees()) {
            i.setVelocityX(0);
        }
//        for (Enemy j : this.enemyManager.getEnemies()) {
        if (scrolling) {
//                j.addVelocityX(80);
            scrolling = false;
        }
//
//        }
    }

    public void livesDisplay() {
        lives = 3;
        livesDisplay = new Text(0, 12, String.format("Lives: "));
        livesDisplay.setFont(new Font("Arial", 15));
        livesDisplay.setFill(Color.WHITE);
        getSceneNodes().getChildren().add(livesDisplay);
    }

    public void coffeesDisplay() {
        coffees = 0;
        coffeesDisplay = new Text(0, 30,
                                  String.format("Coffees: %d",
                                                coffees));
        coffeesDisplay.setFont(new Font("Arial", 15));
        coffeesDisplay.setFill(Color.WHITE);
        getSceneNodes().getChildren().add(coffeesDisplay);

        double propXPos = coffeesDisplay.getX() / getGameScene().getWidth();

        coffeesDisplay.xProperty().bind(
                getGameScene().widthProperty().multiply(propXPos));
    }

    public void bindPlayer() {
        player.getNode().fitHeightProperty().bind(
                getGameScene().heightProperty().multiply(player.getPropHeight()));
        player.getNode().fitWidthProperty().bind(
                getGameScene().heightProperty().multiply(
                        player.getPropHeight()).multiply(player.getPropRatio()));
    }

    public void bindEnemies() {
        for (Enemy j : enemyManager.getEnemies()) {

            j.getNode().fitWidthProperty().bind(
                    getGameScene().widthProperty().multiply(j.getPropWidth()));
            //width is based on the height
            j.getNode().fitHeightProperty().bind(
                    getGameScene().heightProperty().multiply(j.getPropHeight()));
        }
    }

    public void bindPlatforms() {
        for (Platform i : backgroundManager.getPlatforms()) {

            i.getNode().xProperty().bind(
                    getGameScene().widthProperty().multiply(
                            i.getPropXPos()));
            i.getNode().yProperty().bind(
                    getGameScene().heightProperty().multiply(
                            i.getPropYPos()));
            i.getNode().heightProperty().bind(
                    getGameScene().heightProperty().multiply(
                            i.getPropHeight()));
            i.getNode().widthProperty().bind(
                    getGameScene().widthProperty().multiply(i.getPropWidth()));

        }
    }

    public void bindCoffees() {
        for (Coffee i : backgroundManager.getCoffees()) {

            i.getNode().xProperty().bind(
                    getGameScene().widthProperty().multiply(
                            i.getPropXPos()));
            i.getNode().yProperty().bind(
                    getGameScene().heightProperty().multiply(
                            i.getPropCenter()));
            i.getNode().fitHeightProperty().bind(
                    getGameScene().heightProperty().multiply(
                            i.getPropHeight()));
            i.getNode().fitWidthProperty().bind(
                    getGameScene().heightProperty().multiply(
                            i.getPropHeight()).multiply(i.getPropRatio()));

        }
    }

    public void bindLives() {

        for (Life i : backgroundManager.getLives()) {

            i.getNode().xProperty().bind(
                    getGameScene().widthProperty().multiply(
                            i.getPropXPos()));
            i.getNode().yProperty().bind(
                    getGameScene().heightProperty().multiply(
                            i.getPropYPos()));
            i.getNode().fitHeightProperty().bind(
                    getGameScene().heightProperty().multiply(
                            i.getPropHeight()));
            i.getNode().fitWidthProperty().bind(
                    getGameScene().heightProperty().multiply(
                            i.getPropHeight()));

        }

    }

    public void playMusic() {
        // music for start menu
        final URL resource = getClass().getResource("/omario.mp3");
        final Media media = new Media(resource.toString());
        this.mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public void playGameOverMusic() {
        //final URL resource = getClass().getResource("/game_over");
        final AudioClip gameOver = new AudioClip(getClass().getResource(
                "/game_over.mp3").toExternalForm());
        gameOver.play();

    }

    public void bindBackground() {
        backgroundImageView.fitWidthProperty().bind(
                getGameScene().widthProperty().multiply(2));
        backgroundImageView.fitHeightProperty().bind(
                getGameScene().heightProperty());
    }

    private void setKeyReleasedHandler() {
        this.getGameScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent key) {
                if (key.getCode() == KeyCode.RIGHT) {
                    anim.stop();
                    player.setVelocityX(0);
                    stopScrolling();
                }
                else if (key.getCode() == KeyCode.LEFT) {
                    player.setVelocityX(0);
                    anim.stop();
                    stopScrolling();
                }

            }
        });
    }

    @Override
    public void updateSprites(double time) {
        if (background != null) {
            background.update(time);
        }
        if (player != null) {
//            player.isOnGround();
            if (player.onGround() && player.getVelocityX() != 0) {
                anim.start();
            }
            player.update(time);
            //if player falls through floor of game
            if (player.getPositionY() >= getGameScene().getHeight() + 500) {
                player.setPosition(0, 0);
                lives -= 1;
                livesDisplay.setText(String.format("Lives Left: %d",
                                                   lives));
            }

            if (this.lives == 0) {
                // TODO: Uncomment these lines once we have a working level
//                getGameLoop().stop();
//                this.gameOver = true;
            }
//          player.render(this.getGc());
        }
        if (enemyManager != null) {
            for (int i = 0; i < enemyManager.getEnemies().size(); i++) {
                this.enemyManager.getEnemies().get(i).update(time);
            }
        }
        if (backgroundManager != null) {
            for (Platform i : backgroundManager.getPlatforms()) {
                i.update(time);

            }
            for (Coffee j : backgroundManager.getCoffees()) {
                j.update(time);
            }
        }

    }

    @Override
    public void checkCollisons() {
        if (backgroundManager != null) {
            for (Platform i : backgroundManager.getPlatforms()) {
                //player lands on top of platform
                if (i.intersects(player) && (player.getVelocityY() >= 0)) {
                    double playerFeet = player.getPositionY() + player.getHeight();
                    //if the player's feet are within the platform
                    if (playerFeet <= (i.getPositionY() + i.getHeight() + 1)) {
                        player.setVelocityY(0);
                        // Y position for both sprites is at the top left corner
                        // set player on top of platform
                        double newY = i.getPositionY() - player.getHeight();
                        player.setPosition(player.getPositionX(), newY);
                        player.setOnGround(true);
                    }

                }
            }
            boolean hitCoffee = false;
            int coffeeNum = 0;
            for (int i = 0; i < backgroundManager.getCoffees().size(); i++) {
                if (backgroundManager.getCoffees().get(i).intersects(player)) {
                    hitCoffee = true;
                    coffeeNum = i;
                }
            }
            if (hitCoffee) {
                backgroundManager.remove(backgroundManager.getCoffees().get(
                        coffeeNum));
                coffees += 1;
                coffeesDisplay.setText(String.format("Coffees: %d",
                                                     coffees));
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
                    } //only lose life when collision begins, not continuously throughout collision
                    else if (!collision) {
                        lives -= 1;
                        if (lives == 0) {
                            playGameOverMusic();
                        }
                        int lastLife = backgroundManager.getLives().size() - 1;
                        backgroundManager.remove(
                                backgroundManager.getLives().get(lastLife));

                        collision = true;
                    }
                }
            }
            if (topCollision) {
                //enemy dissapears
                enemyManager.remove(enemyManager.getEnemies().get(
                        enemyNum));
                //bounce off enemy
                if (player.getVelocityY() > 200) {
                    player.addVelocityY(-400);
                }
                else {
                    player.addVelocityY(-200);
                }
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
        boolean xInRange = ((enemyXPos - 10) <= player.getPositionX()) && (player.getPositionX() < (enemyXPos + 10));
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

    public boolean isScrolling() {
        return scrolling;
    }

}
