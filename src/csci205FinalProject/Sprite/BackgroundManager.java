/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Still going to decide on
* Date: Apr 20, 2017
* Time: 6:58:19 PM
*
* Project: csci205FinalProject
* Package: csci205FinalProject
* File: BackgroundManager
* Description:
*
* ****************************************
 */
package csci205FinalProject.Sprite;

import csci205FinalProject.GameWorld;
import java.util.ArrayList;

/**
 *
 * @author Morgan
 */
public class BackgroundManager {

    GameWorld gameWorld;
    ArrayList<Platform> platforms;
    Platform platform;

    ArrayList<Coffee> coffees;

    ArrayList<Life> lives;

    /**
     * *
     *
     * @param g
     */
    public BackgroundManager(GameWorld g) {
        gameWorld = g;
        platforms = new ArrayList();
        //GameWorld g, double width, double height, double x, double y
        platforms.add(new Platform(g, 300, 10, 0, 230));
        platforms.add(new Platform(g, 300, 10, 400, 180));
        platforms.add(new Platform(g, 100, 10, 200, 130));
        platforms.add(new Platform(g, 100, 10, 350, 130));
        platforms.add(new Platform(g, 100, 10, 500, 130));
        platforms.add(
                new Platform(g, 700, 10, (g.getGameScene().getWidth() - 40),
                             (g.getGameScene().getHeight() - 32)));
        platforms.add(new Platform(g, 300, 10, 900, 230));
        platforms.add(new Platform(g, 100, 10, 850, 130));
        platforms.add(new Platform(g, 100, 10, 1000, 130));
        platforms.add(new Platform(g, 100, 10, 1250, 100));
        platforms.add(new Platform(g, 300, 10, 1100, 180));
        platforms.add(new Platform(g, 100, 10, 1450, 130));
        platforms.add(new Platform(g, 300, 10, 1650, 180));
        //end of level platform
        platforms.add(new Platform(g, 700, 10,
                                   g.getBackground().getNode().getFitWidth() - 700,
                                   (g.getGameScene().getHeight() - 32)));
        platform = platforms.get(0);
//        platform.getNode().setOpacity(0);

        coffees = new ArrayList();
        //GameWorld g, double width, double height,
        coffees.add(new Coffee(g, 100, 210));
        coffees.add(new Coffee(g, 450, 160));
        coffees.add(new Coffee(g, 250, 110));
        coffees.add(new Coffee(g, 400, 110));
        coffees.add(new Coffee(g, 550, 110));

        lives = new ArrayList();
        lives.add(new Life(g, 20, 2));
        lives.add(new Life(g, 26, 2));
        lives.add(new Life(g, 32, 2));

    }

    /**
     *
     * @return
     */
    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public ArrayList<Coffee> getCoffees() {
        return coffees;
    }

    public ArrayList<Life> getLives() {
        return lives;
    }

    public void remove(Coffee coffee) {
        coffees.remove(coffee);
        gameWorld.getSceneNodes().getChildren().remove(coffee.getNode());
    }

    public void remove(Life life) {
        lives.remove(life);
        gameWorld.getSceneNodes().getChildren().remove(life.getNode());
    }
}
