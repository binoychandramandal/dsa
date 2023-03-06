package aa;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {
        //int count=countWord("jds dsaf lkdf kdsa fkldsf, adsbf ldka ads? asd bfdal ds bf[l. akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj.");
        //int count=countWord("b? Dl )B 4(V! A. MK, YtG ](f 1m )CNxuNUR {PG? ");
        int count=countWord("he is a good programmer, he won 865 competitions, but sometimes he dont. What do you think? All test-cases should pass. Done-done?");
        System.out.println(count);
    }

    static int countWord(String s){

        String[] w= s.split(" ");
        int count=0;
        System.out.println(Arrays.toString(w));
        List<String> l= Arrays.stream(w).map(x->x.trim()).map(x->removeSpecialChar(x)).filter(x->{
            try{
               Long.parseLong(x);
               return false;
            }catch (Exception e){
                return true;
            }
        }).filter(x->!x.isEmpty()).filter(x->isLetter(x)).collect(Collectors.toList());
        System.out.println(l);

//                map(x->x.replaceAll("[^a-zA-Z-]", "")).map(x->x.trim()).filter(x->!x.isEmpty()).collect(Collectors.toList());
        return l.size();
    }

    static boolean isLetter(String x){
        for(char c: x.toCharArray()){
            if(c=='-'){
                continue;
            }
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }

    static String removeSpecialChar(String s){
        Character questionMark = '?';
        Character dot = '.';
        Character comma = ',';
        Character ex = '!';
        Character hyphen = '-';
        String ans ="";
        for(char c: s.toCharArray()){
            if(c==questionMark || c==dot || c==comma || ex==c){
                continue;
            }

            ans+=c;
        }
        return ans;
    }


}
