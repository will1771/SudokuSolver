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
 * @author swilliams
 */
public class Tile {

    private int row;
    private int column;
    private int cachedNumber; //for when the number is determined, but cannot be updated yet because we need to keep the map
    private boolean isLocked = false; //if it came as part of a the starting board
    private Integer tileNumber = null; //null for blank
    private boolean isGuessing = false;
    private Map<Integer, Boolean> possibleNumbers = new HashMap<Integer, Boolean>();

    public Tile() {
        init();
    }

    private void init() {
        for (int i = 1; i < 10; i++) {
            getPossibleNumbers().put(i, true);
        }
    }

    /** Returns a true if the possibil numbers changed, i e, at least one possible number
        was eliminated
     */
    public boolean updatePossibleNumbers(ArrayList<Integer> notPossibleNumbersList) {
        
        if (isLocked) {
            return false;
        }
        boolean didStateChange = false;
        
        for (Integer x : notPossibleNumbersList) {
            if (x != null && x > 0) {
                if(getPossibleNumbers().get(x) == true){
                    didStateChange = true;
                }
                getPossibleNumbers().put(x, false);
            }
        }
        checkNumberOfPossibleLeft();
        return didStateChange;
    }

    /**
     * checks if there is only one possible number left, sets it to this number
     * and locks if its true
     */
    public void checkNumberOfPossibleLeft() {
        if (isLocked) {
            return;
        }

        int lastTrue = 0;
        int numberOfTrue = 0;
        for (Integer x : possibleNumbers.keySet()) {
            if (possibleNumbers.get(x) == true) {
                numberOfTrue++;
                lastTrue = x;
            }
        }
        if (numberOfTrue == 1) { //set it
            System.out.println("Locking a tile!");
            setTileNumber(lastTrue);
            setIsLocked(true);
        }
    }

    /**
     * @return the isLocked
     */
    public boolean isIsLocked() {
        return isLocked;
    }

    /**
     * @param isLocked the isLocked to set
     */
    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
        if (isLocked) {
            setPossibleNumbers(null); //if it is locked, no more possible numbers
        }
    }

    public void synchronizeCache() {
        if (!isIsLocked()) {
            if (cachedNumber > 0) {
                setTileNumber(cachedNumber);
                setPossibleNumbers(null);
                setIsLocked(true);
            }
        }



    }


    /**
     * @return the tileNumber
     */
    public Integer getTileNumber() {
        return tileNumber;
    }

    /**
     * @param tileNumber the tileNumber to set
     */
    public void setTileNumber(Integer tileNumber) {
        this.tileNumber = tileNumber;
    }

    /**
     * @return the isGuessing
     */
    public boolean isIsGuessing() {
        return isGuessing;
    }

    /**
     * @param isGuessing the isGuessing to set
     */
    public void setIsGuessing(boolean isGuessing) {
        this.isGuessing = isGuessing;
    }

    public String toString() {
        return tileNumber.toString();
    }

    /**
     * @return the possibleNumbers
     */
    public Map<Integer, Boolean> getPossibleNumbers() {
        return possibleNumbers;
    }
    

    /**
     * @param possibleNumbers the possibleNumbers to set
     */
    public void setPossibleNumbers(Map<Integer, Boolean> possibleNumbers) {
        this.possibleNumbers = possibleNumbers;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @return the cachedNumber
     */
    public int getCachedNumber() {
        return cachedNumber;
    }

    /**
     * @param cachedNumber the cachedNumber to set
     */
    public void setCachedNumber(int cachedNumber) {
        this.cachedNumber = cachedNumber;
    }
}
