package recurrsion.practise;

public class LexicographicalOrder {
    public static void main(String[] args) {
        for (int i = 1; i <10 ; i++) {
            dfs(i,100);
        }
    }
    
    
    static void dfs(int i,int n){
        if(i>n){
            return;
        }
       System.out.println(i);
        for (int j = 0; j <= 9; j++) {
            dfs(10*i+j,n);
        }     
    }
}
