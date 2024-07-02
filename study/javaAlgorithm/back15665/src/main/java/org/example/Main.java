package org.example;

import java.util.*;
import java.io.*;

public class Main {

    private static int N,M;
    private static int[] arr, result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        DFS(0);
        System.out.println(sb);
    }

    public static void DFS(int depth){
        //종료 조건
        if (depth == M){
            for (int i = 0; i < M; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }
        //DFS조건
        int before = -1;
        for (int i = 0; i < N; i++){
            int now = arr[i];
            if (before != now){
                before = now;
                result[depth] = arr[i];
                DFS(depth + 1);
            }
        }
    }
}