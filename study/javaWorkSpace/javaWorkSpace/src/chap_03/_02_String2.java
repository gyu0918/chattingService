package chap_03;

public class _02_String2 {
    public static void main(String[] args) {
        String s = "I Like Java and Python and C.";

        //문자열 변환
        System.out.println(s.replace(" and", ","));
        System.out.println(s.substring(7)); //7번쨰 부터 시작 이전은 삭제

    }
}
