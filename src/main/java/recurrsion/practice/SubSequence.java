package recurrsion.practice;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {
        System.out.println(getSubSequence("abc"));
        getSubSequence("abc","");
    }

    static List<String>  getSubSequence(String s){
        if(s==null || s.isEmpty()){
            List<String> l =new ArrayList<>();
            l.add("");
            return l;
        }
        char c =s.charAt(0);
        String rs =s.substring(1);
       List<String> res= getSubSequence(rs);
       List<String> result =new ArrayList<>();
        for(String ss:res){
            result.add(ss);
        }
        for(String ss:res){
            result.add(c+ss);
        }
        return result;
    }

    static void getSubSequence(String s,String ans){
        if(s==null || s.isEmpty()){
            System.out.print(ans+" ");
            return;
        }
        char c =s.charAt(0);
        String rs =s.substring(1);
        getSubSequence(rs,ans);
        getSubSequence(rs,ans+c);
    }
}
