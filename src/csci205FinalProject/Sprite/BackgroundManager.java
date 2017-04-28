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

    /**
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
        //end of level platform
        platforms.add(
                new Platform(g, 30, 10, (g.getGameScene().getWidth() - 40),
                             (g.getGameScene().getHeight() - 57)));
        platform = platforms.get(0);
//        platform.getNode().setOpacity(0);

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
}
