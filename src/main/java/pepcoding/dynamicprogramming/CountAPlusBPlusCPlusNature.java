package pepcoding.dynamicprogramming;

public class CountAPlusBPlusCPlusNature {
    public static void main(String[] args) {
        System.out.println(countSub("abcabc"));
    }

    static int countSub(String str){
        int a=0;
        int ab=0;
        int abc=0;
        for(int i = 0;i<str.length();i++){
            char ch =str.charAt(i);
            if(ch=='a'){
                a =2*a+1;
            }else if(ch=='b'){
                ab =2*ab+a;
            }else if(ch=='c'){
                abc =2*abc+ab;
            }
        }
        return abc;
    }
}
