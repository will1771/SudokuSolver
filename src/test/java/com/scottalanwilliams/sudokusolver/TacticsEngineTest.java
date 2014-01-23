/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scottalanwilliams.sudokusolver;

import java.util.HashMap;
import java.util.Map;
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
public class TacticsEngineTest {
    
    public TacticsEngineTest() {
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

    @Test
    public void testTacticsEngineCountCurrentPossibles() {
        Tile[] tileArray = new Tile[3];
        tileArray[0] = new Tile();

        Map<Integer, Boolean> testMap0 = new HashMap<Integer, Boolean>();
        testMap0.put(1, false);
        testMap0.put(2, false);
        testMap0.put(3, true);
        testMap0.put(4, true);
        testMap0.put(5, false);
        testMap0.put(6, false);
        testMap0.put(7, true);
        testMap0.put(8, true);
        testMap0.put(9, true);
        tileArray[0].setPossibleNumbers(testMap0);

        tileArray[1] = new Tile();
        Map<Integer, Boolean> testMap1 = new HashMap<Integer, Boolean>();
        testMap1.put(1, false);
        testMap1.put(2, false);
        testMap1.put(3, true);
        testMap1.put(4, true);
        testMap1.put(5, false);
        testMap1.put(6, false);
        testMap1.put(7, true);
        testMap1.put(8, true);
        testMap1.put(9, true);
        tileArray[1].setPossibleNumbers(testMap1);

        tileArray[2] = new Tile();
        Map<Integer, Boolean> testMap2 = new HashMap<Integer, Boolean>();
        testMap2.put(1, false);
        testMap2.put(2, false);
        testMap2.put(3, true);
        testMap2.put(4, true);
        testMap2.put(5, false);
        testMap2.put(6, false);
        testMap2.put(7, true);
        testMap2.put(8, true);
        testMap2.put(9, true);
        tileArray[2].setPossibleNumbers(testMap2);

        //System.out.print("RESULTS: " + TacticsEngine.countCurrentPossibles(tileArray));
    }
    
    @Test
    public void testTacticsEngineHiddenSingle() {
        Tile[] tileArray = new Tile[3];
        tileArray[0] = new Tile();

        Map<Integer, Boolean> testMap0 = new HashMap<Integer, Boolean>();
        testMap0.put(1, false);
        testMap0.put(2, false);
        testMap0.put(3, true);
        testMap0.put(4, true);
        testMap0.put(5, false);
        testMap0.put(6, false);
        testMap0.put(7, true);
        testMap0.put(8, true);
        testMap0.put(9, false);
        tileArray[0].setPossibleNumbers(testMap0);

        tileArray[1] = new Tile();
        Map<Integer, Boolean> testMap1 = new HashMap<Integer, Boolean>();
        testMap1.put(1, false);
        testMap1.put(2, false);
        testMap1.put(3, true);
        testMap1.put(4, true);
        testMap1.put(5, false);
        testMap1.put(6, false);
        testMap1.put(7, true);
        testMap1.put(8, true);
        testMap1.put(9, false);
        tileArray[1].setPossibleNumbers(testMap1);

        tileArray[2] = new Tile();
        Map<Integer, Boolean> testMap2 = new HashMap<Integer, Boolean>();
        testMap2.put(1, false);
        testMap2.put(2, false);
        testMap2.put(3, true);
        testMap2.put(4, true);
        testMap2.put(5, false);
        testMap2.put(6, false);
        testMap2.put(7, true);
        testMap2.put(8, true);
        testMap2.put(9, true);
        tileArray[2].setPossibleNumbers(testMap2);

        //System.out.println("testTacticsEngineHiddenSingle: " + TacticsEngine.processHiddenSingleCanidate(tileArray));
    }
    
        @Test
        public void testNakedDouble(){
        Tile[] tileArray = new Tile[3];
        tileArray[0] = new Tile();
            
        Map<Integer, Boolean> testMap0 = new HashMap<Integer, Boolean>();
        testMap0.put(1, true);
        testMap0.put(2, true);
        testMap0.put(3, true);
        testMap0.put(4, true);
        testMap0.put(5, true);
        testMap0.put(6, true);
        testMap0.put(7, true);
        testMap0.put(8, true);
        testMap0.put(9, true);
        tileArray[0].setPossibleNumbers(testMap0);

        tileArray[1] = new Tile();
        Map<Integer, Boolean> testMap1 = new HashMap<Integer, Boolean>();
        testMap1.put(1, false);
        testMap1.put(2, false);
        testMap1.put(3, true);
        testMap1.put(4, true);
        testMap1.put(5, false);
        testMap1.put(6, false);
        testMap1.put(7, false);
        testMap1.put(8, false);
        testMap1.put(9, false);
        tileArray[1].setPossibleNumbers(testMap1);

        tileArray[2] = new Tile();
        Map<Integer, Boolean> testMap2 = new HashMap<Integer, Boolean>();
        testMap2.put(1, false);
        testMap2.put(2, false);
        testMap2.put(3, true);
        testMap2.put(4, true);
        testMap2.put(5, false);
        testMap2.put(6, false);
        testMap2.put(7, false);
        testMap2.put(8, false);
        testMap2.put(9, false);
        tileArray[2].setPossibleNumbers(testMap2);


            TacticsEngine.processNakedDouble(tileArray);

            //first tile should have 3 and 4 eliminated now    
            assertTrue(tileArray[0].getPossibleNumbers().get(3) == false);
            assertTrue(tileArray[0].getPossibleNumbers().get(4) == false);

            assertTrue(tileArray[1].getPossibleNumbers().get(3) == true);
            assertTrue(tileArray[1].getPossibleNumbers().get(4) == true);

            assertTrue(tileArray[1].getPossibleNumbers().get(3) == true);
            assertTrue(tileArray[1].getPossibleNumbers().get(4) == true);

        }
}