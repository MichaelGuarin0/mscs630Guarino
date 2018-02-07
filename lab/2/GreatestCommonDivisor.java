/* 
 * Michael Guarino
 * MSCS 630
 * Lab 2: Divisibility and Modular Arithmetric
 * Part One: Description
 */

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            long a = input.nextInt();
            long b = input.nextInt();
            long temp;
            if (a < b) {
                temp = a;
                a = b;
                b = temp;
            }
            System.out.println(euclidAlg(a, b));
        }
    }

    private static long euclidAlg(long a, long b) {
        if (b == 0) {
            return a;
        }
        long b2 = a - (Math.floorDiv(a, b) * b);
        return euclidAlg(b,b2);
    }
}
