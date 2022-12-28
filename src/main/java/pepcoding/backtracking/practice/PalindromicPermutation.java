package pepcoding.backtracking.practice;

import java.util.HashMap;
import java.util.Map;

public class PalindromicPermutation {
    public static void main(String[] args) {
        printPP("aabbccdd");

    }

    static void printPP(String s){
        Map<Character,Integer> fmap =new HashMap<>();
        for(Character c:s.toCharArray()){
            fmap.put(c,fmap.getOrDefault(c,0)+1);
        }
        Character odd =null;
        int odds =0;
        int len =0;
        for(char ch: fmap.keySet()){
            int freq =fmap.get(ch);
            if(freq%2==1){
                odd=ch;
                odds++;
            }
            fmap.put(ch,freq/2);
            len+=freq/2;
        }
       // if(odds==1)
        generatePalindromicPermutation(1,len,fmap,odd,"");
    }

    static void generatePalindromicPermutation(int cs, int ts, Map<Character,Integer> fmap, Character oddc, String asf){
        if(cs>ts){
            System.out.println(asf+fmap);
            String rev ="";
            for (int i = asf.length()-1; i >=0 ; i--) {
                rev+=asf.charAt(i);
            }
            String res =asf;
            if(oddc!=null){
                res+=oddc;
            }
            res += rev;
            System.out.println(res);
            return;
        }
        for(char ch: fmap.keySet()){
            int freq =fmap.get(ch);
            if(freq>0){
                fmap.put(ch,freq-1);
                generatePalindromicPermutation(cs+1,ts,fmap,oddc,asf+ch);
                fmap.put(ch,freq);
            }
        }
    }
}
