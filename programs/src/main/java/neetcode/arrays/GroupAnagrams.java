package neetcode.arrays;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args)
    {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ga = groupAnagrams(strs);
        System.out.println(ga);
    }
    public static List<List<String>> groupAnagrams(String[] strs)
    {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs)
        {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(!map.containsKey(key))
            {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

}
