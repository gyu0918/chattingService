package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {

    private static int[] tmp,arr;
    private static int N,M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        dfs(0,0);
    }
    public static void dfs(int depth,int start){
        //종료조건
        if (depth == M){
            for (int i = 0; i < M; i++){
                System.out.print(tmp[i] + " ");
            }
            System.out.println();
            return ;
        }
        //조건
        for (int i = start; i < N; i++){
                tmp[depth] = arr[i];
                dfs(depth + 1, i);

        }
    }
}