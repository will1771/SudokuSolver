/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scottalanwilliams.sudokusolver;

import java.util.ArrayList;

/**
 *
 * @author swilliams
 *
 * Static methods that execute entire rounds of sudoku solving logic
 *
 *
 */
public class SolverBrain {
    public static boolean executeNakedSingleCanidate(Board board) {


        ArrayList<Tile[]> tileList = board.exportTileSets();
        boolean changeOccured = false;

        for (Tile[] theTileSet : tileList) {
            if (TacticsEngine.processNakedSingleCanidate(theTileSet)) {
                changeOccured = true;
            }
        }
        return changeOccured;
        //board.lockTilesWithOneNumber();

    }
    public static boolean executeHiddenSingle(Board board) {
         ArrayList<Tile[]> tileList = board.exportTileSets();
        boolean changeOccured = false;

        for (Tile[] theTileSet : tileList) {
            if (TacticsEngine.processHiddenSingleCanidate(theTileSet)) {
                changeOccured = true;
            }
        }
        //this tactic uses tile cache, so trigger cache.
        board.triggerCacheUpdate();
        return changeOccured;
    }



    public static void standardSolve(Board board) {

        while (true) {
            board.print();
            if(board.isFinished()){
                System.out.println("All Done!");
                break;
            }
            
            
            if(executeNakedSingleCanidate(board)){
             System.out.println("Got a match for Naked Single.  Will repeat steps from the top");
             continue;   
            }
            
            System.out.println("Naked Single search failed. Proceeding to next step");
            
            if(executeHiddenSingle(board)){
             System.out.println("Got a match for Hidden Single.  Will repeat steps from the top");
             continue;   
            }
            
            System.out.println("Hidden Single search failed. Proceeding Naked Pair Search");
            
           /* if(executeHiddenSingle(board)){
             System.out.println("Got a match for Naked Pair.  Will repeat steps from the top");
             continue;   
            }*/
            
            System.out.println("Naked Pair search failed. Proceeding to next step");
            
            
            
            System.out.println("Sorry, I give up");
            break;
        }

    }
}
