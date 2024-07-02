package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static int N,M;
    private static int[][] map, visited;
    //문슨 방향?
//    dx[0] = -1, dy[0] = 0: 위 (북)
//    dx[1] = 1, dy[1] = 0: 아래 (남)
//    dx[2] = 0, dy[2] = 1: 오른쪽 (동)
//    dx[3] = 0, dy[3] = -1: 왼쪽 (서)
//    dx[4] = 1, dy[4] = 1: 오른쪽 아래 (남동)
//    dx[5] = 1, dy[5] = -1: 왼쪽 아래 (남서)
//    dx[6] = -1, dy[6] = 1: 오른쪽 위 (북동)
//    dx[7] = -1, dy[7] = -1: 왼쪽 위 (북서)
    private static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    private static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new int[N][M];
        Queue<Node> que = new LinkedList<>();

        //맵 만들기
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                visited[i][j] = Integer.MAX_VALUE;
                if (map[i][j] == 1){
                    que.add(new Node(i,j));
                    visited[i][j] = 0;
                }
            }
        }

        //판별
        int answer = 0;
        while(!que.isEmpty()){
            Node tmp = que.poll();
            for (int i = 0; i < 8; i++){
                int nX = tmp.x + dx[i];
                int nY = tmp.y + dy[i];
                if (nX >= 0 && nY >= 0 && nX < N && nY < M){
                    if (visited[nX][nY] > visited[tmp.x][tmp.y] + 1){
                        visited[nX][nY] = visited[tmp.x][tmp.y] + 1;
                        que.add(new Node(nX,nY));
                        answer = Math.max(answer,visited[nX][nY]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}