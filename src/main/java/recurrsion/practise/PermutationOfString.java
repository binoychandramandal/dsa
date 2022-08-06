package recurrsion.practise;

import java.util.HashMap;

public class PermutationOfString {
    public static void main(String[] args) {
        generateWords("aabb");
    }

    static void generateWords(String str){
        HashMap<Character,Integer> fmap =new HashMap<>();
        for (char ch:str.toCharArray()) {
            if(fmap.containsKey(ch)){
                fmap.put(ch, fmap.get(ch)+1);
            }else{
                fmap.put(ch,1);
            }
        }

        solution(1,str.length(),fmap,"");

    }

    static void solution(int cs,int ts,HashMap<Character,Integer> fmap,String asf){
        if(cs>ts){
            System.out.println(asf);
            return;
        }
        for (char ch: fmap.keySet()){
            if(fmap.get(ch)>0){
                fmap.put(ch,fmap.get(ch)-1);
                solution(cs+1,ts,fmap,asf+ch);
                fmap.put(ch,fmap.get(ch)+1);
            }
        }
    }





}
