package p1;

public class Test {
    public static void main(String[] args) {
        Test t =new Test();
        //St s =  t.new St("Krishna","krishna@gmail.com",10);
        St s=null;
        doSomething(s,t);
        System.out.println(s);

        int x=5;
        doAgain(x);
        System.out.println(x);
    }


    static void doAgain(int x){
        System.out.println(x);
        x =10;
        System.out.println(x);
    }



    static void doSomething(St st,  Test t ){
        System.out.println(st);
        st =t.new St("Radha","radha@gmail.com",20);
        System.out.println(st);
    }

    class St{
        String name;
        String email;
        int age;

        public St(String name, String email, int age) {
            this.name = name;
            this.email = email;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "St{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}


