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
    ArrayList<Fireball> fireballs;

    public EnemyManager(GameWorld g) {
        gameWorld = g;
        fireballs = new ArrayList();
        fireballs.add(new Fireball(g, -50, 950, 175));
        fireballs.add(new Fireball(g, -30, 950, 125));
    }

    public ArrayList<Fireball> getFireballs() {
        return fireballs;
    }

}
