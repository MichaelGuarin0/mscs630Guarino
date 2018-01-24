// Michael Guarino
// MSCS 630 Lab 1

import java.util.Scanner;

class Lab1 {

  /*
  reads in user input and calls str2int to convert
  char to int then prints it out
  */
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    while (input.hasNext()) {
      String plainText = input.nextLine();
      plainText = plainText.toUpperCase();
      int[] o = str2int(plainText);
      for (int i = 0; i < o.length; i++) {
        System.out.print(o[i] + " ");
      }
      System.out.println();
    }
  }

  /* type cast char to int,
   then subtract value of ascii A (65)
  if it's a space, print 26
  */
  static int[] str2int(String plainText){
    int[] output = new int[plainText.length()];
    for (int i = 0; i < plainText.length(); i++){
      char c = plainText.charAt(i);
      if (c == ' ') {
        output[i] = 26;
      } else {
        output[i] = ((int) c - 65);
      }
    }
    return output;
  }
}
