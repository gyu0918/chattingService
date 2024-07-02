package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static int[] start,end;
    private static boolean[][] visited;
    private static char[][] map;
    private static int N,M,K;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new char[N][M];
        start = new int[2];
        end = new int[2];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++){
            String tmp = sc.next();
            for (int j = 0; j < M; j++){
                map[i][j] = tmp.charAt(j);
            }
        }
        start[0] = sc.nextInt() - 1;
        start[1] = sc.nextInt() - 1;
        end[0] = sc.nextInt() - 1;
        end[1] = sc.nextInt() - 1;
//        System.out.println("start[0] =  " + start[0] + "end[0] = " + end[0]);
        bfs();

    }
    public static void bfs(){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start[0],start[1],0));
        visited[start[0]][start[1]] = true;
        while (!que.isEmpty()){
            Node tmp = que.poll();
            for (int i = 0; i < 4; i++){
                for (int j = 1; j <= K; j++) {
                    int nX = tmp.x + dx[i] * j;
                    int nY = tmp.y + dy[i] * j;

                    if (nX < 0 || nY < 0 || nX >= N || nY >= M || map[nX][nY] != '.' || visited[nX][nY]) {
                        break;
                    }

                    if (nX == end[0] && nY == end[1]) {
                        System.out.println(tmp.cnt + 1);
                        return;
                    }

                    visited[nX][nY] = true;
                    que.add(new Node(nX, nY, tmp.cnt + 1));
                }
            }
        }
        System.out.println(-1);
    }
}
// 시간초과ㄷ 뜬다 답은 맞고
import java.util.*;

public class Main {
    private static int N, M, K;
    private static char[][] map;
    private static int[] start, end;
    private static int[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new char[N][M];
        start = new int[2];
        end = new int[2];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        start[0] = sc.nextInt() - 1;
        start[1] = sc.nextInt() - 1;
        end[0] = sc.nextInt() - 1;
        end[1] = sc.nextInt() - 1;

        bfs();
    }

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = 0;

        while (!que.isEmpty()) {
            Node current = que.poll();

            if (current.x == end[0] && current.y == end[1]) {
                System.out.println(current.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= K; j++) {
                    int nX = current.x + dx[i] * j;
                    int nY = current.y + dy[i] * j;

                    if (nX < 0 || nY < 0 || nX >= N || nY >= M || map[nX][nY] == '#') {
                        break; // 해당 방향으로 더 나아갈 수 없으면 중단
                    }

                    if (visited[nX][nY] > current.cnt + 1) {
                        visited[nX][nY] = current.cnt + 1;
                        que.add(new Node(nX, nY, current.cnt + 1));
                    }
                }
            }
        }

        System.out.println(-1); // 도달할 수 없는 경우
    }
}

//97퍼센트에서 시간초과뜨는거 해결
import java.util.*;

public class Main {
    private static int N, M, K;
    private static char[][] map;
    private static int[] start, end;
    private static int[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new char[N][M];
        start = new int[2];
        end = new int[2];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        start[0] = sc.nextInt() - 1;
        start[1] = sc.nextInt() - 1;
        end[0] = sc.nextInt() - 1;
        end[1] = sc.nextInt() - 1;

        bfs();
    }

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = 0;

        while (!que.isEmpty()) {
            Node current = que.poll();

            if (current.x == end[0] && current.y == end[1]) {
                System.out.println(current.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nX = current.x;
                int nY = current.y;

                for (int j = 1; j <= K; j++) {
                    nX += dx[i];
                    nY += dy[i];

                    if (nX < 0 || nY < 0 || nX >= N || nY >= M || map[nX][nY] == '#') {
                        break; // 벽이나 경계를 만나면 중단
                    }

                    if (visited[nX][nY] <= current.cnt) {
                        break; // 이미 더 빠르거나 같은 시간에 방문한 경우 중단
                    }

                    if (visited[nX][nY] > current.cnt + 1) {
                        visited[nX][nY] = current.cnt + 1;
                        que.add(new Node(nX, nY, current.cnt + 1));
                    }
                }
            }
        }

        System.out.println(-1); // 도달할 수 없는 경우
    }
}

