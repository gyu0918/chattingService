package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static int R,C;
    private static char[][] map;
    private static boolean[][] visited;

    private static Temp gosum;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++){
            String str = sc.next();
            for (int  j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
                if (map[i][j] == '*'){
                    gosum = new Temp(i,j,0,0);
                }
            }
        }
        bfs();
    }
    public static void bfs(){
        Queue<Temp> que = new LinkedList<>();
        que.add()
    }
    public static class Temp(){
        int x, y;
        int type;     // 0->고숨도치 1->
        int cnt;

        public Temp(int x, int y, int type, int cnt) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.cnt = cnt;
        }
    }
}