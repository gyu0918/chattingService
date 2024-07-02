package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static int num;
    private static char[][] strArr;

    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        num = sc.nextInt();
        strArr = new char[8][8];
        for(int i = 0; i < strArr.length; i++){
            String str = sc.next();
            for (int j = 0; j < strArr[i].length; j++){
                strArr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < strArr.length; i++){
            for (int j = 0; j < strArr.length - num + 1; j++){
                //가로  회문 찾기
                flag = true;
                for(int k = 0; k < num / 2; k++){
                    if (strArr[i][j + k] != strArr[i][j - k + num + 1])
                        flag = false;
                }
                if (flag) count++;

                //세로 회문 찾기
                flag = true;
                for(int k = 0; k < num/2; k++){
                    if (strArr[j + k][i] != strArr[j - k + num + 1][i])
                        flag = false;
                }
                if (flag) count++;
            }
        }
        System.out.println("#" + + " " + count);

    }
}