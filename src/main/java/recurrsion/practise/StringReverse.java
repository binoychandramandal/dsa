package recurrsion.practise;

public class StringReverse {
    public static void main(String[] args) {
      String str=  reverse("abc",0);
        System.out.println(str);
    }

    static String reverse(String str,int i){
        if(i==str.length()){
            return "";
        }
        return reverse(str,i+1)+str.charAt(i);
    }
}
