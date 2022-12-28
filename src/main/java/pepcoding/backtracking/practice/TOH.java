package pepcoding.backtracking.practice;

public class TOH {

    public static void main(String[] args) {
        toh(3,"A","B","C");
    }

    static void toh(int n,String src,String temp,String dest){
        if(n==0)
            return;
        toh(n-1,src,dest,temp);
        System.out.println(n+" move  from "+src+" -> "+dest);
        toh(n-1,temp,src,dest);
    }

}
