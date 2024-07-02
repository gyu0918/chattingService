package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static char[][] map;
    private static boolean[][] visited;

    private static int N;
    private static int[] count;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        visited = new boolean[N][N];
        count = new int[2];
        for (int i = 0; i < N; i++){
            String str = sc.next();
            for (int j = 0; j < N; j++){
                map[i][j] = str.charAt(j);
            }
        }
        //정상
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    count[0]++;
                }
                //비정상때문에 맵을 바꾼다
                if (map[i][j] == 'G')
                    map[i][j] = 'R';
            }
        }

        visited = new boolean[N][N];
        //비정상
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (!visited[i][j]){
                    bfs(i, j, map[i][j]);
                    count[1]++;
                }
            }
        }
        System.out.println(count[0] + " " + count[1]);
    }

    public static void bfs(int x, int y, char target){
           Queue<int[]> que = new LinkedList<int[]>();
           que.add(new int[] {x, y});
           visited[x][y] = true;
           while(!que.isEmpty()){
               int[] tmp = que.poll();
               x = tmp[0];
               y = tmp[1];
               for (int i = 0; i < 4; i++){
                   int cx = x + dx[i];
                   int cy = y + dy[i];
                   if (cx >= 0 && cy >= 0 && cx < N && cy < N)
                       if (!visited[cx][cy] && map[cx][cy] == target){
                           visited[cx][cy] = true;
                           que.add(new int[] {cx, cy});
                       }
               }
           }

    }
}