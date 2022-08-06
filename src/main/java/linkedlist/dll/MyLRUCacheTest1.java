package linkedlist.dll;

public class MyLRUCacheTest1 {
    public static void main(String[] args) {
        MyLRUCache<Integer, Integer> cache = new MyLRUCache<>(1);
        cache.set(5,13);
        cache.set(9,6);
        cache.set(4,1);
        System.out.println(cache.get(2));
        System.out.println(cache.get(5));
        System.out.println(cache.get(5));
        System.out.println(cache.get(9));
        System.out.println(cache.get(4));
        System.out.println(cache.get(4));

       cache.display();

    }

}
