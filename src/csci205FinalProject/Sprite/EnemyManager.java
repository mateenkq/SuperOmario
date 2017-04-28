/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Still going to decide on
* Date: Apr 24, 2017
* Time: 4:37:30 PM
*
* Project: csci205FinalProject
* Package: csci205FinalProject.Sprite
* File: EnemyManager
* Description:
*
* ****************************************
 */
package csci205FinalProject.Sprite;

import csci205FinalProject.GameWorld;
import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class EnemyManager {

    GameWorld gameWorld;
    ArrayList<Enemy> enemies;

    public EnemyManager(GameWorld g) {
        gameWorld = g;
        enemies = new ArrayList();
        //dont add enemy to last platform (end of level)
        for (int i = 0; i < (gameWorld.getBackgroundManager().getPlatforms().size() - 1); i++) {
            enemies.add(new Enemy(g, 50,
                                  gameWorld.getBackgroundManager().getPlatforms().get(
                                          i)));
        }
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void remove(Enemy enemy) {
        enemies.remove(enemy);
        gameWorld.getSceneNodes().getChildren().remove(enemy.getNode());
    }

}
