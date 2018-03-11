/* 
 * Michael Guarino
 * MSCS 630
 * Lab 3: Matrices in Modular
 * Part Two
 */

import java.util.Scanner;

public class Lab3_Part2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char s = input.nextLine().charAt(0);
    String p = input.nextLine();

    //pad input string with character s
    StringBuffer sb_p = new StringBuffer(p);
    while (sb_p.length() % 16 != 0) {
      sb_p.append(s);
    }

    // parse through input string
    for (int i = 0; i < sb_p.length()-1; i++) {
      if(i % 16 == 0 || i == 0){
        // convert to hex and create 2D matrix of hex encoded input string
        String[][] cipher = getHexMatP(s, sb_p.toString().substring(i, i + 16));
        // print out 2D matrix of hex encoded input string
        matrixPrinter(cipher);
      }
    }
  }

  static String[][] getHexMatP(char s, String p) {
    //turn ascii text into hexadecimal
    StringBuffer hexP = new StringBuffer();
    for (int i = 0; i < p.length(); i++) {
      hexP.append(Integer.toHexString(p.charAt(i)).toUpperCase());
    }

    // group hexadecimal codes into groups of two and store in string vector 
    String[] ary = new String[hexP.length()];
    for (int i = 0; i < hexP.length(); i+=2) {
      String first = Character.toString(hexP.charAt(i));
      String two = Character.toString(hexP.charAt(i+1));
      if(i==0){
        ary[i] = first.concat(two);
      }
      else{
        ary[i/2] = first.concat(two);
      }
    }

    // convert string vector to 2D matrix
    String[][] cipher = new String[4][4];
    for(int i=0; i < cipher[0].length; i++){
      int index = 4 * i;
      cipher[0][i] = ary[index];
      cipher[1][i] = ary[index+1];
      cipher[2][i] = ary[index+2];
      cipher[3][i] = ary[index+3];
    }
    return cipher;
  }

  public static void matrixPrinter(String [][] cipher) {
    System.out.println("\n");
    for(int i=0; i< cipher.length; i++){
      System.out.println(cipher[i][0] + " " + cipher[i][1] + " " + cipher[i][2] + " " + cipher[i][3]);
    }
  }
}