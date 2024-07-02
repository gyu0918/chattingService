package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++){
            int x = 0;
            int y = 0;
            n = sc.nextInt();
            map = new int[16][16];
            visited = new boolean[16][16];
            for (int i = 0; i < 16; i++){
                String str = sc.next();
                for (int j = 0; j < 16; j++){
                    map[i][j] = str.charAt(j) - '0';
                    if (map[i][j] == 2){
                        x = i;
                        y = j;
                    }
                }
            }
            System.out.print("#" + test_case + " ");
            bfs(x,y);
        }
    }
    public static void bfs(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {x,y});
        visited[x][y] = true;
        while (!que.isEmpty()){
            int[] tmp = que.poll();
            int curX = tmp[0];
            int curY = tmp[1];
            for(int i = 0; i < 4; i++){
                int nX = curX + dx[i];
                int nY = curY + dy[i];
                if (nX >= 0 && nX < 16 && nY >= 0 && nY < 16 && !visited[nX][nY] && map[nX][nY] != 1) {
                    if (map[nX][nY] == 3){
                        System.out.println(1);
                        return ;
                    }
                    que.add(new int[]{nX, nY});
                    visited[nX][nY] = true;
                }
            }
        }
        System.out.println(0);
    }
}