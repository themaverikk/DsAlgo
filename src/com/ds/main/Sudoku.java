package com.ds.main;


public class Sudoku {

  public static void main(String[] args) throws Exception {

    int[][] board = new int[9][9];
    int counter = 1;

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {

        int x = i / 3 * 3 + j / 3;
        int y = i % 3 * 3 + j % 3;

        board[x][y] = counter++;
      }
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {

        System.out.printf("%2d ", board[i][j]);
      }
      System.out.println();
    }


  }

}
