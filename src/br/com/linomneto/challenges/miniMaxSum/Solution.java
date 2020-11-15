package br.com.linomneto.challenges.miniMaxSum;

import java.util.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.stream(arr).forEach(item -> list.add(item));
        Collections.sort(list);

        Long lower_sum = 0L;
        for(int i = 0; i < 4; i++)
            lower_sum += list.get(i);

        Long bigger_sum = 0L;
        for(int i = list.size() - 1; i > (list.size() - 4 - 1); i--)
            bigger_sum += list.get(i);

        System.out.println(lower_sum + " " + bigger_sum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
