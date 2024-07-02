package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static int M,N,K;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static boolean[][] visited;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[M][N];
        visited = new boolean[M][N];
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();

        //사각형에 1식 채워 넣기
        for (int i = 0; i < K; i++){
            int lx = sc.nextInt(); // 왼쪽 위 x
            int ly = sc.nextInt(); // 왼쪽 위 y
            int rx = sc.nextInt(); // 오른쪽 아래 x
            int ry = sc.nextInt(); // 오른쪽 아래 y
            for (int y = ly; y < ry; y++){
                for (int x = lx; x < rx; x++){
                    map[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (!visited[i][j] && map[i][j] == 0){
                    int data = bfs(i, j);
                    list.add(data);
                    count++;
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for (int  i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
    private static int bfs(int x, int y){
        Queue<int[]> que = new LinkedList<int[]>();
        que.offer(new int[] {x, y});
        visited[x][y] = true;
        int cnt = 1;

        while (!que.isEmpty()){
            int[] data = que.poll();
            int curX = data[0];
            int curY = data[1];

            for (int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N){
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 0){
                        visited[nextX][nextY] = true;
                        que.offer(new int[] {nextX, nextY});
                        cnt++;
                    }
                }

            }
        }
        return cnt;
    }

}