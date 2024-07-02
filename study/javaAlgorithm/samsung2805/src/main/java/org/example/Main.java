package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N, priceSum, range;
        int[][] arr;

        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            arr = new int[N][N];
            //숫자가 띄어쓰기 없이 있으면 다르게 풀어야 한다 밑에는 1 2 3 4 이런식으로 띄어쓰기로 있는 경우 가능
//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < N; j++){
//                    arr[i][j] = sc.nextInt();
//                }
//            }
            for(int i = 0; i < N; i++){
                String str = sc.next();
                for (int j = 0; j < N; j++){
                    arr[i][j] = str.charAt(j) - '0';
                }
            }
            priceSum = 0;
            range = 1;
            for (int i = 0; i < N/2; i++){
                int temp = N/2 - i;
                for (int j = 0; j < range; j++){
                    //위에것
                    priceSum += arr[i][temp + j];
                    //아래것
                    priceSum += arr[N - 1 - i][temp + j];
                }
                range += 2;
            }
            // 중간줄은 모두 더하면 되기 떄문에
            for(int i = 0; i < N; i++) {
                priceSum += arr[N/2][i];
            }
            System.out.println("#" + test_case + " " + priceSum);
        }
    }
}