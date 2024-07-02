package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++){
            int N = sc.nextInt();
            LinkedList<Integer> l = new LinkedList<>();

            String temp = sc.next();
            for (int i = 0; i < N; i++){
                int tmp = temp.charAt(i) - '0';
                l.add(tmp);
            }
            int i = 1;
            while(true){
                if (l.get(i) == l.get(i - 1)){
                    l.remove(i);
                    l.remove(i - 1);
                    i = 1;
                }else {
                    i++;
                }
                if (i >= l.size())
                    break;
            }
            System.out.println("#" + test_case + " ");
            for (int j = 0; j < l.size(); j++){
                System.out.print(l.get(j));
            }
            System.out.println();
        }
    }

}