package lld.bird.v2;

public class Sparrow extends Bird{
    @Override
    public void fly() {
        System.out.println("Sparrow fly");
    }

    @Override
    public void makeSound() {
        System.out.println("Sparrow making sound");
    }

    @Override
    public void dance() {
        System.out.println("Sparrow dancing");
    }
}
