package neetcode.twopointers;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int si = 0;
        int li = numbers.length-1;
        while (si<li)
        {
            int sum = numbers[si] + numbers[li];
            if(sum == target)
            {
                break;
            }
            else if(sum > target)
            {
                li-=1;
            }
            else
            {
                si+=1;
            }
        }
        return new int[] {si+1, li+1};
    }

    public static void main(String[] args) {
        int c[] = twoSum(new int[]{2,7,11,15}, 9);
        for(int i: c)
            System.out.println(i);
    }
}