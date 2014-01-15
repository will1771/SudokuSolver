package com.scottalanwilliams.sudokusolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

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

    /*public void testThreeByThreeUpdateGridPossibles() {
     String testNumbers = "100500602";
     ThreeByThreeGrid grid = new ThreeByThreeGrid();
     grid.fillInGrid(testNumbers);
     grid.updateGridPossibles();
     //map that all non null tiles should contain:
     Map<Integer, Boolean> testMap = new HashMap<Integer, Boolean>();
     testMap.put(1, false);
     testMap.put(2, false);
     testMap.put(3, true);
     testMap.put(4, true);
     testMap.put(5, false);
     testMap.put(6, false);
     testMap.put(7, true);
     testMap.put(8, true);
     testMap.put(9, true);
     //print the possible number map of any tile that isn't null
     for (int i = 0; i < 3; i++) {
     for (int x = 0; x < 3; x++) {
     if (grid.getGrid()[i][x].getPossibleNumbers() != null) {
     assertTrue(grid.getGrid()[i][x].getPossibleNumbers().equals(testMap));
     }


     }


     }
     }*/
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
    /*
     public void testBoardUpdateRowAndColumnPossibles(){
     String testNumbers = "100000000"
     + "000000005"
     + "200000000"
     + "000000006"
     + "300000000"
     + "000000007"
     + "000000008"
     + "400000000"
     + "000000000";
     Board board = new Board();
     board.fillInTiles(testNumbers);
        
     board.updateRowAndColumnPossibles();
     //System.out.println(board.getTile(1, 0).getPossibleNumbers());
     //System.out.println(board.getTile(1, 1).getPossibleNumbers());
     //System.out.println(board.getTile(2, 8).getPossibleNumbers());
        
     //make map for tile 2-8
     Map<Integer, Boolean> testMap = new HashMap<Integer, Boolean>();
     testMap.put(1, true);
     testMap.put(2, false);
     testMap.put(3, true);
     testMap.put(4, true);
     testMap.put(5, false);
     testMap.put(6, false);
     testMap.put(7, false);
     testMap.put(8, false);
     testMap.put(9, true);
        
     assertTrue(board.getTile(2, 8).getPossibleNumbers().equals(testMap));
     }*/

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

    public void testSolverBrainExecuteSingleNakedCanidate() {
        //String board1 = "052006000160900004049803620400000800083201590001000002097305240200009056000100970";
        String board1 = "100530280395000604402000010000740060960000041040061000030000706704000138018027005";
        Board board = new Board();
        board.fillInTiles(board1);

        int round = 1;
        while (!board.isFinished()) {
            System.out.println("New round: " + round);
            board.print();
            SolverBrain.executeNakedSingleCanidate(board);
            board.print();
            round++;
            if (round > 100) {
                break;
            }
        }
    }

    public void testSolverBrainExecuteSingleHiddenCanidate() {
    }

    public void testSolverBrainStandardSolve() {

        //String board1 = "209078000060003000700001500806000090903000804010000206001800007000400030000530401";

        String board1 = "209078000060003000700001500806000090903000804010000206001800007000400030000530401";
        Board board = new Board();
        board.fillInTiles(board1);

        SolverBrain.standardSolve(board);
        board.print();
    }
}
