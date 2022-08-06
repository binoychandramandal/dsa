package designpattern.creational;

import java.io.*;

public class SingletonPattern {
    public static void main(String[] args) throws Exception {


//        for (int i = 0; i < 100; i++) {
//            new Thread(()->{ Student.getInstance().sayHello();}).start();
//        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Student.getInstanceLazyInnerClass().sayHello();
            }).start();
        }

    }


    static class Student implements Externalizable, Serializable {
       // private static final Student instance = new Student();
        private static Student instanceLazy;

        private static class ObjectHolder{
            private static final Student INSTANCE =new Student();
        }

//        public static Student getInstance() {
//            return instance;
//        }

        public static Student getInstanceLazyInnerClass() {
            return ObjectHolder.INSTANCE;
        }

        public static Student getInstanceLazy() {
            if (instanceLazy == null) {
                synchronized (Student.class) {
                    if (instanceLazy == null) {
                        instanceLazy = new Student();
                    }
                }

            }
            return instanceLazy;
        }


        private String name = "Krishna";

        private Student() {
            System.out.println("Constructor is called");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void sayHello() {
            System.out.println("Hello Folks from" + this);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("Clone not allowed");
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            throw new IOException();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
