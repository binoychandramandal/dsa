package practise.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {
        System.out.println(generateAllSubSequence("abc"));
        print("abc","");
    }

    static List<String> generateAllSubSequence(String str){
        if(str.isEmpty()){
            List<String > l =new ArrayList<>();
            l.add("");
            return l;
        }
        char c=str.charAt(0);
        List<String > r =generateAllSubSequence(str.substring(1));
        List<String> result =new ArrayList<>();
        for (int i = 0; i < r.size(); i++) {
            result.add(r.get(i));
        }
        for (int i = 0; i < r.size(); i++) {
            result.add(c+r.get(i));
        }
        return result;
    }

    static void print(String str,String rsf){
        if(str.isEmpty()){
            System.out.println(rsf);
            return;
        }
        print(str.substring(1),rsf);
        print(str.substring(1),rsf+str.charAt(0));
    }
}
