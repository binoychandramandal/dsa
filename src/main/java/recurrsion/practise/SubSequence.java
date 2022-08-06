package recurrsion.practise;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {

        System.out.println(getAllSubSequence("abcdefghijklmnopqrstwxyzabcdefghijklmnopqrstwxyzabcdefghijklmnopqrstwxyz"));
        //System.out.println(getAllSubSequence1("abc"));
       // printSubSequence("abc","");
        printSs("abc","");
    }


   static  void printSs(String s,String ssf){
        if(s.isEmpty()){
            System.out.println(ssf);
            return;
        }
        char ch = s.charAt(0);
        String ros = s.substring(1);


        printSs(ros,ssf+ch);
       printSs(ros,ssf);
    }


    static List<String> getAllSubSequence(String s) {
        if (s.length() == 1) {
            List<String> l = new ArrayList<>();
            l.add("");
            l.add(s);
            return l;
        }

        char s1 = s.charAt(0);
        System.out.println("Running for -> "+s1);
        List<String> rres = getAllSubSequence(s.substring(1));
        List<String> mres = new ArrayList<>();
        for (String e : rres) {
            mres.add(""+e);
            mres.add(s1 + e);
        }
        return mres;

    }

    static List<String> getAllSubSequence1(String s) {
        if (s.length() == 1) {
            List<String> l = new ArrayList<>();
            l.add("");
            l.add(s);
            return l;
        }
        char s1 = s.charAt(0);
        List<String> rres = getAllSubSequence1(s.substring(1));
        List<String> mres = new ArrayList<>();
        for (String e : rres) {
            mres.add(""+e);
        }
        for (String e : rres) {
            mres.add(s1 + e);
        }
        return mres;

    }

    /**
     * Just print sub sequence
     * @param s
     * @param out
     */
    static void printSubSequence(String s,String out){
        if(s.isEmpty()){
            System.out.println(out);
            return;
        }
        char c=s.charAt(0);
        String ros = s.substring(1);
        printSubSequence(ros,out);
        printSubSequence(ros,out+c);
    }

}
