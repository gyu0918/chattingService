package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {

    //위,아래,왼쪽,오른쪽
    private static int[] xdir = {-1,1,0,0};
    private static int[] ydir = {0,0,-1,1};
    private static int N, min;
    private static boolean[][] visited;
    private static int[][] ans;

    private static int[][] map;
    private static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++){
            N = sc.nextInt();
            map = new int[N][N];
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            sum = 0;
            bfs();
            System.out.println("#" + test_case + " " + sum);
        }
    }
    public static void bfs(){

    }
}