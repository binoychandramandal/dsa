package com.array;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {
    private int k;
    private int count = 0;
    private List<Integer> pf = new ArrayList<>();

    public static void main(String[] args) {
        SlidingWindow slidingWindow=new SlidingWindow(3);
        slidingWindow.add(1);
        slidingWindow.add(2);
        System.out.println(slidingWindow.getSum());
        slidingWindow.add(3);
        System.out.println(slidingWindow.getSum());
        slidingWindow.add(4);
        System.out.println(slidingWindow.getSum());
        slidingWindow.add(5);
        System.out.println(slidingWindow.getSum());
    }

    public SlidingWindow(int k) {
        this.k = k;
    }

    public void add(int element) {
        if (count == 0) {
            pf.add(element);
        } else {
            pf.add(pf.get(count - 1) + element);
        }
        count++;
    }

    public int getSum() {
        if (count <= k) {
            return pf.get(count - 1);
        } else {
            return pf.get(count - 1) - pf.get(count - k-1);
        }
    }
}
