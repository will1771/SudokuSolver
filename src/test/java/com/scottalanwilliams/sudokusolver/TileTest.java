/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scottalanwilliams.sudokusolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author swilliams
 */
public class TileTest {
    
    public TileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test
     */
    @Test
    public void testTileCheckNumberOfPossibleLeft() {
        Tile tile = new Tile();

        Map<Integer, Boolean> testMap = new HashMap<Integer, Boolean>();
        testMap.put(1, false);
        testMap.put(2, false);
        testMap.put(3, false);
        testMap.put(4, true);
        testMap.put(5, false);
        testMap.put(6, false);
        testMap.put(7, false);
        testMap.put(8, false);
        testMap.put(9, false);

        tile.setPossibleNumbers(testMap);
        //tile.checkNumberOfPossibleLeft();
        tile.checkNumberOfPossibleLeft();
        assertTrue(tile.isIsLocked());
        assertTrue(tile.getTileNumber() == 4);
    }

}