package practise.recurssion;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
        int[][] a= {
                {1,2,3,4},
                {1,2,3,4},
                {1,2,3,4}
        };
        System.out.println(getAllPath(a,0,0,3,3));

    }

    static List<String> getAllPath(int[][] a,int sr,int sc,int dr,int dc){
        if(sr==dr && sc==dc){
            List<String > l =new ArrayList<>();
            l.add("");
            return l;
        }
        List<String> hPaths =new ArrayList<>();
        List<String> vPaths =new ArrayList<>();
        if(sc<dc){
            hPaths.addAll(getAllPath(a,sr,sc+1,dr,dc));
        }
        if(sr<dr){
            vPaths.addAll(getAllPath(a,sr+1,sc,dr,dc));
        }

        List<String> result =new ArrayList<>();
        for(String p:hPaths){
            result.add("H"+p);
        }
        for(String p:vPaths){
            result.add("V"+p);
        }
        return result;
    }
}
