package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
public class Main {

    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static boolean[][] visited;
    private static int[][] map;
    private static int M, N, K;
    private static int earthWorm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++){
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            map = new int[M][N];
            visited = new boolean[M][N];
            for (int i = 0; i < K; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }
            earthWorm = 0;

            for (int i = 0; i < M; i++){
                for (int  j = 0; j < N; j++){
                    if (!visited[i][j] && map[i][j] == 1){
                        bfs(i,j);
                        earthWorm++;
                    }
                }
            }
            System.out.println(earthWorm);
        }
    }
    public static void bfs(int x, int y){
        Queue<int[]> que = new LinkedList<int[]>();
        que.add(new int[] {x, y});

        while (!que.isEmpty()){
            int[] current = que.poll();
            x = current[0];
            y = current[1];
            visited[x][y] = true;
            for (int i = 0; i < 4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < M && cy < N){
                    if (!visited[cx][cy] && map[cx][cy] == 1){
                        que.add(new int[] {cx,cy});
                        visited[cx][cy] = true;
                    }
                }
            }
        }
    }
}