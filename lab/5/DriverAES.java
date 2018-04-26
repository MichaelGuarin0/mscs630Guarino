/**
 * @author Michael Guarino
 * @course MSCS 630 Lab 5
 */

import java.io.IOException;
import java.util.Scanner;

class DriverAES{

  public static void main(String[] args) throws IOException{

    // read in input from cli
    Scanner input = new Scanner(System.in);
    String KeyHex = input.next().toUpperCase();
    String pText = input.next().toUpperCase();

    // produce 11 round keys
    String roundKeysHex = AESCipher.aesRoundKeys(KeyHex);

    // perform AES encryption
    String cText = AESCipher.AES(pText, KeyHex);

    System.out.println("KeyHex: \n" + KeyHex);
    System.out.println("roundKeysHex: \n" + roundKeysHex);
    System.out.println("pText (plaintext): \n" + pText);
    System.out.println("cText (ciphertext): \n" + cText);
  }
}
