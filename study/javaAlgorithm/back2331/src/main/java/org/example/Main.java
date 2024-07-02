package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>(); //숫자 순서대로 저장
        HashSet<Integer> set = new HashSet<>(); //숫자 중복 체크
        list.add(N);
        set.add(N);

        while (true){
            int num = makeNum(N,x);  // 다음 숫자 계산
            if (set.contains(num)){   // 중복된 숫자 있는지 확인하는것
                System.out.println(list.indexOf(num));
                break ;
            }
            //새로운 숫자일 경우 set, list 에 add
            list.add(num);
            set.add(num);
            N = num;
        }



    }
    public static int makeNum(int N, int x){
        int sum = 0;
        while (N > 0){
            sum += Math.pow(N%10,x);
            N /= 10;
        }
        return sum;
    }
}