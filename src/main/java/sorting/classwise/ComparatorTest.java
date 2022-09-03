package sorting.classwise;

import java.util.Arrays;

public class ComparatorTest {
    public static void main(String[] args) {
      Integer[] a={1,2,3,4,5};
      Arrays.sort(a,(obj1,obj2)->{
          if(obj1-obj2>=1) return -1;
          else if(obj1-obj2<=1)return 1;
          return 0;
      });
        System.out.println(Arrays.toString(a));
    }
}
