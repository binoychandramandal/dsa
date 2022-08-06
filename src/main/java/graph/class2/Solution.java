package graph.class2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        int[][] a={
        {0, 4, 9},
        {3, 4, 6},
        {1, 2, 1},
        {2, 5, 1},
        {2, 4, 5},
        {0, 3, 7},
        {0, 1, 1},
        {4, 5, 7},
        {0, 5, 1}
        };
            ArrayList<ArrayList<Integer>> r=new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
                   ArrayList<Integer> al=new ArrayList<>();
                   al.add(a[i][0]);
                   al.add(a[i][1]);
                   al.add(a[i][1]);
                   r.add(al);
        }
        System.out.println(new Solution().solve(6,r,4));
    }
     static class Node{
        int v;
        int w;
       public Node(int v,int w){
           this.v=v;
           this.w=w;
       }
    }
    
    static class Pair implements Comparable<Pair>{
        int w;
        int v;
        public Pair(int w,int v){
            this.w=w;
            this.v=v;
        }
        public int compareTo(Pair o) {
            return this.w - o.w;
        }
        
    }
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C){
        List<Node>[] g=new ArrayList[A];
        for(int i=0;i<A;i++){
            g[i]=new ArrayList<>();
        }
        for(int i=0;i<B.size();i++){
            int s=B.get(i).get(0);
            int n = B.get(i).get(1);
            int w=B.get(i).get(2);
            g[s].add(new Node(n,w));
            g[n].add(new Node(s,w));
        }
        ArrayList<Integer> dist=new ArrayList<>(A);
         for(int i=0;i<A;i++){
            dist.add(Integer.MAX_VALUE);
        }
        
        dist.set(C,0);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        minHeap.offer(new Pair(0, C));
        while(!minHeap.isEmpty()){
            Pair cur = minHeap.poll();
            for(Node it: g[cur.v]){
                if(dist.get(cur.v)+it.w<dist.get(it.v)){
                    dist.set(it.v,dist.get(cur.v)+it.w);
                    minHeap.offer(new Pair(dist.get(it.v),it.v));
                }
            }
        }

        for (int i = 0; i < dist.size(); i++) {
            if(dist.get(i)==Integer.MAX_VALUE){
                dist.set(i,-1);
            }
        }
        return dist;
    }
}

 
