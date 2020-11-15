package br.com.linomneto.challenges.compareTheTriplets;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class Solution {

    private static int A_IDX = 0;
    private static int B_IDX = 1;

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<Integer>();

        result.add(A_IDX, 0);
        result.add(B_IDX, 0);

        for(int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i))
                result.set(A_IDX, result.get(A_IDX) + 1);
            else if (b.get(i) > a.get(i))
                result.set(B_IDX, result.get(B_IDX) + 1);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
