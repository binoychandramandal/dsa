package recurrsion.practise;

public class MaxScoreProblem {
    public static void main(String[] args) {
       String[] words=new String[]{"dog","cat","dad","good"};
       int[] farr={1,1,1,3,0,0,1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
       int[] score={1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(solution(words,farr,score,0));
    }

    static int solution(String[] words,int[] farr,int[] score,int idx){
        if(idx== words.length){
            return 0;
        }
        //not included
        int sno =0+solution(words,farr,score,idx+1);

        //include
        int sword =0;
        boolean flag =true;
        String word=words[idx];
        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            if(farr[ch-'a']==0){
                flag=false;
            }
            farr[ch - 'a']--;
            sword+=score[ch-'a'];
        }
        int syes=0;
        if(flag){
            syes = sword+solution(words,farr,score,idx+1);
        }

        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            farr[ch-'a']++;
        }
        return Math.max(sno,syes);
    }
}
