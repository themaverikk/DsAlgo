package com.ds.main;

public class MatrixDiagonalPrint {

  static void printMatrixDiagonal(int arr[][], int n) {
    int i = 0, j = 0;
    boolean leftToRight = true;

    while (i < arr.length && j < arr[0].length) {
      System.out.print(arr[i][j] + " ");

      if (leftToRight) {
        if (j == arr[0].length - 1) {
          i++;
          leftToRight = !leftToRight;
        } else if (i == 0) {
          j++;
          leftToRight = !leftToRight;
        } else {
          i--;
          j++;
        }
      } else {
        if (i == arr.length - 1) {
          j++;
          leftToRight = !leftToRight;
        } else if (j == 0) {
          i++;
          leftToRight = !leftToRight;
        } else {
          i++;
          j--;
        }
      }

    }
  }

  public static void main(String[] args) {
    int mat[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    int n = 3;

    long start = System.currentTimeMillis();
    printMatrixDiagonal(mat, n);
    System.out.println(System.currentTimeMillis() - start);
  }
}
