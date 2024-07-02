package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.*;

public class Main {
    private static char[][] map;
    private static boolean[][] visited;
    private static int w, h;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static Pos sanggun;
    private static Queue<Pos> que;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            w = sc.nextInt();
            h = sc.nextInt();
            map = new char[h][w];
            visited = new boolean[h][w];
            que = new LinkedList<>();   //que 초기화시키

            boolean found = false;  //초기 탈출 확인용 플레그
            for (int i = 0; i < h; i++) {
                String str = sc.next();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    //가장자리 일경우 바로 탈출하는 경우
                    if (map[i][j] == '@') {
                        if (i == 0 || j == 0 || i == h - 1 || j == w - 1) {
                            System.out.println(1);
                            found = true;
                            break;
                        }
                        //상근 자리를 . 으로 만들어줌
                        sanggun = new Pos(i, j, 0, 0);
                        map[i][j] = '.';
                    } else if (map[i][j] == '*') {
                        que.add(new Pos(i, j, 1, 0));
                    }
                }
                if (found) break; // 탈출 가능 시 루프 중지
            }
            if (!found) { // 초기 탈출이 불가능할 때만 bfs 호출
                bfs();
            }
        }
    }
    public static void bfs(){
        //bfs로 들어오자 마자 상근이 큐로 넣어준다
//        System.out.println("x= " + sanggun.x + " y = " + sanggun.y);
        que.add(sanggun);
        visited[sanggun.x][sanggun.y] = true;
        while(!que.isEmpty()){
            Pos tmp = que.poll();
            int curX = tmp.x;
            int curY = tmp.y;
//            System.out.println("curX = " + curX + " curY = " + curY);
            int cnt = tmp.cnt;
            //가장자리 && 상근(type == 0)
            if ((curX == 0 || curY == 0 || curX == h - 1 || curY == w - 1 ) && tmp.type == 0){
                System.out.println(cnt + 1);
                return ;
            }
            //4가지 방향 확인
            for (int i = 0; i < 4; i++){
                int nX = curX + dx[i];
                int nY = curY + dy[i];
                //큐에 들어가지 않아도 되는 경우
                if (nX < 0 || nY < 0 || nX >= h || nY >= w || map[nX][nY] == '*' || map[nX][nY] == '#'){
                    continue ;
                }
                if (tmp.type == 0 && !visited[nX][nY]){     //상근이처리
                    que.add(new Pos(nX,nY,0,cnt + 1));
                    visited[nX][nY] = true;
                }else{  // 불 처리
                    que.add(new Pos(nX,nY,1,cnt + 1));
                    map[nX][nY] = '*';
                }

            }
        }
        System.out.println("IMPOSSIBLE");
    }
    public static class Pos{
        int x,y;
        int type; // 0 ->상근 1->불
        int cnt;

        public Pos(int x, int y, int type, int cnt) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.cnt = cnt;
        }
    }
}