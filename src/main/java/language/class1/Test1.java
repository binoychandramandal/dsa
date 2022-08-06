package language.class1;

public class Test1 {
    public static void main(String[] args) {
        int i=0;
        increment(i);
        System.out.println(i);
    }

    static void increment(int i){
        i++;
        System.out.println("Inside increment "+i);
    }

}
