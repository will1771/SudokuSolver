/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scottalanwilliams.sudokusolver;

import java.util.ArrayList;

/**
 *
 * @author swilliams
 */
public class ThreeByThreeGrid {

    private Tile[][] grid = new Tile[3][3];

    public ThreeByThreeGrid() {
        init();
    }

    private void init() {
        for (int i = 0; i < getGrid().length; i++) {
            for (int y = 0; y < getGrid().length; y++) {
                getGrid()[i][y] = new Tile();
            }
        }
    }

    /**
     * must be nine-character string of numbers
     */
    public void fillInGrid(String tiledata) {
        int c = 0;
        for (int i = 0; i < getGrid().length; i++) {
            for (int y = 0; y < getGrid().length; y++) {

                int newNumber = Integer.valueOf(tiledata.substring(c, c + 1));
                getGrid()[i][y].setTileNumber(newNumber);
                if (newNumber > 0) {
                    getGrid()[i][y].setIsLocked(true);
                }
                c++;

            }
        }
    }

    /**
     * scans the grid, updates each open tiles possible canidates. A part of
     * single canidate
     */
    /*  public void updateGridPossibles() {
     ArrayList<Integer> numbersInGrid = new ArrayList<Integer>();
     for (int i = 0; i < getGrid().length; i++) {
     for (int y = 0; y < getGrid().length; y++) { //null check?
     numbersInGrid.add(getGrid()[i][y].getTileNumber());
     }
     }
     //go through each tile and update what we have on the list now...
     for (int i = 0; i < getGrid().length; i++) {
     for (int y = 0; y < getGrid().length; y++) { //null check?
     getGrid()[i][y].updatePossibleNumbers(numbersInGrid);
     }
     }
     }*/
    public Tile[] exportSet() {
        Tile[] tilesToExport = new Tile[9];
        int a = 0;
        for (int i = 0; i < getGrid().length; i++) {
            for (int y = 0; y < getGrid().length; y++) {
                tilesToExport[a] = getGrid()[i][y];
                a++;
            }
        }
        return tilesToExport;
    }

    /**
     * @return the grid
     */
    public Tile[][] getGrid() {
        return grid;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(Tile[][] grid) {
        this.grid = grid;
    }

    public void print() {
        for (int i = 0; i < getGrid().length; i++) {
            for (int y = 0; y < getGrid().length; y++) {
                System.out.print(getGrid()[i][y].getTileNumber().toString());
            }
            System.out.println();
        }
    }
}
