package com.ds.main;

public class MatrixSpiralPrint {

  public static void spiralPrint(int[][] matrix) {
    int rStart = 0, rEnd = matrix.length, cStart = 0, cEnd = matrix[0].length;

    while (rStart < rEnd && cStart < cEnd) {
      for (int i = cStart; i < cEnd; i++) {
        System.out.print(matrix[rStart][i] + " ");
      }
      rStart++;

      for (int i = rStart; i < rEnd; i++) {
        System.out.print(matrix[i][cEnd - 1] + " ");
      }
      cEnd--;

      if (rStart < rEnd) {
        for (int i = cEnd - 1; i >= cStart; i--) {
          System.out.print(matrix[rEnd - 1][i] + " ");
        }
        rEnd--;
      }

      if (cStart < cEnd) {
        for (int i = rEnd - 1; i >= rStart; i--) {
          System.out.print(matrix[i][cStart] + " ");
        }
        cStart++;
      }
    }
  }

  // driver program
  public static void main(String[] args) {
    int a[][] = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}};
    spiralPrint(a);
  }
}