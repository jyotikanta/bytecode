package neetcode.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        MergeSort ms = new MergeSort();
        System.out.println(Arrays.toString(ms.sortArray(nums)));
    }
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    //5 1 1 2 0 0
    public int[] mergeSort(int[] nums, int s, int e){
        if(s==e){
            return nums;
        }
        int m = (s+e)/2;
        mergeSort(nums,s,m);
        mergeSort(nums,m+1,e);
        merge(nums,s,m,e);
        return nums;
    }

    public void merge(int[] nums, int s, int m, int e){
        int[] L = Arrays.copyOfRange(nums, s, m+1);
        int[] R = Arrays.copyOfRange(nums, m+1, e+1);

        int i = 0;
        int j = 0;
        int k = s;
        while(i<L.length && j<R.length){
            if(L[i]<=R[j]){
                nums[k++] = L[i++];
            }else{
                nums[k++] = R[j++];
            }
        }

        while(i<L.length){
            nums[k++] = L[i++];
        }
        while(j<R.length){
            nums[k++] = R[j++];
        }
    }
}
