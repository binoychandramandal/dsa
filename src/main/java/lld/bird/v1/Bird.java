package lld.bird.v1;

/**
 * Store different type of bird
 * same class is responsible to store all type of bird
 */
public class Bird {
    private String name;
    private String type;
    private int noOfWing;
    private double weight;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void fly() {

    }

    /**
     * Problem with this code is two many different if else.
     *
     * problem:
     * 1. Understandable
     * 2. Testing become difficult
     * 3. Difficult while multiple developer works parallel (Merge conflict)
     * 4. Re usability if only method how pigeon fly then no option
     * 5. Less code reuse
     * 6. its violates SRP in SOLID
     */
    public void makeSound() {
        if (type == "crow") {
            System.out.println("Co co");
        } else if (type == "sparrow") {
            System.out.println("sp");
        } else {
            System.out.println("dd");
        }
    }

    public void dance() {

    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", noOfWing=" + noOfWing +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
