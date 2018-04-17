package topcoder;

public class RangeEncoding {

    int minRanges(int[] arr)
    {
        int count = 1;
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i]-1 != arr[i-1])
                count++;
        }
        return count;
    }
}
