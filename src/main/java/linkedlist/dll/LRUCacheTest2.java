package linkedlist.dll;

public class LRUCacheTest2 {
    public static void main(String[] args) {
        LRUCache cache =new LRUCache(1);

        // 6 1 S 2 1 S 2 2 G 2 S 1 1 S 4 1 G 2

        cache.put(2,1);
        cache.put(2,2);
        System.out.println(cache.get(2));
        cache.put(1,1);
        cache.put(4,1);
        System.out.println(cache.get(2));


    }
}
