package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hash1 {

    public static void main(String[] args) {
       //System.out.println(Arrays.toString(lszero(new int[]{1, 2, -2, 4, -4})));
        //System.out.println(Arrays.toString(lszero(new int[]{1, 2, -3, 3})));


        System.out.println(Arrays.toString(dNums(new int[]{1, 2, 1, 3, 4, 3 },3)));


    }

    static public int[] lszero(int[] A) {
        long[] pf = new long[A.length];
        pf[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pf[i] = A[i] + pf[i - 1];
        }
        Map<Long, Integer> m = new HashMap<>();
        m.put(0l, -1);
        long ans = 0;
        int s = -1;
        int e = -1;
        for (int i = 0; i < pf.length; i++) {
            if (m.containsKey(pf[i])) {
                long cs = i - m.get(pf[i]);
                if (ans < cs) {
                    s = m.get(pf[i]);
                    if(pf[i]==0)
                        s++;
                    e = i;
                    ans=cs;
                }
            } else {
                m.put(pf[i], i);
            }
        }
        if (s == -1)
            return new int[]{};
        int[] r = new int[e - s + 1];
        int j = 0;
        for (int i =  s; i <= e; i++) {
            r[j++] = A[i];
        }
        return r;
    }

    public static int[] dNums(int[] A, int B) {
        HashMap<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<B;i++){
            m.put(A[i],getOrDefault(m,A[i])+1);
        }
        int[] r=new int[A.length-B+1];
         r[0]=m.size();
        for(int i=1;i<=A.length-B;i++){
            int p=m.get(A[i-1]);
            if(p-1==0){
                m.remove(A[i-1]);
            }else{
                m.put(A[i-1],p-1);
            }
            m.put(A[i+B-1],getOrDefault(m,A[i+B-1])+1);
            r[i]=m.size();
        }
        return r;
    }

    private static Integer getOrDefault(HashMap<Integer,Integer> m,Integer val){
        Integer c=m.get(val);
        return c==null?0:c;

    }
}
