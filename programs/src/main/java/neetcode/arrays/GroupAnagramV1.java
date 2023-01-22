package neetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramV1
{
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
            int[] count = new int[26];
            for(char c : s.toCharArray())
            {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            if(!map.containsKey(key))
            {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
