package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;


public class Main {
    private static int horizontal, vertical, count, days;
    private static int[][] box;
    //위아래 왼쪽 오른쪽
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    private static Queue<int[]> que = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        horizontal = sc.nextInt();
        vertical = sc.nextInt();
        box = new int[vertical][horizontal];
        for (int i = 0; i < vertical; i++){
            for (int j = 0; j < horizontal; j++){
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1)
                    que.add(new int[]{i,j});
                else if (box[i][j] == 0)
                    count++;
            }
        }
        //풀이 시작
        while (count > 0 && !que.isEmpty()){
            for (int s = que.size(); s > 0; s--){
                int[] cur = que.poll();
                for (int k = 0; k < 4; k++){
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];
                    if (ny < 0 || nx < 0 || ny >= vertical || nx >= horizontal || box[ny][nx] != 0)
                        continue;
                    count--;
                    box[ny][nx] = 1;
                    que.add(new int[] {ny, nx});
                }
            }
            days++;
        }
        System.out.println(count == 0 ? days : -1);
    }
}