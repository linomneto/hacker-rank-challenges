package br.com.linomneto.challenges.problemSolvingIntermediate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static final Boolean VERTICAL = true;
    public static final Boolean HORIZONTAL = false;

    /*
     * Complete the 'getMaxArea' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER w
     *  2. INTEGER h
     *  3. BOOLEAN_ARRAY isVertical
     *  4. INTEGER_ARRAY distance
     */

    public static List<Long> getMaxArea(int w, int h, List<Boolean> isVertical, List<Integer> distance) {

        List<Long> result = new ArrayList<Long>();

        List<Integer[]> points = new ArrayList<Integer[]>();
        points.add(new Integer[]{0, 0});
        points.add(new Integer[]{0, w});
        points.add(new Integer[]{h, 0});

        for(int idx = 0; idx < isVertical.size(); idx++) {
            Boolean orientation = isVertical.get(idx);
            Integer dist = distance.get(idx);
            System.out.println("==> " + (orientation ? "VERTICAL" : "HORIZONTAL") + dist);
            List<Integer[]> points_to_add = new ArrayList<Integer[]>();

            if (orientation.equals(VERTICAL)) {
                for(Integer[] point : points)
                    points_to_add.add(new Integer[] { dist, point[1] });
            }
            else {
                for(Integer[] point : points)
                    points_to_add.add(new Integer[] { point[0], dist });
            }

            for(Integer[] point_to_add : points_to_add) {
                if (points.stream().filter(p -> p[0].equals(point_to_add[0]) && p[1].equals(point_to_add[1])).count() == 0)
                    points.add(point_to_add);
            }

            Long max = 0L;
            for(Integer[] base : points) {
                System.out.println(base[0] + "," + base[1]);
            }
            result.add(max);
        }

        return null;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int w = Integer.parseInt(bufferedReader.readLine().trim());

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int isVerticalCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Boolean> isVertical = IntStream.range(0, isVerticalCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(e -> Integer.parseInt(e) != 0)
                .collect(toList());

        int distanceCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> distance = IntStream.range(0, distanceCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Long> result = Result.getMaxArea(w, h, isVertical, distance);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
