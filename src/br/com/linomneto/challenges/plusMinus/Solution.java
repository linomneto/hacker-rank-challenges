package br.com.linomneto.challenges.plusMinus;

import java.util.Scanner;


/**
 * https://www.hackerrank.com/challenges/plus-minus/
 */
public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double count_positives = 0;
        double count_negatives = 0;
        double count_zeroes = 0;

        for(int value : arr) {
            if (value > 0)
                count_positives++;
            else if (value < 0)
                count_negatives++;
            else
                count_zeroes++;
        }

        double total_count = count_positives + count_negatives + count_zeroes;

        double positives_ratio = count_positives / total_count;
        double negatives_ratio = count_negatives / total_count;
        double zeroes_ratio = count_zeroes / total_count;

        System.out.println(positives_ratio);
        System.out.println(negatives_ratio);
        System.out.println(zeroes_ratio);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
