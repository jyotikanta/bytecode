package neetcode.arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int arr[] = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr, 2));
    }
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] != val)
            {
                nums[k] = nums[i];
                k+=1;
            }
        }
        return k;

        /*int k = 0;
        int toBeSwapped = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == val)
            {
                toBeSwapped = i;
                while(i<nums.length && nums[i]==val)
                {
                    i++;
                }
                i--;
            }
            else
            {
                nums[toBeSwapped] = nums[i];
                toBeSwapped+=1;
            }
        }
        return toBeSwapped;*/
    }
}
