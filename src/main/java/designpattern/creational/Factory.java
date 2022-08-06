package designpattern.creational;

public class Factory {


    public static void main(String[] args) {
        get(UserType.STUDENT).display();
    }



      public static Person get(UserType userType){
          if (UserType.EMPLOYEE.equals(userType)){
              return new Student();
          }else{
              return new Employee();
          }
      }

    static class Person {
        String name;
        int age;
        String email;
        String address;
        void display(){
            System.out.println("Person");
        }
    }

    enum UserType {
        STUDENT, EMPLOYEE;
    }


    static class Student extends Person {
        void display(){
            System.out.println("Student");
        }
    }

    static class Employee extends Person {
        void display(){
            System.out.println("Employee");
        }
    }

}

