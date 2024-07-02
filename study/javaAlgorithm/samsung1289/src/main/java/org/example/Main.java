package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr;

        for (int test_case = 1; test_case <= T; test_case++){
            String str = sc.next();
            arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++){
                arr[i] = str.charAt(i) - '0';
            }
            int num = arr[0];
            for (int i = 0; i < str.length() - 1; i++){
                if (arr[i] != arr[i + 1])
                    num += 1;
            }
            System.out.println("#" + test_case + " " + num);
        }
    }
}