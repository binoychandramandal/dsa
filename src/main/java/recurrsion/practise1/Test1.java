package recurrsion.practise1;

public class Test1 {

    public static void main(String[] args) {
        SecurityManager s = System.getSecurityManager();
        System.out.println(Thread.currentThread().getThreadGroup());
        System.out.println(Thread.currentThread().getName());
        System.out.println( Thread.currentThread().getThreadGroup().activeCount());
        System.out.println( Thread.currentThread().getThreadGroup().activeGroupCount());
        System.out.println("Parent -> "+ Thread.currentThread().getThreadGroup().getParent().activeGroupCount());
        System.out.println("Parent -> "+ Thread.currentThread().getThreadGroup().getParent());


    }
}
