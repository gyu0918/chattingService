package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {

    static int[] arr,tmp;
    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        tmp = new int[N];
        for (int i = 0 ; i < N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        dfs();
    }
    public static void dfs(){
        
    }
}