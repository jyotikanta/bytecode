package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapSortExample {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 3);
        map.put('B', 1);
        map.put('C', 2);

        // Sorting by values


        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
    }

    public static void sortByValue(HashMap<Character, Integer> map) {
        // Convert HashMap to List of Map.Entry
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Sort the list by value
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Print the sorted entries
        for (Map.Entry<Character, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Optional: If you need a LinkedHashMap with the sorted order
        Map<Character, Integer> sortedMap = entryList.stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.println("Sorted map: " + sortedMap);
    }

    public static int minimumPushes(String word) {
        char[] arr = word.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c:arr){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int len = map.size();

        int pushes = 0;
        int total = 1;
        for(Map.Entry<Character,Integer> entry: entryList){

            if(total<=8){
                pushes+=entry.getValue();
            }else if(total<=16){
                pushes+=(entry.getValue()*2);
            }else if(total<=24){
                pushes+=(entry.getValue()*3);
            }else{
                pushes+=(entry.getValue()*4);
            }
            total++;
        }

        return pushes;
    }
}
