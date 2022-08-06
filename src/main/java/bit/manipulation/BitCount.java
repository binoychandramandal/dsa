package bit.manipulation;

public class BitCount {
    public static void main(String[] args) {
        int val=4;
        System.out.println(val&-val);
        System.out.println(new BitCount().solve(4));
        System.out.println(new BitCount().solve1(new int[]{186, 256, 102, 377, 186, 377}));
        System.out.println(addBinary("111","111"));
    }

    public static String addBinary(String A, String B) {
        int i=A.length()-1;
        int j=B.length()-1;

        int carray=0;
        String result="";
        while(i>=0 || j>=0){
            int sum=0;
            if(i>=0){
                sum +=getDigit(A.charAt(i--));
            }
            if(j>=0){
                sum +=getDigit(B.charAt(j--));
            }
            sum+=carray;
            carray = sum/2;
            result = (sum%2)+result;
        }
        if(carray==1){
            result="1"+result;
        }
        return result;

    }

    public static int getDigit(char c){
        switch(c){
            case '1': return 1;
            default: return 0;
        }
    }

    public int[] solve1(int[] A) {

        int xor = 0;
        for(int i=0;i<A.length;i++){
            xor^=A[i];
        }

        int count=-1;
        while(xor>0){
            if((xor&1)==1){
                count++;
                break;
            }
            xor>>=1;
        }

        int set=0;
        int unset=0;
        for(int i=0;i<A.length;i++){
            if(((A[i]>>count)&1)==1){
                set^=A[i];
            }else{
                unset^=A[i];
            }
        }
        if(set<unset)
            return new int[]{set,unset};
        else

            return new int[]{unset,set};
    }
    public int solve(int A) {
        int m = 1000000007;
        int count=0;
        for(int i=1;i<=A;i++){
            count+=(getSetBit(i)%m);
        }
        return count;

    }
    public int getSetBit(int n){
        int count=0;
        while(n>0){
            if((n&1)==1){
                count++;
            }
            n>>=1;
        }
        return count;
    }
}
