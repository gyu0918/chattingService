package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
//
//public class Main {
//    public static int N;
//    public static int[] arr;
//
//    public static int[] temp;
//    public static void buildingCheck(int num){
//        int count = 0;
//
//        temp = new int[4];
//        for (int i = 2; i < N-2; i++){
//            temp[0] = arr[i - 2];
//            temp[1] = arr[i - 1];
//            temp[2] = arr[i + 1];
//            temp[3] = arr[i + 2];
//            Arrays.sort(temp);
//            if (arr[i] > temp[3]) {
//                count += arr[i] - temp[3];
//            }
//        }
//        System.out.println("#" + (num + 1) + " " + count);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        for (int i = 0; i < 10; i++){
//            N = sc.nextInt();
//            arr = new int[N];
//            for (int j = 0; j < N; j++){
//                arr[j] = sc.nextInt();
//            }
//
//            buildingCheck(i);
//        }
//    }
//}


class Main
{
    static int N;
    static int[] arr; // 건물 넣는 배열

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = 10; // TestCase 수
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt(); // 건물 갯수
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int cnt = 0;
            for (int i = 2; i < N - 2; i++) {
                int max = Math.max(arr[i - 2] , Math.max(arr[i - 1] , Math.max(arr[i + 1], arr[i+ 2])));
                
                if (arr[i] - max > 0) // 좌 우 건물 높이의 최댓값보다 현재 건물의 높이가 높으면
                    cnt += arr[i] - max;
            }

            System.out.println("#" + tc + " " + cnt);
        } // end of TC
    } // end of Main
}