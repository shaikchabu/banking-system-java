
import java.util.HashMap;
import java.util.Map;

public  class Main{
    public static void main(String[] args) {
        Map<Integer,String> s = new HashMap(Map.of(1, "sowdamini", 2, "pavan"));
           //for (Map.Entry<Integer, String> en : s.entrySet()) {
           //    Object key = en.getKey();
             //  Object val = en.getValue();
              // System.out.println(key+":"+val);

               
           //}
          // for(int key:s.keySet()){
          //  System.out.println(key+":"+s.get(key));
           //}
           for(String name:s.values()){
            System.out.println(name);
           }

    

    }
}