package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static int[][] map;

    private static boolean[][] visited;

    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static int N,M,count;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                  map[i][j] = sc.nextInt();
            }
        }
        count = 0;
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (!visited[i][j] && map[i][j] == 2){
                    bfs(i,j);
                }
            }
        }
        System.out.println(count);
    }

    public static void bfs(int x, int y){
        Queue<int[]> que = new LinkedList<int[]>();
        que.add(new int[] {x, y});
        visited[x][y] = true;
        while (!que.isEmpty()){
            int[] temp = que.poll();
            x = temp[0];
            y = temp[1];
            for (int i = 0; i < 4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                if (cx >= 0 && cy >= 0 && cx < M && cy < N){
                    if (!visited[cx][cy] && )
                }
            }
        }
    }
}