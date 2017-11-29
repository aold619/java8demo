package main.interview;

public class SwapTwoNumber {
    public static void main(String[] args) {
        int a = 5, b = 8;
        swap(a, b);
        System.out.printf("a: %s\nb: %s", a, b);
    }

    private static void swap(int a, int b) {
        int c = 0;
        c = a;
        a = b;
        b = c;
    }
}
