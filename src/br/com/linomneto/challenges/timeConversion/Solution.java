package br.com.linomneto.challenges.timeConversion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/time-conversion/
 */
public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        try {
            SimpleDateFormat sdf_original = new SimpleDateFormat("hh:mm:ssa");
            Date date = sdf_original.parse(s);
            SimpleDateFormat sdf_result = new SimpleDateFormat("HH:mm:ss");
            return sdf_result.format(date);
        }
        catch(ParseException e) {
            return "Not a valid time AM/PM format";
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
