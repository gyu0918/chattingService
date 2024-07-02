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
            int k = sc.nextInt();
            ArrayList <Integer> a = new ArrayList();

            for(int i = 0; i < n; i++) {
                int tmp = sc.nextInt();
                a.add(tmp);
            }

            Collections.sort(a, Collections.reverseOrder());
            int sum = 0;
            for(int i = 0; i < k; i++) {
                sum += a.get(i);
            }
            System.out.println("#" + t + " " + sum);
        }
    }

    //시간 초과
//    private static int[] arr;
//    private static int sum, chooseSubject;
//
//    public static void main(String[] args) {
//      Scanner sc = new Scanner(System.in);
//      int T = sc.nextInt();
//      int allSubject;
//      for (int test_case = 1; test_case <= T; test_case++){
//          allSubject = sc.nextInt();
//          chooseSubject = sc.nextInt();
//          arr = new int[allSubject];
//          for (int i = 0; i < allSubject; i++){
//              arr[i] = sc.nextInt();
//          }
//          sum = 0;
//          dfs(0, 0);
//          System.out.println("#" + test_case + " " + sum);
//      }
//    }
//    public static void dfs(int count, int score){
//        //종료 조건
//        if (chooseSubject == count){
//            if (sum < score)
//                sum = score;
//            return ;
//        }
//        dfs(count + 1, score + arr[count]);
//        dfs(count + 1,score);
//    }

}