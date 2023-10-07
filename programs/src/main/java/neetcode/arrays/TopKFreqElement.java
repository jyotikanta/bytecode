package neetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TopKFreqElement
{
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3,3,3,4};
        int topK = 1;
        TopKFreqElement topKObj = new TopKFreqElement();
        System.out.println(Arrays.toString(topKObj.topKFrequent(nums, topK)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>(nums.length);
        // 1,1,1,2,2,2,3,3,3,4
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        //freqMap 1->3, 2->3, 3->3, 4->1
        //create buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for(int i=0;i<=nums.length;i++){
            buckets.add(new ArrayList<>());
        }
        for(int key: freqMap.keySet()){
            int valueAtKey = freqMap.get(key);
            buckets.get(valueAtKey).add(key);
        }
        //buckets = {{4},{}, {1,2,3}, {}}
        List<Integer> topKList = new ArrayList<>();
        for(int i=nums.length;i>=0 && topKList.size()<k; i--) {
            topKList.addAll(buckets.get(i));
        }
        //topKList -> {1,2,3}
        int[] topK = new int[topKList.size()];
        int idx=0;
        for(int i : topKList)
        {
            topK[idx++] =  i;
        }
        return topK;
    }
}
