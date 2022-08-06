package hashing;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RectangleCount {
    public static void main(String[] args) {
        RectangleCount rectangleCount=new RectangleCount();
        int[] A=new int[]{1, 1, 2, 2};
        int[] B=new int[]{1, 2, 1, 2 };
        System.out.println(rectangleCount.solve(A,B));
    }

    public int solve(int[] A, int[] B) {
        Set<Point> s=new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            s.add(new Point(A[i],B[i]));
        }
        int count=0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                int x1 =A[i];
                int y1=B[i];
                int x2 =A[j];
                int y2=B[j];
                if(x1==x2 || y1==y2)
                    continue;
                Point p1=new Point(x2,y1);
                Point p2=new Point(x1,y2);
                if(s.contains(p1) && s.contains(p2)){
                    count++;
                }
            }
        }
        return count/2;
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
