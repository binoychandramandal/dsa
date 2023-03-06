package recurrsion.practice1;

public class FriendParing {

    public static void main(String[] args) {
pr(3,1,new boolean[4],"");
    }

    static void pr(int n, int i,boolean[]used,String asf){
        if(i>n){
            System.out.println(asf);
            return;
        }
        if(used[i])
            pr(n, i+1, used, asf);
        else {
            used[i] = true;
            pr(n, i + 1, used, asf + "(" + i + ") ");
            for (int j = i + 1; j <= n; j++) {
                if(used[j]==false) {
                    used[j] = true;
                    pr(n, i + 1, used, asf + "(" + i + " " + j + ") ");
                    used[j] = false;
                }
            }
            used[i] = false;
        }
    }

}
