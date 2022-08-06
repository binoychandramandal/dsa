package linkedlist.dll;

import java.util.HashMap;

public class LRUCacheTest1 {
    public static void main(String[] args) {
        LRUCache cache =new LRUCache(4);
        cache.put(1,10);
        cache.put(1,20);
        cache.put(2,50);
        cache.put(1,60);
        cache.put(3,70);
        cache.put(4,80);
        cache.put(4,90);
        cache.display();



        System.out.println(cache.getKeySet());
        cache.put(5,100);
        cache.display();
        System.out.println(cache.getKeySet());
        System.out.println("Size-> "+cache.size());
        System.out.println(cache.get(3));

        //System.out.println("exists called-> "+cache.exists(1));
        cache.display();
    }
}
