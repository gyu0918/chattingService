package chap_02;

public class Quize_02 {
    public static void main(String[] args) {
        int pivot = 120;
        String child = (115 < pivot) ? ("키가 115cm 이므로 탑승 불가능합니다") : ("탑승 가능합니다");
        System.out.println(child);
        String child2 = (121 < pivot) ? ("탑승 불가능합니다") : ("키가 121cm 이므로 탑승 가능합니다");
        System.out.println(child2);

    }
}
