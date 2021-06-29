package br.com.linomneto.challenges.dayOfProgrammer;

import sun.util.calendar.JulianCalendar;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    private static Integer JULIAN_TO_GREGORIAN_YEAR_CHANGE = 1918;

    private static Integer[] DAYS_IN_MONTHS = new Integer[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private static Integer daysInFeb(Integer year) {
        if (year.equals(JULIAN_TO_GREGORIAN_YEAR_CHANGE))
            return 15;
        else if (year < JULIAN_TO_GREGORIAN_YEAR_CHANGE)
            return (year % 4 == 0 ? 29 : 28);
        else // if (year > JULIAN_TO_GREGORIAN_YEAR_CHANGE)
            return (((year % 4 == 0 && year % 100 > 0) || (year % 400 == 0)) ? 29 : 28);
    }

    private static String addDaysFromJanFirst(Integer year, Integer totalDays) {
        Integer currMonth = 1;
        for(Integer monthDays : DAYS_IN_MONTHS) {
            if (currMonth.equals(2))
                monthDays = daysInFeb(year);

            if (totalDays > monthDays) {
                totalDays -= monthDays;
                currMonth++;
            }
            else
                break;
        }
        return String.format("%02d", totalDays) + "." + String.format("%02d", currMonth) + "." + year;
    }

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */
    public static String dayOfProgrammer(int year) {
        return addDaysFromJanFirst(year, 256);
    }

}

/**
 * https://www.hackerrank.com/challenges/day-of-the-programmer/
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
