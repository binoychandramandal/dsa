package lld.bird.v2;
//only penguin can not fly
public class Penguin extends Bird{
    @Override
    public void fly() {
        // i can keep empty
        return;
        //or i can throw exception
       // throw new RuntimeException();
        //System.out.println("Penguin fly");
    }

    @Override
    public void makeSound() {
        System.out.println("Penguin making sound");
    }

    @Override
    public void dance() {
        System.out.println("Penguin dancing");
    }
}
