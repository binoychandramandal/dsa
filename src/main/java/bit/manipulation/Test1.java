package bit.manipulation;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {

        /**
         * query.push_back({ "INSERT", "ABCD012WFY" });
         * 	query.push_back({ "INSERT", "0013ABC" });
         * 	query.push_back({ "INSERT", "VIP12345" });
         * 	query.push_back({ "INSERT", "ABCD092" });
         * 	query.push_back({ "SHIP", "-" });
         * 	query.push_back({ "SHIP", "-" });
         * 	query.push_back({ "INSERT", "09123" });
         * 	query.push_back({ "SHIP", "-" });
         * 	query.push_back({ "SHIP", "-" });
         */

//        List<List<String>> input = new ArrayList<>();
//        input.add(Arrays.asList("INSERT","ABCD012WFY"));
//        input.add(Arrays.asList("INSERT","0013ABC"));
//        input.add(Arrays.asList("SHIP","-"));
//        input.add(Arrays.asList("INSERT","09123"));
//        input.add(Arrays.asList("SHIP","-"));
//
//        System.out.println(performWarehouseQuires(input));

       // System.out.println(getDeviation("bbacccc"));
        System.out.println(generateSubString("bbacccc"));

    }



    static int generateSubString(String s){
        int max= Integer.MIN_VALUE;
        for (int i = 0; i <s.length()-4; i++) {
            for (int j = i+3; j < s.length(); j++) {
                int count = getDeviation(s.substring(i,j+1));
                max=Math.max(max,count);
            }
        }
        return max;
    }


    static int  getDeviation(String s){
        Map<Character,Integer> cache =new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            cache.put(s.charAt(i),cache.getOrDefault(s.charAt(i),0)+1);
        }
       int min = Integer.MAX_VALUE;
        int max = 0;
        for (Map.Entry<Character,Integer> e:cache.entrySet()) {
                 max=Math.max(max,e.getValue());
                 min = Math.min(min,e.getValue());
        }
        return max-min;
    }

    static  List<List<String>>  performWarehouseQuires(List<List<String>> lists){
        Queue<String> store = new LinkedList<>();
        List<List<String>> result = new ArrayList<>();
        lists.forEach(x->{
              if("INSERT".equals(x.get(0))){
                  store.offer(x.get(1));
              }else if("SHIP".equals(x.get(0))){
                  if(store.size()>=3){
                      result.add(Arrays.asList(store.poll(),store.poll(),store.poll()));
                  }else{
                      result.add(Arrays.asList("N/A"));
                  }
             }
         });
        return result;
    }

}
