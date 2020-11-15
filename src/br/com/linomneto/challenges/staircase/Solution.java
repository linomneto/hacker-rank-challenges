package br.com.linomneto.challenges.staircase;

import java.util.Scanner;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        for(int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (y >= (n - x - 1))
                    System.out.print("#");
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}

