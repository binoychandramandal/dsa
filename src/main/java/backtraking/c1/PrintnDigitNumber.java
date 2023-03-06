package backtraking.c1;

public class PrintnDigitNumber {
    public static void main(String[] args) {
        print(new int[]{1,2},1,3,"");
    }

    static  void print(int[] item,int cb,int tb,String asf){
        if(cb>tb){
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < item.length; i++) {
            print(item,cb+1,tb,asf+item[i]);
        }
    }
}
