/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scottalanwilliams.sudokusolver;

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
public class ThreeByThreeGridTest {
    
    public ThreeByThreeGridTest() {
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
    public void testThreeByThreeGridInsertion() {
        String testNumbers = "123456780";
        ThreeByThreeGrid grid = new ThreeByThreeGrid();
        grid.fillInGrid(testNumbers);

        //grid.print();
        assertTrue(grid.getGrid()[0][0].getTileNumber() == 1);
        assertTrue(grid.getGrid()[0][1].getTileNumber() == 2);
        assertTrue(grid.getGrid()[0][2].getTileNumber() == 3);

        assertTrue(grid.getGrid()[1][0].getTileNumber() == 4);
        assertTrue(grid.getGrid()[1][1].getTileNumber() == 5);
        assertTrue(grid.getGrid()[1][2].getTileNumber() == 6);

        assertTrue(grid.getGrid()[2][0].getTileNumber() == 7);
        assertTrue(grid.getGrid()[2][1].getTileNumber() == 8);
        assertTrue(grid.getGrid()[2][2].getTileNumber() == 0);

    }

        @Test
    public void testThreeByThreeGridExportSet() {
        String testNumbers = "123456780";
        ThreeByThreeGrid grid = new ThreeByThreeGrid();
        grid.fillInGrid(testNumbers);
        Tile[] tileArray = grid.exportSet();
        assertTrue(tileArray[0].getTileNumber() == 1);
        assertTrue(tileArray[1].getTileNumber() == 2);
        assertTrue(tileArray[2].getTileNumber() == 3);

        assertTrue(tileArray[3].getTileNumber() == 4);
        assertTrue(tileArray[4].getTileNumber() == 5);
        assertTrue(tileArray[5].getTileNumber() == 6);

        assertTrue(tileArray[6].getTileNumber() == 7);
        assertTrue(tileArray[7].getTileNumber() == 8);
        assertTrue(tileArray[8].getTileNumber() == 0);
    }


}