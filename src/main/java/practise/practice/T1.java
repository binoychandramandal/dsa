package practise.practice;

import java.util.HashSet;
import java.util.Set;

public class T1 {

    public static void main(String[] args) {
        selectKDistinctChar("ababcdecd",3);
    }


    static void selectKDistinctChar(String str,int ts){
        Set<Character> s=new HashSet<>();
        String uniqueStr ="";
        for (int i = 0; i < str.length(); i++) {
            if(!s.contains(str.charAt(i))){
                s.add(str.charAt(i));
                uniqueStr+=str.charAt(i);
            }
        }
        selectKDistinctChar(0,uniqueStr,0,ts,"");
    }

    static  void selectKDistinctChar(int i,String str,int cs,int ts,String ans){
        if(i==str.length()){
            if(cs==ts)
                System.out.println(ans);
            return;
        }
        char ch =str.charAt(i);
        selectKDistinctChar(i+1,str,cs+1,ts,ans+ch);
        selectKDistinctChar(i+1,str,cs,ts,ans);

    }
}
