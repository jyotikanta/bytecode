package neetcode.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(new int[]{-1,0,3,5,9,12,19,90,102,105,1000}, 2));
    }
    public int search(int[] nums, int target) {
        int si = 0;
        int li = nums.length-1;
        while (si<=li){
            int mi = li+si/2;
            if(target == nums[mi]){
                return mi;
            } else if (target > nums[mi]) {
                si = mi+1;
            } else{
                li = mi-1;
            }
        }
        return -1;
    }
}
