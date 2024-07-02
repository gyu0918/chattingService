package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {

    private static int max, N,limit;
    private static int[] score;
    private static int[] calorie;

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int T = sc.nextInt();

       for (int test_case = 1; test_case <= T; test_case++){
            N = sc.nextInt();
            limit = sc.nextInt();
            score = new int[N];
            calorie = new int[N];
            max = 0;
            for (int i = 0; i < N; i++){
                score[i] = sc.nextInt();
                calorie[i] = sc.nextInt();
            }

           dfs(0, 0 ,0);

           System.out.println("#" + test_case + " " + max);
       }
    }
    public static void dfs(int i, int scoreSum, int calorieSum){
        //종료 조건
        if (limit < calorieSum){
            return ;
        }
        if (i == N){
            max = Math.max(scoreSum,max);
        }
        else {
            dfs(i + 1, scoreSum + score[i], calorieSum + calorie[i]);
            dfs(i + 1, scoreSum, calorieSum);
        }

    }
}