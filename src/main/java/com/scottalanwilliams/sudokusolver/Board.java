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
public class Board {

    static public final int BOARD_SIDE_LENGTH = 9;
    private ThreeByThreeGrid[][] board = new ThreeByThreeGrid[3][3];

    public Board() {
        init();
    }

    private void init() {
        for (int i = 0; i < board.length; i++) {
            for (int y = 0; y < board.length; y++) {
                board[i][y] = new ThreeByThreeGrid();
            }
        }
    }

    public Tile getTile(int row, int column) {
        if (row < 0 || row > 8 || column < 0 || column > 8) { //not valid
            return null;
        }
        return board[row / 3][column / 3].getGrid()[row % 3][column % 3];
    }
    
    public void triggerCacheUpdate(){
                for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            for (int y = 0; y < BOARD_SIDE_LENGTH; y++) {
                getTile(i, y).synchronizeCache();
            }

        }
    }
    /*
     public void updateRowAndColumnPossibles() {
     //rows
     for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
     //make list
     ArrayList<Integer> takenNumbers = new ArrayList<Integer>();
     for (int y = 0; y < BOARD_SIDE_LENGTH; y++) {
     takenNumbers.add(getTile(i, y).getTileNumber());
     }
     //go through again with the list
     for (int y = 0; y < BOARD_SIDE_LENGTH; y++) {
     getTile(i, y).updatePossibleNumbers(takenNumbers);
     }
     }

     //columns

     for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
     //make list
     ArrayList<Integer> takenNumbers = new ArrayList<Integer>();
     for (int y = 0; y < BOARD_SIDE_LENGTH; y++) {
     takenNumbers.add(getTile(y, i).getTileNumber());
     }
     //go through again with the list
     for (int y = 0; y < BOARD_SIDE_LENGTH; y++) {
     getTile(y, i).updatePossibleNumbers(takenNumbers);
     }
     }
     }*/

    /**
     * Just triggers the nine grids' grid possibilities method
     */
    /*public void updateGridPossibles() {
     for (int i = 0; i < board.length; i++) {
     for (int y = 0; y < board.length; y++) {
     board[i][y].updateGridPossibles();
     }
     }
     }*/
    /* public void lockTilesWithOneNumber() {

        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            for (int y = 0; y < BOARD_SIDE_LENGTH; y++) {
                getTile(i, y).checkNumberOfPossibleLeft();
            }
        }
    }*/

    /**
     * Core method to export table data to the tactics engine. Must export 27
     * sets of nine tiles: 9 rows, 9 columns, nine boxes
     */
    public ArrayList<Tile[]> exportTileSets() {
        ArrayList<Tile[]> tilesToExport = new ArrayList<Tile[]>(27);
        //get rows
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            Tile[] rTile = new Tile[9];
            for (int y = 0; y < BOARD_SIDE_LENGTH; y++) {
                rTile[y] = getTile(i, y);
            }
            tilesToExport.add(rTile);
        }
        //get columns
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            Tile[] cTile = new Tile[9];
            for (int y = 0; y < BOARD_SIDE_LENGTH; y++) {
                cTile[y] = getTile(y, i);
            }
            tilesToExport.add(cTile);
        }
        //get boxes
        for (int i = 0; i < board.length; i++) {
            for (int y = 0; y < board.length; y++) {
                tilesToExport.add(board[i][y].exportSet());
            }
        }
        //return
        return tilesToExport;
    }

    /**
     * Part of object setup. must be a string of 81 numbers, left to right rows
     */
    public void fillInTiles(String numbers) {
        if (numbers.length() != 81) {
            System.out.println("fillInTiles with bad number of numbers");
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int y = 0; y < board.length; y++) {
                //chop out the numbers
                int base = i * 3 * 3 * 3; //0, 27, or 54
                int subBase = y * 3; //0,3,6
                String gridNumbers = numbers.substring(base + subBase, base + subBase + 3) + numbers.substring(base + subBase + 9, base + subBase + 12) + numbers.substring(base + subBase + 18, base + subBase + 21);
                System.out.println();
                board[i][y].fillInGrid(gridNumbers);
            }
        }

    }

    public boolean isFinished() {

        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            for (int y = 0; y < BOARD_SIDE_LENGTH; y++) {
                if (!getTile(i, y).isIsLocked()) {
                    return false;
                }
            }


        }
        return true;
    }

    public void print() {
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            for (int y = 0; y < BOARD_SIDE_LENGTH; y++) {
                System.out.print(getTile(i, y).getTileNumber());
            }
            System.out.println();
        }

    }
    
    
}
