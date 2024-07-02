package chap_01;

public class _07_TypeCasting {
    public static void main(String[] args) {
        String s2 = String.valueOf(98.8);
        s2 = Double.toString(98.8);
        System.out.println(s2);

        // 문자열을 숫자로
        int i = Integer.parseInt("93");
        System.out.println(i);
        double d = Double.parseDouble("98.98");
        System.out.println(d);

        int error = Integer.parseInt("자바");

    }
}
