/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Still going to decide on
 * Date: Apr 26, 2017
 * Time: 1:08:58 AM
 *
 * Project: csci205FinalProject
 * Package: csci205FinalProject.Sprite
 * File: SpriteTest
 * Description:
 *
 * ****************************************
 */
package csci205FinalProject.Sprite;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;
import org.junit.After;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Mateen Qureshi
 */
public class SpriteTest {

    public SpriteTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setImage method, of class Sprite.
     */
    @Test
    public void testSetImage_Image() {
        System.out.println("setImage");
        Image i = null;
        Sprite instance = new Sprite();
        instance.setImage(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImage method, of class Sprite.
     */
    @Test
    public void testSetImage_String() {
        System.out.println("setImage");
        String fileName = "";
        Sprite instance = new Sprite();
        instance.setImage(fileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Sprite.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        double x = 0.0;
        double y = 0.0;
        Sprite instance = new Sprite();
        instance.setPosition(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVelocity method, of class Sprite.
     */
    @Test
    public void testSetVelocity() {
        System.out.println("setVelocity");
        double x = 0.0;
        double y = 0.0;
        Sprite instance = new Sprite();
        instance.setVelocity(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVelocityX method, of class Sprite.
     */
    @Test
    public void testAddVelocityX() {
        System.out.println("addVelocityX");
        double x = 0.0;
        Sprite instance = new Sprite();
        instance.addVelocityX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVelocityY method, of class Sprite.
     */
    @Test
    public void testAddVelocityY() {
        System.out.println("addVelocityY");
        double y = 0.0;
        Sprite instance = new Sprite();
        instance.addVelocityY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccelerationX method, of class Sprite.
     */
    @Test
    public void testSetAccelerationX() {
        System.out.println("setAccelerationX");
        double accelerationX = 0.0;
        Sprite instance = new Sprite();
        instance.setAccelerationX(accelerationX);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccelerationY method, of class Sprite.
     */
    @Test
    public void testSetAccelerationY() {
        System.out.println("setAccelerationY");
        double accelerationY = 0.0;
        Sprite instance = new Sprite();
        instance.setAccelerationY(accelerationY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeVelocity method, of class Sprite.
     */
    @Test
    public void testChangeVelocity() {
        System.out.println("changeVelocity");
        double time = 0.0;
        Sprite instance = new Sprite();
        instance.changeVelocity(time);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Sprite.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        double time = 0.0;
        Sprite instance = new Sprite();
        instance.update(time);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoundary method, of class Sprite.
     */
    @Test
    public void testGetBoundary() {
        System.out.println("getBoundary");
        Sprite instance = new Sprite();
        Bounds expResult = null;
        Bounds result = instance.getBoundary();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of intersects method, of class Sprite.
     */
    @Test
    public void testIntersects() {
        System.out.println("intersects");
        Sprite s = null;
        Sprite instance = new Sprite();
        boolean expResult = false;
        boolean result = instance.intersects(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of intersectsTop method, of class Sprite.
     */
    @Test
    public void testIntersectsTop() {
        System.out.println("intersectsTop");
        Sprite s = null;
        Sprite instance = new Sprite();
        boolean expResult = false;
        boolean result = instance.intersectsTop(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sideIntersects method, of class Sprite.
     */
    @Test
    public void testSideIntersects() {
        System.out.println("sideIntersects");
        Sprite s = null;
        Sprite instance = new Sprite();
        boolean expResult = false;
        boolean result = instance.sideIntersects(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Sprite.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Sprite instance = new Sprite();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVelocityX method, of class Sprite.
     */
    @Test
    public void testSetVelocityX() {
        System.out.println("setVelocityX");
        double velocityX = 0.0;
        Sprite instance = new Sprite();
        instance.setVelocityX(velocityX);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVelocityY method, of class Sprite.
     */
    @Test
    public void testSetVelocityY() {
        System.out.println("setVelocityY");
        double velocityY = 0.0;
        Sprite instance = new Sprite();
        instance.setVelocityY(velocityY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionX method, of class Sprite.
     */
    @Test
    public void testGetPositionX() {
        System.out.println("getPositionX");
        Sprite instance = new Sprite();
        double expResult = 0.0;
        double result = instance.getPositionX();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionY method, of class Sprite.
     */
    @Test
    public void testGetPositionY() {
        System.out.println("getPositionY");
        Sprite instance = new Sprite();
        double expResult = 0.0;
        double result = instance.getPositionY();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVelocityX method, of class Sprite.
     */
    @Test
    public void testGetVelocityX() {
        System.out.println("getVelocityX");
        Sprite instance = new Sprite();
        double expResult = 0.0;
        double result = instance.getVelocityX();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVelocityY method, of class Sprite.
     */
    @Test
    public void testGetVelocityY() {
        System.out.println("getVelocityY");
        Sprite instance = new Sprite();
        double expResult = 0.0;
        double result = instance.getVelocityY();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImage method, of class Sprite.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        Sprite instance = new Sprite();
        Image expResult = null;
        Image result = instance.getImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class Sprite.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Sprite instance = new Sprite();
        double expResult = 0.0;
        double result = instance.getWidth();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWidth method, of class Sprite.
     */
    @Test
    public void testSetWidth() {
        System.out.println("setWidth");
        double w = 0.0;
        Sprite instance = new Sprite();
        instance.setWidth(w);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class Sprite.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Sprite instance = new Sprite();
        double expResult = 0.0;
        double result = instance.getHeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeight method, of class Sprite.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        double h = 0.0;
        Sprite instance = new Sprite();
        instance.setHeight(h);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDimensions method, of class Sprite.
     */
    @Test
    public void testSetDimensions() {
        System.out.println("setDimensions");
        double w = 0.0;
        double h = 0.0;
        Sprite instance = new Sprite();
        instance.setDimensions(w, h);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNode method, of class Sprite.
     */
    @Test
    public void testGetNode() {
        System.out.println("getNode");
        Sprite instance = new Sprite();
        Node expResult = null;
        Node result = instance.getNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
