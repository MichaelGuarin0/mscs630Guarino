/**
 * @author: Michael Guarino
 * course: MSCS 630
 */

import java.io.IOException;
import java.util.Scanner;

class DriverAES {

  public static void main(String[] args) throws IOException {

    // read in input from cli
    Scanner input = new Scanner(System.in);
    String KeyHex = input.next().toUpperCase();

    // produce 11 round keys
    String roundKeysHex = AESCipher.aesRoundKeys(KeyHex);
    System.out.println("input:");
    System.out.println(KeyHex);
    System.out.println("output:");
    System.out.println(roundKeysHex);
  }
}
