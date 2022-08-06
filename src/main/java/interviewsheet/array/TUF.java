package interviewsheet.array;

import java.util.ArrayList;
import java.util.Collections;

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class TUF {
    static ArrayList< Pair > merge(ArrayList < Pair > arr) {

        int n = arr.size();
        Collections.sort(arr, (a, b) -> a.x - b.x);
        ArrayList < Pair > ans = new ArrayList < > ();

        for (int i = 0; i < n; i++) {
            int start = arr.get(i).x, end = arr.get(i).y;
            //since the intervals already lies 
            //in the data structure present we continue
            if (!ans.isEmpty()) {
                if (start <= ans.get(ans.size() - 1).y) {
                    continue;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (arr.get(j).x <= end) {
                    end = arr.get(j).y;
                }
            }

            ans.add(new Pair(start, end));
        }

        return ans;
    }

    public static void main(String args[]) {
        ArrayList < Pair > arr = new ArrayList < > ();
        arr.add(new Pair(1, 3));
        arr.add(new Pair(2, 4));
        arr.add(new Pair(2, 6));
        arr.add(new Pair(8, 9));
        arr.add(new Pair(8, 10));
        arr.add(new Pair(9, 11));
        arr.add(new Pair(15, 18));
        arr.add(new Pair(16, 17));
        arr.add(new Pair(16, 17));
        ArrayList < Pair > ans = merge(arr);
        System.out.println("Merged Overlapping Intervals are ");
        for (Pair it: ans) {
            System.out.println(it.x + " " + it.y);
        }
    }
}