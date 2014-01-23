/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scottalanwilliams.sudokusolver;

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
public class SolverBrainTest {
    
    public SolverBrainTest() {
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
    
    
    @Test
    public void testSolverBrainExecuteSingleHiddenCanidate() {
    }
    
        @Test
    public void testSolverBrainExecuteDoubleNakedCanidate() {
    }
    
    @Test
    public void testSolverBrainStandardSolve() {

        //String board1 = "209078000060003000700001500806000090903000804010000206001800007000400030000530401";

        String board1 = "209078000060003000700001500806000090903000804010000206001800007000400030000530401";
        Board board = new Board();
        board.fillInTiles(board1);

        SolverBrain.standardSolve(board);
        board.print();
    }
}