package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int test = sc.nextInt();

            for(int t = 1; t <= test; t++) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int sum = 0;
                int[] r = new int[n];
                int[] w = new int[m];
                int[] p = new int[n];

                Queue <Integer> q = new LinkedList();
                Queue <Integer> rq = new LinkedList();

                for(int i = 0; i < n; i++) {
                    r[i] = sc.nextInt();
                }

                for(int i = 0; i < m; i++) {
                    w[i] = sc.nextInt();
                }
                //우선 큐에 넣는다.
                for(int i = 0; i < 2 * m; i++) {
                    int tmp = sc.nextInt();
                    q.add(tmp);
                }

                int cnt = 0;
                // 단위 무게당 요금 R_i = {2, 3, 5}
                // 차량의 무게 W_i = {2, 1, 3, 8}
                while(!q.isEmpty()) {
                    int num;
                    if(cnt < n && !rq.isEmpty()) {
                        num = rq.poll();
                        for(int i = 0; i < n; i++) {
                            if(p[i] == 0) {
                                p[i] = num;
                                sum += w[num - 1] * r[i];
                                cnt++;
                                break;
                            }
                        }
                    }else {
                        num = q.poll();
                        if(num > 0) {
                            if(cnt < n) {
                                for(int i = 0; i < n; i++) {
                                    if(p[i] == 0) {
                                        p[i] = num;
                                        sum += w[num - 1] * r[i];
                                        cnt++;
                                        break;
                                    }
                                }
                            }
                            else {
                                rq.add(num);
                            }
                        }
                        else {
                            for(int i = 0; i < n; i++) {
                                if(p[i] == -1 * num) {
                                    p[i] = 0;
                                    cnt--;
                                }
                            }
                        }
                    }
                }
                System.out.println("#" + t + " " + sum);
            }
    }
}
