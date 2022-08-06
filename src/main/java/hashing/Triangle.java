package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Triangle {

    public static void main(String[] args) {
        int[] A={ 1, 1, 2};
        int[] B={ 1, 2, 1};
        System.out.println(solve(A,B));
    }
   static public int solve(int[] A, int[] B) {
        Map<Integer,Integer> hmx=new HashMap<>();
        Map<Integer,Integer> hmy=new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            hmx.put(A[i],hmx.get(A[i])==null?1:hmx.get(A[i])+1);
            hmy.put(B[i],hmy.get(B[i])==null?1:hmy.get(B[i])+1);
        }
        
        int ans =0;
        for (int i = 0; i <A.length ; i++) {
           int xc= hmx.get(A[i]);
           int yc= hmy.get(B[i]);
           ans += (xc-1)*(yc-1);
        }
        return ans;
    }

    public boolean isRightAngledTriangle(Point p1,Point p2,Point p3){
        return (p1.x==p3.x && p1.y==p2.y) || (p1.x==p2.x && p1.y==p3.y) || (p2.x==p3.x && p2.y==p1.y) || (p2.x==p1.x && p2.y==p3.y) || (p3.x==p1.x && p3.y==p2.y) || (p3.x==p2.x && p3.y==p1.y);
    }





    class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}

