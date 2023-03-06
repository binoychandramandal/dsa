package lld.bird.v3;

public class Client {

    public static void main(String[] args) {
        FlyingBird b1 =new Crow();
        b1.setName("Crow");

        FlyingBird b2 =new Sparrow();
        b2.setName("sparrow");

        System.out.println(b1);
        System.out.println(b2);
        b1.fly();
        b2.fly();

    }
}
