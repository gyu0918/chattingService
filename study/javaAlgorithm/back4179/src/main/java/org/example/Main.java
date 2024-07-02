package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static char[][] map;
    private static boolean[][] visited;
    private static int R, C, count;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    private static Queue<Pos> que = new LinkedList<>();
    private static Pos jihoon;  // 지훈이 위치, 타입, 횟수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        visited = new boolean[R][C];
        //맵 만들기
        for (int i = 0; i < R; i++){
            String str = sc.next();
            for (int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
                //첫 위치부터 탈출 가능할 경우
                if (map[i][j] == 'J'){
                    if (i == 0 || j == 0 || i == R - 1 || j == C - 1){
                        System.out.println(1);
                        return ;
                    }
                    //지훈이 첫 위치를 '.' 으로 바꿈
                    map[i][j] = '.';
                    jihoon = new Pos(i,j,0,0);
                }else if (map[i][j] == 'F'){
                    que.add(new Pos(i,j,1,0));
                }

            }
        }
        bfs();
    }

    public static void bfs(){
        // bfs메서드로 오기 전까지 불관련 먼저 넣어두고 j위치를 이제 넣는 why?
        //이유는 불에 탈 수 있는 위치에 지훈이 있으면 안되기 때문에 불 먼저 번지게 하고 지훈을 이동시킨다.
        que.add(jihoon);
        visited[jihoon.x][jihoon.y] = true;
        while(!que.isEmpty()){
            Pos p = que.poll();
            int curX = p.x;
            int curY = p.y;
            int cnt = p.cnt;
            //가장자리 && 지훈(type == 0)
            if ((curX == 0 || curY == 0 || curX == R - 1 || curY == C - 1 ) && p.type == 0){
                System.out.println(cnt + 1);
                return ;
            }
            //4방향 체크
            for (int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                //큐에 안넣어도 되는 조건
                if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C || map[nextX][nextY] == '#'
                        || map[nextX][nextY] == 'F'){
                    continue;
                }
                //
                if (p.type == 0 && !visited[nextX][nextY]){     //지훈이처리
                    que.add(new Pos(nextX,nextY,0,cnt + 1));
                    visited[nextX][nextY] = true;
                }else{  // 불 처리
                    que.add(new Pos(nextX,nextY,1,cnt + 1));
                    map[nextX][nextY] = 'F';
                }
            }


        }
        System.out.println("IMPOSSIBLE");
    }

    public static class Pos{
        int x, y;
        int type;   //0->지훈 , 1->불
        int cnt;

        public Pos(int x, int y, int type, int cnt) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.cnt = cnt;
        }
    }
}