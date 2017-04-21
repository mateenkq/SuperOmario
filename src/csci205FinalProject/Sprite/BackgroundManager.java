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

    public BackgroundManager(GameWorld g) {
        gameWorld = g;
        platforms = new ArrayList();
        platforms.add(new Platform(g, 50, 30, 100, 180));
        platform = platforms.get(0);

    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

}
