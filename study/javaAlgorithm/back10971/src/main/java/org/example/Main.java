package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[] visited;
    private static int min;
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= N; i++){
            visited[i] = true;
            dfs(i,i,0,0);
            visited[i] = false;
        }

        System.out.println(min);
    }
    public static void dfs(int start, int now, int sum, int cnt){
        //종료 조건
        if (cnt == N - 1){
            if (map[now][start] != 0 ){
                sum += map[now][start];
                if (sum < min)
                    min = sum;
            }
            return ;
        }
        //dfs조건
        for (int i = 1; i <= N; i++){
            if (!visited[i] && map[now][i] != 0){
                visited[i] = true;
                dfs(start,i,sum + map[now][i],cnt + 1);
                visited[i] = false;
            }
        }
    }
}

import java.util.*;
public class Main {

    static int N;
    static int[][] array;
    static boolean visited[];
    static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for(int i=1;i<=N;i++) {
            visited[i]=true;
            DFS(i,i,0,0);
            visited[i]=false;
        }

        System.out.println(answer);
    }

    public static void DFS(int start, int now, int sum, int cnt) {
        if(cnt==N-1) {
            if(array[now][start]!=0) {
                sum += array[now][start];
                if(sum<answer) answer = sum;
            }
            return;
        }

        for(int i=1;i<=N;i++) {
            if(visited[i]==false && array[now][i]!=0) {
                visited[i]=true;
                DFS(start,i,sum+array[now][i],cnt+1);
                visited[i]=false;
            }
        }
    }

}