package recurrsion.practise;

public class FriendPairing {
    static int counter=0;
    public static void main(String[] args) {
        int n=3;
        solution(1,n,new boolean[n+1],"");
    }

    static void solution(int i, int n, boolean[] used, String asf) {
        if(i>n){
            System.out.println(counter+"."+asf);
            counter++;
            return;
        }
        if (used[i] == true) {
            solution(i + 1, n, used, asf);
        } else {
            used[i] = true;
            solution(i + 1, n, used, asf + "(" + i + ") ");
            for (int j = i + 1; j <= n; j++) {
                used[j] = true;
                solution(i + 1, n, used, asf + "(" + i +j+ ") ");
                used[j] = false;
            }
            used[i] = false;
        }
    }
}
