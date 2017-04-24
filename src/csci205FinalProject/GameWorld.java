/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Still going to decide on
 * Date: Apr 14, 2017
 * Time: 6:48:11 PM
 *
 * Project: csci205FinalProject
 * Package: csci205FinalProject
 * File: GameWorld
 * Description:
 * Source: https://dzone.com/articles/javafx-2-game-tutorial-part-2
 * ****************************************
 */
package csci205FinalProject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import tiled.core.Map;
import tiled.core.Tile;
import tiled.core.TileLayer;
import tiled.io.TMXMapReader;

/**
 *
 * @author Laura
 */
public abstract class GameWorld implements EventHandler<KeyEvent> {

    //the JavaFX scene
    private Scene gameScene;

    // The TMXMapReader object which will read in the tmx file denoting a map of tiles
    TMXMapReader mapReader = new TMXMapReader();

    Map map = null;

    TileLayer layer = null;

    //all nodes in the scene
    private Group sceneNodes;

    //Timeline is a subclass of animation which runs a certain number of frames per second
    private static Timeline gameLoop;

    //Number of frames per second
    private final int framesPerSec;

    //The title of the game window
    private final String title;

    private GraphicsContext gc;

    private Canvas canvas;

    public ImageView backgroundImageView;
    // This defines the scrolling speed of the background

    double backgroundScrollSpeed = 0.5;

    /**
     * GameWorld constructor, sets the gameLoop
     *
     * @param framesPerSec
     * @param title
     */
    public GameWorld(final int framesPerSec, final String title) {
        this.framesPerSec = framesPerSec;
        this.title = title;

        buildAndSetGameLoop();

        //this method will come later
        // read in the tmx file
        readTmxFile(
                "C:\\Users\\Mateen Qureshi\\Documents\\csci205FinalProject\\src\\csci205FinalProject\\resources\\background.tmx");
        layer = (TileLayer) map.getLayer(0);
        if (layer == null) {
            System.out.println("Can't get map layer");
            System.exit(-1);
        }
        assignBackgroundImage();
//        backgroundImageView = new ImageView(getClass().getResource(
//                "/background.png").toExternalForm());
//        backgroundImageView.relocate(0,
//                                     -backgroundImageView.getImage().getHeight() + GameMain.SCENE_HEIGHT);

    }

    /**
     * Build and set the gameLoop
     */
    protected final void buildAndSetGameLoop() {

        //convert framesPerSec into duration of each frame
        final Duration frameDuration = Duration.millis(
                1000 / getFramesPerSecond());
        //create frame
//        final KeyFrame frame = new KeyFrame(frameDuration,
//                                            new EventHandler() {
//
//                                        @Override
//                                        public void handle(long currentTime) {
//                                            updateSprites(
//                                                    frameDuration.toSeconds());
//                                            //checkCollisions();
//                                            //cleanupSprites();
//                                            // scroll background
//                                            //calculate new position
//                                            double y = backgroundImageView.getLayoutY() + backgroundScrollSpeed;
//
//                                            // check bounds. Scrolling upwards
//                                            if (Double.compare(y, 0) >= 0) {
//                                                y = 0;
//                                            }
//
//                                            // move the background
//                                            backgroundImageView.setLayoutY(y);
//                                        }
//                                    });
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                updateSprites(frameDuration.toSeconds());
            }
        }.start();

//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long l
//            ) {
//                updateSprites()
//            }
//
//        };
        //sets the gameLoop
//        final Timeline timeline = new Timeline();
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.getKeyFrames().add(frame);
//        setGameLoop(timeline);s
    }

    public abstract void updateSprites(double time);

    /**
     * Initialize the gameWorld
     *
     * @param primaryStage
     */
    public abstract void initialize(final Stage primaryStage);

    /**
     * Starts game loop
     */
    public void beginGameLoop() {
        getGameLoop().play();
    }

    public ImageView getBackgroundImageView() {
        return backgroundImageView;
    }

    private int getFramesPerSecond() {
        return this.framesPerSec;
    }

    public String getTitle() {
        return title;
    }

    public static Timeline getGameLoop() {
        return gameLoop;
    }

    public static void setGameLoop(Timeline gameLoop) {
        GameWorld.gameLoop = gameLoop;
    }

    public Scene getGameScene() {
        return gameScene;
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public Group getSceneNodes() {
        return sceneNodes;
    }

    public void setSceneNodes(Group sceneNodes) {
        this.sceneNodes = sceneNodes;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public TMXMapReader getMapReader() {
        return mapReader;
    }

    public Map getMap() {
        return map;
    }

    public TileLayer getLayer() {
        return layer;
    }

    public void assignBackgroundImage() {
        int width = layer.getWidth();
        int height = layer.getHeight();

        Tile tile = null;
        int tid;

        // as libtiled provides awt images we must convert them to
        // javafx images but we don't want a new image for every
        // single tile on the map
        HashMap<Integer, Image> tileHash = new HashMap<Integer, Image>();
        Image tileImage = null;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tile = layer.getTileAt(x, y);
                tid = tile.getId();
                if (tileHash.containsKey(tid)) {
                    // if we have already used the image get it from the hashmap
                    tileImage = tileHash.get(tid);
                }
                else {
                    // if we haven't seen it before convert and cache it
                    try {
                        tileImage = createImage(tile.getImage());
                    } catch (Exception e) {
                        e.printStackTrace(); // TODO!
                    }
                    tileHash.put(tid, tileImage);
                }
                backgroundImageView = new ImageView(tileImage);
                // assuming staggered if Y is odd move it right 1/2 a tile
                // also assuming 64x64 tile
                backgroundImageView.setTranslateX((y % 2 == 0 ? 0 : 32) + x * 64);
                backgroundImageView.setTranslateY(y * 16);
                // at this point you might want to add the ImageView to a custom
                // "tile" class including your own info which you can then place
                // in a 2d array where the index's are the coordinates of the tile

            }
        }
        // give some indication that caching did something!
        System.out.println("tile image hash has " + tileHash.size() + " items");
        // dump all the tmx stuff
        tileHash = null;
        map = null;
        layer = null;
    }

    // copy an awt image into a javafx image
    // "borrowed" fragment from part of
    // https://community.oracle.com/message/9655930#9655930
    public static javafx.scene.image.Image createImage(java.awt.Image image) throws Exception {
        if (!(image instanceof RenderedImage)) {
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
                                                            image.getHeight(null),
                                                            BufferedImage.TYPE_INT_ARGB);
            Graphics g = bufferedImage.createGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();
            image = bufferedImage;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage) image, "png", out);
        out.flush();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        return new javafx.scene.image.Image(in);
    }

    @Override
    public void handle(KeyEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method allows a map to be assigned to the map object
     *
     * @param backgroundtmx is the name of the tmx file to be read as a map into
     * the member map
     */
    private void readTmxFile(String backgroundtmx) {
        try {
            System.out.println(
                    backgroundtmx);
            map = mapReader.readMap(backgroundtmx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
