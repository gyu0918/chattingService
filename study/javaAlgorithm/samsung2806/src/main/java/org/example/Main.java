package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static int[] queenLocation;
    private static int  queenNum, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++){
            queenNum = sc.nextInt();
            queenLocation = new int[queenNum];
            // queenLocation은 각 행마다 놓여진 퀸의 열을 저장합니다. 예를 들어 queenLocation = [2, 3, 1, 2]는 (0, 2), (1, 3), (2, 1), (3, 2)에 퀸이 놓여있다는 뜻입니다.

            result = 0;
            dfs(0);
            System.out.println("#" + test_case + " " + result);
        }
    }
    public static void dfs(int count){
        boolean isPossible;

        //종료조건
        if (count == queenNum){
            result++;
            return ;
        }

        //판별 조건
        for (int i = 0; i < queenNum; i++){
            isPossible = true;
            for (int j = 0; j < count; j++) {
                if (queenLocation[j] == i || i == queenLocation[j] + (count - j) || i == queenLocation[j] - (count - j)) {        //직선, 대각선 확인
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                queenLocation[count] = i;
                dfs(count + 1);
            }
        }

    }
}