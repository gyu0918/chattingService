package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N,M, sum, max;
        int[] snack;

        for (int test_case = 1; test_case <= T; test_case++){
            N = sc.nextInt();
            M = sc.nextInt();
            sum = 0;
            max = 0;
            snack = new int[N];
            for (int i = 0; i < N; i++){
                snack[i] = sc.nextInt();
            }
            for (int i = 0; i < N - 1; i++){
                for (int j = i + 1; j < N; j++){
                    sum = snack[i] + snack[j];
                    if (max < sum && sum <= M)
                        max = sum;
                }
            }
            if (max == 0)
                max = -1;
            System.out.println("#" + test_case + " " + max);
        }
    }
}