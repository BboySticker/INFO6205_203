//package edu.neu.coe.info6205.mystaff;
//
//import javax.swing.*;
//
//public class GOL extends JFrame {
//    public int w = 8;
//    public int columns, rows;
//
//    // Game of life board
//    public Cell[][] board;
//
//    public GOL() {
//        // Initialize rows, columns and set-up arrays
//        columns = 800 / w;
//        rows = 800 / w;
//        board = new Cell[columns][rows];
//        init();
//    }
//
//    public void init() {
//        for (int i = 0; i < columns; i++)
//            for (int j = 0; j < rows; j++)
//                board[i][j] = new Cell(i * w, j * w, w);
//    }
//
//    // The process of creating the new generation
//    public void generate() {
//        for (int i = 0; i < columns;i++)
//            for (int j = 0; j < rows;j++)
//                board[i][j].savePrevious();
//
//        // Loop through every spot in our 2D array and check spots neighbors
//        for (int x = 0; x < columns; x++) {
//            for (int y = 0; y < rows; y++) {
//
//                // Add up all the states in a 3x3 surrounding grid
//                int neighbors = 0;
//                for (int i = -1; i <= 1; i++)
//                    for (int j = -1; j <= 1; j++)
//                        neighbors += board[(x+i+columns)%columns][(y+j+rows)%rows].previous;
//
//                // A little trick to subtract the current cell's state since
//                // we added it in the above loop
//                neighbors -= board[x][y].previous;
//
//                // Rules of Life
//                if      ((board[x][y].state == 1) && (neighbors <  2)) board[x][y].newState(0);           // Loneliness
//                else if ((board[x][y].state == 1) && (neighbors >  3)) board[x][y].newState(0);           // Overpopulation
//                else if ((board[x][y].state == 0) && (neighbors == 3)) board[x][y].newState(1);           // Reproduction
//                // else do nothing!
//            }
//        }
//    }
//
//    // This is the easy part, just draw the cells, fill 255 for '1', fill 0 for '0'
//    public void display() {
//        for ( int i = 0; i < columns;i++)
//            for ( int j = 0; j < rows;j++)
//                board[i][j].display();
//    }
//}
