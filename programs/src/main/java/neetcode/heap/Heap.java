package neetcode.heap;

import java.util.*;

public class Heap {

    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i<stones.length;i++){
            maxHeap.add(stones[i]);
        }
        while(maxHeap.size()>1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int newStone = Math.abs(stone1-stone2);
            if(newStone!=0){
                maxHeap.add(newStone);
            }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }

    public static int[][] kClosest(int[][] points, int k) {
        HashSet<Integer> s = new HashSet<>();
        s.contains(1);
        int[][] res = new int[k][];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> pointsMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<points.length;i++){
            Integer value = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            if(!pointsMap.containsKey(value)){
                pointsMap.put(value, new ArrayList<Integer>());
            }
            pointsMap.get(value).add(new Integer(i));
        }

        for(Map.Entry<Integer,ArrayList<Integer>> entry : pointsMap.entrySet()){
            pq.add(entry.getKey());
        }

        int tmpK = 0;
        while(tmpK<k){
            Integer point = pq.poll();
            ArrayList<Integer> coOrdinates = pointsMap.get(point);
            for(Integer c: coOrdinates){
                res[tmpK] = points[c];
                tmpK++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(1);
        kClosest(new int[][]{{0,1},{1,0}},2);

       /* lastStoneWeight(new int[]{2,7,4,1,8,1});
        Integer[] arr = new Integer[]{0,12,6,40,30,5,35,10,15,45};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Arrays.asList(arr));
        minHeap.poll();
        // Print the min heap elements
        System.out.println("Min Heap: " + minHeap);*/

        //int[] arr = new int[]{0,4,5,8,7};
       /* printArray(arr);

        *//*System.out.println("Create Min Heap");
        createMinHeap(arr);
        printArray(arr);*//*
//[5, 6, 10, 15, 12, 35, 40, 30, 45]
        System.out.println("Heapify");
        heapify(arr);
        printArray(arr);

      *//*  //TODO Fix ite
        System.out.println("Delete Min Heap");
        deleteMinHeap(arr);
        printArray(arr);*//*

        System.out.println("Create Max Heap");
        createMaxHeap(arr);
        printArray(arr);*/

       /* System.out.println("Delete Max Heap");
        deleteMaxHeap(arr);
        printArray(arr);*/
    }

    public static void createMaxHeap(int[] nums){
        for(int i=2;i<nums.length;i++){
            insertIntoMaxHeap(nums, i);
        }
    }
    public static void createMinHeap(int[] nums){
        for(int i=2;i<nums.length;i++){
            insertIntoMinHeap(nums, i);
        }
    }

    public static void deleteMaxHeap(int[] nums){
        for(int i=nums.length-1;i>0;i--){
            deleteFromMaxHeap(nums, i);
        }
    }
    public static void deleteMinHeap(int[] nums){
        for(int i=nums.length-1;i>0;i--){
            deleteFromMinHeap(nums, i);
        }
    }
    public static void insertIntoMaxHeap(int[] nums, int index){
        while(index>1 && nums[index]>=nums[index/2]){
            int tmp = nums[index];
            nums[index] = nums[index/2];
            nums[index/2] = tmp;
            index/=2;
        }
    }

    public static void insertIntoMinHeap(int[] nums, int index){
        while(index>1 && nums[index]<=nums[index/2]){
            int tmp = nums[index];
            nums[index] = nums[index/2];
            nums[index/2] = tmp;
            index/=2;
        }
    }

    public static void deleteFromMaxHeap(int[] nums, int n){
        int index = 1;
        int tmp = nums[1];
        nums[1] = nums[n];
        int j = index*2;
        while (j<n-1){
            if(nums[j+1]>nums[j]){
                j++;
            }
            if(nums[index] <= nums[j]){
                int tmp1 = nums[index];
                nums[index] = nums[j];
                nums[j] = tmp1;
                index = j;
                j*=2;
            }
        }
        nums[n] = tmp;
    }

    public static void deleteFromMinHeap(int[] nums, int n){
        int tmp = nums[1];
        nums[1] = nums[n];
        int i = 1;
        int j = i*2;
        while (j<n-1){
            if(nums[j+1]<nums[j]){
                j++;
            }
            if(nums[j]<nums[i]){
                int tmp1 = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp1;
                i = j;
                j*=2;
            }
        }
        nums[n] = tmp;
    }

    public static void heapify(int[] nums){
        int li = (nums.length-1)/2;
        while(li>=1){
            heapify(nums, li--);
        }
    }

    public static void heapify(int[] nums, int n){
        int index = n;
        int j = index;
        if(j*2==nums.length-1){
            if(nums[index]>nums[j*2]){
                int tmp1 = nums[index];
                nums[index] = nums[j*2];
                nums[j*2] = tmp1;
                j*=2;
            }
        }
        while (j <= (nums.length-1)/2){
            j*=2;
            if(nums[j+1]<nums[j]){
                j++;
            }
            if(nums[index] > nums[j]){
                int tmp1 = nums[index];
                nums[index] = nums[j];
                nums[j] = tmp1;
                index = j;
            }
        }
    }
    public static void printArray(int[] n){
        for(int i=0;i<n.length;i++){

            System.out.print(n[i] + "\t");
        }
        System.out.println();
    }
}
