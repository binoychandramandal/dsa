package recurrsion.practise1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        System.out.println(findSetBit(10));

    }

    public static String findSetBit(int n) {
        LinkedList<Integer> bitPosition = new LinkedList<>();
        int i = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                bitPosition.offer(i);
            }
            n = n >> 1;
            i++;
        }

        if (!bitPosition.isEmpty()) {
            StringBuilder stats = new StringBuilder();
            stats.append(bitPosition.size());
            stats.append("#");
            stats.append(bitPosition.get(0));
            stats.append("#");
            stats.append(bitPosition.get(bitPosition.size() - 1));
            return stats.toString();
        }

        return "";
    }
}
