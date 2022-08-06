package graph.tuf;

import java.util.Arrays;

public class DisjointSet {
    public static void main(String[] args) {
         DisjointSet ds =new DisjointSet(8);
         ds.union(0,2);
         ds.union(3,4);
         ds.union(2,4);
        System.out.println(ds.find(3));
        System.out.println(ds.find(2));
        System.out.println(ds.find(4));
        System.out.println(ds.find(0));
        System.out.println(Arrays.toString(ds.parent));
        DisjointSet ds1 =new DisjointSet(8);
        ds1.unionByRank(0,2);
        ds1.unionByRank(3,4);
        ds1.unionByRank(2,4);
        System.out.println(ds1.findWIthPathCompression(3));
        System.out.println(ds1.findWIthPathCompression(2));
        System.out.println(ds1.findWIthPathCompression(4));
        System.out.println(ds1.findWIthPathCompression(0));
        System.out.println(ds1.findWIthPathCompression(5));
        System.out.println(Arrays.toString(ds1.parent));
        System.out.println(Arrays.toString(ds1.rank));
    }

    private int[] parent ; //contains parent of node
    private int[] rank ;//contains height of every node

    public DisjointSet(int vertices){
        parent=new int[vertices];
        rank=new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i]=i;
        }
    }

    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return find(parent[x]);
    }

    public int findWIthPathCompression(int x){
        if(parent[x]!=x){
             parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    public void unionByRank(int u,int v){
        int uRoot =find(u);
        int vRoot =find(v);
        if(uRoot==vRoot)return;
        if(rank[uRoot]<rank[vRoot]){
            parent[uRoot]=vRoot;
        }
        else if(rank[uRoot]>rank[vRoot]){
            parent[vRoot]=uRoot;
        }else{
            parent[vRoot]=uRoot;
            rank[uRoot]+=1;
        }
    }

    public void union(int u,int v){
        int x =find(u);
        int y =find(v);
        if(x==y)return;
        parent[y]=x;
    }
}
