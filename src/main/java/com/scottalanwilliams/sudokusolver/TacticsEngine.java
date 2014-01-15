/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scottalanwilliams.sudokusolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author swilliams Stateless singleton or set of static methods that take nine
 * tiles (a row, column, or box). It performs some sort of analysis depending on
 * the step.
 *
 *
 * The boolean return signals if the tactic was sucessful in eliminating any
 * options, which is important information for which tactic needs to be called
 * next...
 */
public class TacticsEngine {

    /**
     * Step 1: Naked Single Canidate. Just go through what is known in the set
     * and eliminate the possibility in other squares
     *
     *
     */
    public static boolean processNakedSingleCanidate(Tile[] tileArray) {
        boolean didEliminate = false;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Tile tile : tileArray) {

            if (tile.getTileNumber() != null) {
                list.add(tile.getTileNumber());
            }
        }
        for (Tile tile : tileArray) {
            if (tile.updatePossibleNumbers(list)) {
                didEliminate = true;
            }
        }

        return didEliminate;

    }

    /**
     * Step 2: Hidden Single Canidate. Just go through remaining possibiilites
     * for each set. If there is only one square a number can go, that number is
     * solved even if that tiles inidivually has other possibilities
     *
     *
     */
    public static boolean processHiddenSingleCanidate(Tile[] tileArray) {
        boolean didEliminate = false;
        
        Map<Integer, Integer> currentPossibles = countCurrentPossibles(tileArray);
        //if any of the numbers have a value of one (and were not found by step one, that is a naked single
        ArrayList<Integer> confirmedSingles = new ArrayList<Integer>();
        for (Integer theInt : currentPossibles.keySet()) {
            if (currentPossibles.get(theInt) == 1) {
                //hidden single
                confirmedSingles.add(theInt);
                //System.out.println("Setting didEliminate to true");
                didEliminate = true;
            }
        }
        
        //any entries in confirmed singles now need their tile set
        for (Tile tile : tileArray) {
            //see if the tiles possible numbers contains the discovered single
            if (!tile.isIsLocked()) {
               // System.out.println("Tile potential map is: " + tile.getPossibleNumbers());
                for (Integer theInt : confirmedSingles) {
                    
                    //System.out.println("Looking for a: " + theInt);
                    if (tile.getPossibleNumbers().get(theInt) == true) {
                        //got it.  we cant set the tile yet because they all must be set at once, or there will be faulty data assumptions
                        //tile.setTileNumber(theInt);
                        //tile.setIsLocked(true);
                        tile.setCachedNumber(theInt);
                        
                        break;
                    }
                }


            }


        }
        //System.out.println("Returning did didEliminate: " + didEliminate);
        return didEliminate;
    }

    /**
     * Step 3: Naked double/triple Canidate.
     *
     *
     */
    public static void processNakedDoubleTripleCanidate(Tile[] tileArray) {
    }

    /**
     * Step 4: Hidden double/triple Canidate.
     *
     *
     */
    public static void processHiddenDoubleTripleCanidate(Tile[] tileArray) {
    }

    /**
     * Helper method for many steps. counts up the numbers of times the number
     * is possible in a set of numbers
     */
    public static Map<Integer, Integer> countCurrentPossibles(Tile[] tileArray) {
        Map<Integer, Integer> currentPossiblesForSet = new HashMap<Integer, Integer>();
        for (int i = 1; i <= 9; i++) {
            currentPossiblesForSet.put(i, 0);
        }

        for (Tile tile : tileArray) {
            if (!tile.isIsLocked()) {
                for (Integer theInt : tile.getPossibleNumbers().keySet()) {
                    if (tile.getPossibleNumbers().get(theInt) == true) {
                        currentPossiblesForSet.put(theInt, currentPossiblesForSet.get(theInt) + 1);
                        //System.out.println("LALLA" + theInt + "LA" + currentPossiblesForSet.get(theInt));
                    }
                }
                //System.out.println("LOLO");
            }
        }
        return currentPossiblesForSet;
    }
    
    
    
    public static boolean validateSet(Tile[] tileArray){
        return false;
    }
}
