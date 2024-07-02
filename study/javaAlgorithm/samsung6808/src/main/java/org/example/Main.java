package org.example;

import java.util.*;

public class Main {
    private static final int C = 9;
    private static int[] inYoung = new int[C];
    private static int[] gyuYoung = new int[C];
    private static boolean[] visited;
    private static int[] inCards;
    private static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            boolean[] allCard = new boolean[C * 2 + 1];

            for (int i = 0; i < C; i++) {
                gyuYoung[i] = sc.nextInt();
                allCard[gyuYoung[i]] = true;
            }
            // 규영이가 가지고 있지 않은 카드들을 인영에게 넣어줌
            int index = 0;
            for (int i = 1; i < allCard.length; i++) {
                if (!allCard[i]) {
                    inYoung[index++] = i;
                }
            }

            inCards = new int[C]; // 인영이가 낼 수 있는 조합
            result = new int[2]; // 결과 출력
            visited = new boolean[C]; // 방문 여부 체크

            perm(0);
            System.out.println("#" + test_case + " " + result[1] + " " + result[0]);
        }
    }

    // 순열 생성
    private static void perm(int cnt) {
        if (cnt == inCards.length) {
            cal();
            return;
        }
        for (int i = 0; i < inYoung.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                inCards[cnt] = inYoung[i];
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }

    // 점수 계산
    private static void cal() {
        int inSum = 0; // 인영이 점수
        int gyuSum = 0; // 규영이 점수

        for (int i = 0; i < inCards.length; i++) {
            if (inCards[i] < gyuYoung[i]) {
                gyuSum += inCards[i] + gyuYoung[i];
            } else {
                inSum += inCards[i] + gyuYoung[i];
            }
        }

        if (gyuSum > inSum)
            result[1]++; // 규영이 승리
        else if (gyuSum < inSum)
            result[0]++; // 인영이 승리
    }
}
