package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr;
        int[] sum;
        int t, num;

        sum = new int[202];
        arr = new int[100][100];
        t = sc.nextInt();
        num = 0;
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                arr[i][j] = sc.nextInt();
                sum[num] += arr[i][j];
            }
            num++;
        }
        //sum[99] 까지 가로 끝
        // 세로 시작 sum[100]으로 시작
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                sum[num] += arr[j][i];
            }
            num++;
        }
        //sum[199] 까지 세로 끝
        //오른쪽 아래 대각선 시작
        int j = 0;
        for (int i = 0; i < 100; i++){
            sum[200] += arr[i][j];
            j++;
        }
        //왼쪽 아래 대각선 시작
        j = 0;
        for (int i = 99; i > 0; i--){
            sum[201] += arr[i][j];
            j++;
        }
        //마무리
        Arrays.sort(sum);
        System.out.println("#" + t + " " + sum[201]);
    }
}



        //        //가로
//        j = 0;
//        for (int i = 0; i < 10000; i++){
//            arr[i] = sc.nextInt();
//            if (i % 100 == 0)
//                j++;
//            sum[j] += arr[i];
//        }
//
//        //세로
//        j++;
//        int i = 0;
//        while (i < 10000){
//
//            i+5;
//        }
        //대각선

