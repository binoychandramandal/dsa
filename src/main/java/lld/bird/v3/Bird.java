package lld.bird.v3;

/**
 * Store different type of bird
 * same class is responsible to store all type of bird
 */
public abstract class Bird {
    private String name;
    private int noOfWing;
    private double weight;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfWing() {
        return noOfWing;
    }

    public void setNoOfWing(int noOfWing) {
        this.noOfWing = noOfWing;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    /**
     * Problem with this code is two many different if else.
     * <p>
     * problem:
     * 1. Understandable
     * 2. Testing become difficult
     * 3. Difficult while multiple developer works parallel (Merge conflict)
     * 4. Re usability if only method how pigeon fly then no option
     * 5. Less code reuse
     * 6. its violates SRP in SOLID
     */
    public abstract void makeSound();
    public abstract void eat();


    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", noOfWing=" + noOfWing +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
