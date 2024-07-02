package chap_03;

import javax.lang.model.element.NestingKind;

public class _01_String1 {
    public static void main(String[] args) {
        String s = "I Like Java and Python and C.";
        System.out.println(s);

        //문자열의 길이확인
        System.out.println(s.length()); // 길이 반환

        //대소문자 변환
        System.out.println(s.toUpperCase()); // 모두 대문자 변환
        System.out.println(s.toLowerCase()); // 모두 소문자 변환

        //포함 관계 s.contains() || s.indexOf() || s.lastIndexOf() || s.startsWith() || s.endsWith()
        System.out.println(s.contains("Java")); // 포함된다면 true
        System.out.println(s.contains("c#"));
        System.out.println(s.indexOf("Java")); // 처음 위치정보확인
        System.out.println(s.indexOf("c#")); // 찾을려는게 없다면 -1 반환
        System.out.println(s.lastIndexOf("and")); //마지막으로 일치하는 위치정보
        System.out.println(s.startsWith("I Like")); //이문자열로 시작하면 true 반환
        System.out.println(s.endsWith(".")); //이 문자열로 끝나면 true 아니면 false

    }
}
