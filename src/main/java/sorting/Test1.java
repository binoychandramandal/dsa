package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
//        A.add(3);
//        A.add(36);
//        A.add(34);
//        A.add(5);
//        A.add(9);
//        A.add(0);
//        A.add(333);
//        A.add(336);
        A.add(8);
        A.add(87);
        largestNumber(A);
    }

    public static String largestNumber(final List<Integer> A) {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String i1 = String.valueOf(o1);
                String i2 = String.valueOf(o2);
                int len1 = i1.length();
                int len2 = i2.length();
                if (len2 == 1) {

                    for(int i=0;i<len1;i++){
                       char c1= i2.charAt(0);
                        if(i1.charAt(i)==c1){
                            continue;
                        }else if(i1.charAt(i)>c1){
                            return -1;
                        }
                    }
                    return 1;
                }
                return (o2 + "").compareTo((o1 + ""));
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer item : A) {
            sb.append(item);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

}
