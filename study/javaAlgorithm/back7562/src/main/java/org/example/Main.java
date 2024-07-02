package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {

    private static int[][] pos = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static int nowX, nowY;
    private static int desX, desY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++){
            N = sc.nextInt();
            map = new int[N][N];
            visited = new boolean[N][N];
            nowX = sc.nextInt();
            nowY = sc.nextInt();
            desX = sc.nextInt();
            desY = sc.nextInt();
            visited[nowX][nowY] = true;
            bfs(nowX,nowY);
            System.out.println(map[desX][desY]);
        }
    }
    public static void bfs(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y});
        while (!que.isEmpty()){
            int[] now = que.poll();
            int nowXX = now[0];
            int nowYY = now[1];
            for (int i = 0; i <pos.length; i++){
                int nX = nowXX + pos[i][0];
                int nY = nowYY + pos[i][1];
                if (nX < 0 || nX >= N || nY < 0 || nY >= N || visited[nX][nY] || map[nX][nY] != 0){
                    continue;
                }
                visited[nX][nY] = true;
                map[nX][nY] = map[nowXX][nowYY] + 1;
                que.add(new int[] {nX, nY});
            }
        }
    }
}

public class q7562 {

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<pos.length; i++) {
                int nX = nowX + pos[i][0];
                int nY = nowY + pos[i][1];

                if(nX < 0 || nX >= n || nY < 0 || nY >= n || visited[nX][nY] || graph[nX][nY] != 0) {
                    continue;
                }

                visited[nX][nY] = true;
                graph[nX][nY] = graph[nowX][nowY] + 1;
                queue.add(new int[] {nX, nY});
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int t = 0; t < test; t++) {
            n = sc.nextInt();
            graph = new int[n][n];
            visited = new boolean[n][n];

            nowX = sc.nextInt();
            nowY = sc.nextInt();
            desX = sc.nextInt();
            desY = sc.nextInt();

            visited[nowX][nowY] = true;
            bfs(nowX, nowY);
            System.out.println(graph[desX][desY]);

        }
    }
}