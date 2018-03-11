/* 
 * Michael Guarino
 * MSCS 630
 * Lab 3: Matrices in Modular
 * Part Two
 */

import java.util.Scanner;

public class Lab3_Part1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int m = input.nextInt(); // modulo
    int n = input.nextInt(); //size of square matrix

    // read in input from cli into 2D matrix
    int[][] A = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        A[i][j] = input.nextInt();
      }
    }

    // calculate determinant
    int det = cofModDet(m, A);

    // print out determinant
    System.out.println(det);
  }

  static int cofModDet(int m, int[][] A) {
    int det;
    // if size of matrix is 1
    if (A.length == 1) {
      return (A[0][0])%m;
    // else if size of matrix is 2
    } else if (A.length == 2) {
      return ((A[0][0]%m) * (A[1][1]%m) - (A[0][1]%m) * (A[1][0]%m));
    // else if size of matrix larger than 2
    } else {
      det = 0;

      // iterate through rows
      for (int i = 0; i < A.length; i++) {
        int[][] A_prime = new int[A.length - 1][A.length - 1];

        // first column pointer
        for (int j = 1; j < A.length; j++) {

          // second column pointer
          for (int k = 0; k < A.length; k++) {
            // if second column pointer less than row pointer
            if (k < i) {
              A_prime[j - 1][k] = A[j][k];
            // if second column pointer greater than row pointer
            } else if (k > i) {
              A_prime[j - 1][k - 1] = A[j][k];
            }
          }
        }

        // determine value of n positive or negative
        int n;
        if (i % 2 == 0) {
          n = 1;
        } else {
          n = -1;
        }
        // calculate determinant
        det += n * A[0][i] * (cofModDet(m, A_prime));
      }
    }
    // return determinant when calculation finished
    return det%m;
  }
}