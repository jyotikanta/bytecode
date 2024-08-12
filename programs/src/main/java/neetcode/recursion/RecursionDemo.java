package neetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//java -Xss2m neetcode.recursion.RecursionDemo
public class RecursionDemo {
    public static void main(String[] args) {
        RecursionDemo rd = new RecursionDemo();
        System.out.println(rd.getNumber());
    }
    static int i = 0;
    public int getNumber(){
        Map<Integer, String> map = new HashMap<>(50);
        for(int i=0;i<100;i++){
            map.put(i, "abc"+i);
        }
        System.out.println(i++);
        return getNumber();
    }
}
