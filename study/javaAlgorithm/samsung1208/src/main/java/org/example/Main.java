package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {

    private static int dumpChance, result;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int[100];
        for(int i = 1; i <= 10; i++){
            dumpChance = sc.nextInt();
            for(int j = 0; j < 100; j++){
                arr[j] = sc.nextInt();
            }
            for (int k = 0; k < dumpChance; k++){
                Arrays.sort(arr);
                arr[0] += 1;
                arr[99] -= 1;
            }
            Arrays.sort(arr);
            result = arr[99] - arr[0];
            System.out.println("#" + i + " " + result);
        }
    }
}