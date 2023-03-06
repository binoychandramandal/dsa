package lld.bird.v2;

public class Crow extends Bird{
    @Override
    public void fly() {
        System.out.println("Crow fly");
    }

    @Override
    public void makeSound() {
        System.out.println("Crow making sound");
    }

    @Override
    public void dance() {
        System.out.println("Crow dancing");
    }
}
