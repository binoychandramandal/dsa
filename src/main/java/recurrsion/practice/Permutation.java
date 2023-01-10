package recurrsion.practice;

public class Permutation {
    public static void main(String[] args) {
       getPermutation("abc","");
    }

    static void  getPermutation(String s,String psf){
        if(s.isEmpty()){
            System.out.print(psf+"\t");
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c  =s.charAt(i);
            String left =s.substring(0,i);
            String right =s.substring(i+1);
            getPermutation(left+right,psf+c);
        }
    }
}
