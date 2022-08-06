package linkedlist.dll;

public class MyLRUCacheTest {
    public static void main(String[] args) {
        MyLRUCache<Integer, Integer> cache = new MyLRUCache<>(1);

        cache.set(5,13);
        cache.set(9,6);
        cache.set(4,1);
        System.out.println(cache.get(4));
        cache.set(6,1);
        cache.set(8,11);
        System.out.println(cache.get(13));
        System.out.println(cache.get(1));
        cache.set(8,11);
        cache.set(12,12);
        System.out.println(cache.get(10));
        cache.set(15,13);
        cache.set(2,13);
        cache.set(7,5);
        cache.set(10,3);
        System.out.println(cache.get(6));
        System.out.println(cache.get(10));
        cache.set(15,14);
        cache.set(5,12);
        System.out.println(cache.get(5));
        System.out.println(cache.get(7));
        System.out.println(cache.get(15));
        System.out.println(cache.get(5));
        System.out.println(cache.get(6));
        System.out.println(cache.get(10));
        cache.set(7,13);
        System.out.println(cache.get(14));
        cache.set(8,9);
        System.out.println(cache.get(4));
        cache.set(86,11);
        System.out.println(cache.get(9));
        cache.set(6,12);
        System.out.println(cache.get(3));
    }

}
