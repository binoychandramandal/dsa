package lld.bird.v3;

public class Crow extends FlyingBird {
    @Override
    public void fly() {
        System.out.println("Crow fly");
    }

    @Override
    public void makeSound() {
        System.out.println("Crow making sound");
    }

    @Override
    public void eat() {
        System.out.println("Crow eating");
    }
}
