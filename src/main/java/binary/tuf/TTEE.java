package binary.tuf;

public class TTEE {
    public static void main(String[] args) {
        try {
            f1();
        } catch (Exception e) {
        }
    }

    static void f1() {
        f2();
    }

    static void f2() {
        f3();
    }

    static void f3() {
        f4();
    }

    static void f4() {
        System.out.println(1 / 0);
    }
}
