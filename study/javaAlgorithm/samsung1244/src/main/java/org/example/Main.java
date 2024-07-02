package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static int chance, max;
    private static String[] arr;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            arr = sc.next().split("");
            chance = sc.nextInt();
            max = 0;
            //시간초과 최적화
            if (arr.length < chance){
                chance = arr.length;  //자릿수만큼만 옮겨도 전부 옮길 수 있음
            }
            dfs(0, 0);
            System.out.println("#" + test_case + " " + max);
        }
    }

    private static void dfs(int start, int count){
        if (count == chance){
            String result = "";
            for(String s : arr)
                result += s;
            max = Math.max(max, Integer.parseInt(result));
            return ;
        }
        for( int i = start; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                //swap
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                dfs(i, count + 1);  //깊이 + 1
                //다시 swap해서 되돌림
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
    }
}