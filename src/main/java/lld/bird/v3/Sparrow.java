package lld.bird.v3;

public class Sparrow extends FlyingBird {
    @Override
    public void fly() {
        System.out.println("Sparrow fly");
    }

    @Override
    public void makeSound() {
        System.out.println("Sparrow making sound");
    }

    @Override
    public void eat() {
        System.out.println("Sparrow eating");
    }

}
