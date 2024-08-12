package map;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<CustomKey, String> map = new HashMap<>();

        CustomKey key1 = new CustomKey("key1", 1);
        CustomKey key2 = new CustomKey("key2", 2);

        map.put(key1, "Value1");
        map.put(key2, "Value2");

        System.out.println("Value for key1: " + map.get(key1));
        System.out.println("Value for key2: " + map.get(key2));
        System.out.println("Value for key2: " + map.size());
    }
}

