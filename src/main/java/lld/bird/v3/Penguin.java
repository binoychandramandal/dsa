package lld.bird.v3;

import lld.bird.v2.Bird;

//only penguin can not fly
public class Penguin extends NonFlyingBird {
    @Override
    public void makeSound() {
        System.out.println("Penguin making sound");
    }

    @Override
    public void eat() {
        System.out.println("Penguin eating");
    }
}
