package br.com.linomneto.challenges.kangaroo;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        try {
            if (x1 > x2 && v1 > v2)
                return "NO";
            else if (x2 > x1 && v2 > v1)
                return "NO";
            else {
                Double r = ( (Double.valueOf(x2) - Double.valueOf(x1)) / (Double.valueOf(v1) - Double.valueOf(v2)) );
                return (r > 0 && r % 1 == 0) ? "YES" : "NO";
            }
        }
        catch (Exception e) {
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
