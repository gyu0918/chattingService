package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int count;
       char[] find;
       char[] str;
       boolean isfind = false;
       int k, findlen;

       for (int i = 1; i <= 10; i++){
           int num = sc.nextInt();
           //찾아야할 문자열 넣기
           String temp = sc.next();
           find = new char[temp.length()];
           findlen = temp.length();
           for (int j = 0; j < temp.length(); j++){
               find[j] = temp.charAt(j);
           }
           //문장 넣기
           temp = sc.next();
           str = new char[temp.length()];
           count = 0;
           k = 0;
           for (int j = 0; j < temp.length(); j++){
               str[j] = temp.charAt(j);
               if (str[j] == find[k]){
//                   System.out.println("j = " + j + " " +"str = " + str[j] + " " + "find=" + find[k]);
                   isfind = true;
                   k++;
                   if (k == findlen){
                       k = 0;
                       isfind = false;
                       count++;
//                       System.out.println("count" + count);
                   }
               }
//               else if (str[j] == find[0])
               else if (isfind){
                   if (str[j] == find[0])
                       continue;
                   isfind = false;
                   k = 0;
               }
           }
           System.out.println("#" + num + " " + count);
       }
    }
}