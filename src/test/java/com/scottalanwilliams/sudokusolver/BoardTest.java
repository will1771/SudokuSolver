/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scottalanwilliams.sudokusolver;

import java.util.ArrayList;
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
public class BoardTest {
    
    public BoardTest() {
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
     * Test of getTile method, of class Board.
     */
    @Test
    public void testBoardInsertion() {

        String testNumbers = "123456789"
                + "987654321"
                + "000000000"
                + "135791357"
                + "222222222"
                + "333333333"
                + "852963741"
                + "987456321"
                + "888888888";
        Board board = new Board();
        board.fillInTiles(testNumbers);

        int sideLength = 9;
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int x = 0; x < 9; x++) {
                assertTrue(board.getTile(i, x).getTileNumber() == Integer.valueOf(testNumbers.substring(count, ++count)));
            }
        }
    }
    @Test
        public void testBoardTileSetExport() {


        String board1 = "052006000160900004049803620400000800083201590001000002097305240200009056000100970";
        Board board = new Board();
        board.fillInTiles(board1);
        ArrayList<Tile[]> theList = board.exportTileSets();
        board.print();
        for (Tile[] tileArray : theList) {
            //System.out.println("Printing a tileArray");
            for (Tile tile : tileArray) {
                System.out.print(tile.getTileNumber());
            }
            //System.out.println();
        }

    }
}