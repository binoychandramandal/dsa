package lld.bird.v1;

public class Client {
    public static void main(String[] args) {
        Bird b1=new Bird();
        b1.setName("Sparrow");
        b1.setType("xyz");

        Bird b2=new Bird();
        b2.setName("CROW");
        b2.setType("ABC");

        b1.fly();
        b2.fly();
    }
}
