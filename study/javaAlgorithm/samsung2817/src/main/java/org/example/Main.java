package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {

    private static int[] arr;
    private static int N, target, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++){
            N = sc.nextInt();
            target = sc.nextInt();
            arr = new int[N];
            for (int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
            }
            count = 0;
            dfs(0, 0);

            System.out.println("#" + test_case + " " + count);
        }
    }
    public static void dfs(int i, int sum){
        //종료조건
        if(target == sum){
            count++;
            return ;
        }
        if (i == N)
            return ;
        //풀이조건
        dfs(i + 1, sum + arr[i]);
        dfs(i + 1, sum);
    }
}