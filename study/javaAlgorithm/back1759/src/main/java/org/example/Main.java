package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {

    private static char arr[];
    private static boolean visited[];
    private static int L, C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new char[C];
        visited = new boolean[C];
        //한개 문자씩 들어가는것
        for (int i = 0; i < C; i++){
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);
        dfs(0, 0);
    }

    public static void dfs(int start, int count){
        //종료조건
        if (count == L){
            String word = "";
            int a = 0;
            int b = 0;
            for( int i = 0; i < C; i++){
                if (visited[i]){
                    word += arr[i];
                    if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                        a++;
                    }else {
                        b++;
                    }
                }
            }
            if (a >= 1 && b >= 2){
                System.out.println(word);
            }
        }

        for(int i = start; i < C; i++){
            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }
}