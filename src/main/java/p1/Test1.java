package p1;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Map<String, Double> m = new HashMap<>();
        m.put("A", 200.0);
        m.put("B", -200.0);
        m.put("C", 100.0);
        m.put("D", -200.0);
        m.put("E", 100.0);
        //m.put("F", 100.0);
        System.out.println(print(m));
    }

    static class TP implements Comparable<TP> {

        String user;

        Double balance;

        public TP(String user, Double balance) {
            this.user = user;
            this.balance = balance;
        }

        @Override
        public int compareTo(TP o) {
            return balance.compareTo(o.balance);
        }
    }

    static class Transaction {
        Double amount;
        String payUser;
        String receiveUser;

        public Transaction(Double amount, String payUser, String receiveUser) {
            this.amount = amount;
            this.payUser = payUser;
            this.receiveUser = receiveUser;
        }

        @Override
        public String toString() {
            return
                    "amount " + amount +
                            " received by '" + payUser + '\'' +
                            " from '" + receiveUser + '\'';
        }
    }

    static List<Transaction> print(Map<String, Double> input) {
        PriorityQueue<TP> pm = new PriorityQueue<>();
        PriorityQueue<TP> pl = new PriorityQueue<>();
        List<Transaction> transactionList = new ArrayList<>();
        for (Map.Entry<String, Double> e : input.entrySet()) {
            if (e.getValue() < 0) {
                pl.offer(new TP(e.getKey(), Math.abs(e.getValue())));
            } else {
                pm.offer(new TP(e.getKey(), e.getValue()));
            }
        }

        while (pm.size() > 0 && pl.size() > 0) {
            TP pMr = pm.poll();
            TP pLL = pl.poll();
            Double min = Math.min(pMr.balance, pLL.balance);
            transactionList.add(new Transaction(min, pMr.user, pLL.user));
            //System.out.println(pMr.user+ " receive "+min+" from "+pLL.user);
            if (pMr.balance - min > 0) {
                pMr.balance = pMr.balance - min;
                pm.offer(pMr);
            }
            if (pLL.balance - min > 0) {
                pLL.balance = pLL.balance - min;
                pl.offer(pLL);
            }
        }

        if (pm.size() > 0 || pl.size() > 0) {
            return new ArrayList<>();
        }

        return transactionList;
    }


}


