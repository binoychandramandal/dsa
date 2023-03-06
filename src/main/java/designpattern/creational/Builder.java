package designpattern.creational;

public class Builder {
    public static void main(String[] args) {

        Student s = new Student.Builder1().withNme("Krishna").address("gokul").build();

        System.out.println(s.getAddress());

    }

    static class Student {

        private String name;
        private String email;
        private String address;
        private int age;

        private Student() {

        }

        private Student(String name, String email, String address, int age) {
            this.name = name;
            this.email = email;
            this.address = address;
            this.age = age;
        }

        static class Builder1 {

            private String name;
            private String email;
            private String address;
            private int age;

            public Builder1 withNme(String name) {
                this.name = name;
                return this;
            }

            public Builder1 email(String email) {
                this.email = email;
                return this;
            }

            public Builder1 address(String address) {
                this.address = address;
                return this;
            }

            public Builder1 age(int age) {
                this.age = age;
                return this;
            }

            public Student build(){
                return new Student(name,email,address,age);
            }
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getAddress() {
            return address;
        }

        public int getAge() {
            return age;
        }
    }
}
