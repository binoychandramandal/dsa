package recurrsion.practise;

import java.util.HashMap;
import java.util.HashSet;

public class WordBreakProblem {
    public static void main(String[] args) {
        HashSet<String > dict =new HashSet<>();
        dict.add("micro");
        dict.add("soft");
        dict.add("hi");
        dict.add("hiring");
        dict.add("microsoft");
        String sentence ="microsofthiring";
        wordBreakInSentence(sentence,"",dict);
        System.out.println("--------------------------------");
        dict =new HashSet<>();
        dict.add("i");
        dict.add("like");
        dict.add("sam");
        dict.add("sung");
        dict.add("samsung");
        dict.add("mobile");
        dict.add("ice");
        dict.add("and");
        dict.add("cream");
        dict.add("icecream");
        dict.add("man");
        dict.add("go");
        dict.add("mango");
         sentence ="ilikesamsungmobile";
        wordBreakInSentence(sentence,"",dict);
        System.out.println("--------------------");
        sentence ="ilikeicecreamandmango";
        wordBreakInSentence(sentence,"",dict);

    }

    static void wordBreakInSentence(String str, String ans, HashSet<String> dict){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left =str.substring(0,i+1);
            if(dict.contains(left)){
                String right=str.substring(i+1);
                wordBreakInSentence(right,ans+left+" ",dict);
            }
        }

    }
}
