package neetcode.twopointers;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray removeDuplicateFromSortedArray = new RemoveDuplicateFromSortedArray();
        System.out.println(removeDuplicateFromSortedArray.removeDuplicates(new int[]{1,1,1,2,2,2,3,3}));
    }

    public int removeDuplicates(int[] nums) {
        int currNum = nums[0];
        int currNumCounts = 1;
        int i = 1;
        int L = 1;
        int R = 1;
        boolean duplicatePresent = false;

        //Find two pointers from where we should look for potential duplicates(more than twice)
        for(i=1;i<nums.length;i++){
            if(currNum==nums[i]){
                currNumCounts++;
                if(currNumCounts>2){
                    //return early if rest of the numbers are same
                    if(currNum==nums[nums.length-1]){
                        return i;
                    }
                    //if the same number occured more than twice then we should start replacing the index with other number in array
                    //0 0 1 1 1 1 2 2 2 3
                    //        L   R
                    L = i;
                    //Find the next number which is not equal to currNumber
                    while(currNum==nums[i]){
                        i++;
                    }

                    //Once we found the two pointers break. here its the L and the i itself are the pointers
                    break;
                }
            }else{
                currNum = nums[i];
                currNumCounts = 1;
            }
        }

        //If we have reached the end of array and did no
        if(i==nums.length){
            return i;
        }

        currNum = nums[i];
        currNumCounts = 1;
        nums[L] = nums[i];
        L++;
        i++;
        while(i<nums.length){
            if(currNum==nums[i]){
                currNumCounts++;
            }
            if(currNumCounts<3){
                nums[L] = nums[i];
                L++;
                i++;
            }else{
                if(currNum==nums[nums.length-1]){
                    return i;
                }
                while(currNum==nums[i]){
                    i++;
                }
            }
        }
        return L;
    }
}
