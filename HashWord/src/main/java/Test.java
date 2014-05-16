import java.util.HashMap;
import java.util.Map;

/**
 * Created by Фирюза on 26.04.14.
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(32,0.9f);
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",20);

        System.out.println(map.containsKey("3"));
        System.out.println(map.containsValue(20));
        System.out.println(map.get("3")); // 3

        map.remove("4");
        System.out.println(map);

        //map.put(null);
        for (Map.Entry<String, Integer> iter : map.entrySet()) { // entrySet returns mess Set
            System.out.println(iter.getKey() + " " + iter.getValue());
        }
    }
}
