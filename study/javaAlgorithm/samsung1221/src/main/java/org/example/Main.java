package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main { ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] num = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        for (int test_case = 1; test_case <= T; test_case++){
            ArrayList<Integer> arr = new ArrayList<>();
            int N = sc.nextInt();
            for (int i = 0; i < N; i++){
                String tmp = sc.next();
                for (int j = 0; j < 10;j++){
                    if (num[j].equals(tmp)){
                        arr.add(j);
                    }
                }
            }
            Collections.sort(arr);
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++){
                int tmp = arr.get(i);
                System.out.print(num[tmp] + " ");
            }
            System.out.println();
        }
    }
}

