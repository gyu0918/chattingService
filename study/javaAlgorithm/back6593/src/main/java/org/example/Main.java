package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {

    static int l,r,c;
    static char[][][] map;
    static int[] dx= {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true) {
            l = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();
            if(l ==0 && r==0 && c==0) {
                return;
            }

            int sx=0,sy=0,sz=0;
            map =new char[l][r][c];
            for(int i=0; i<l; i++) {
                for(int j=0; j<r; j++) {
                    String line = sc.next();
                    for(int k=0; k<c; k++) {
                        map[i][j][k] = line.charAt(k);
                        if(map[i][j][k] == 'S') {
                            sx =k; sy = j; sz =i;
                            map[i][j][k] = '.';
                        }
                    }
                }
            }
            bfs(sx, sy, sz);
        }
    }

    static void bfs(int x, int y, int z) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] check = new boolean[l][r][c];
        q.add(new int[] {x,y,z,0});
        check[z][y][x] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();
            int px=p[0], py=p[1], pz=p[2];
            int move = p[3];

            if(map[pz][py][px]=='E') {
                System.out.println("Escaped in " + move+" minute(s).");
                return;
            }

            for(int d=0; d<6; d++) {
                int nx = px + dx[d], ny = py + dy[d], nz = pz + dz[d];
                if(nx <0 || ny <0 || nz<0 || nx>c-1 || ny>r-1 || nz >l-1) continue;
                if(check[nz][ny][nx]) continue;
                if(map[nz][ny][nx]=='.' || map[nz][ny][nx]=='E') {
                    check[nz][ny][nx] = true;
                    q.add(new int[] {nx, ny, nz, move+1});
                }
            }
        }
        System.out.println("Trapped!");
    }
}