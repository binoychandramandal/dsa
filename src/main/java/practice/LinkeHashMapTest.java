package practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkeHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> m=new LinkedHashMap<>();
        m.put("ID1",1);
        m.put("ID2",2);
        m.put("ID3",3);
        m.put("ID1",4);
        m.put("ID4",5);
        m.put("ID2",6);

        for (Map.Entry<String, Integer> e :
                m.entrySet()) {
            System.out.println(e.getKey()+" : "+e.getValue());

        }
    }
}
