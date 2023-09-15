package recursion;

public class PrintLastIndex {
    public static void main(String[] args) {
        int[] arr = {7,9,2,5,8,1,1,0,7,2,5,9};
        System.out.println(printLastIndexOf(9, arr.length-1, arr));
    }

    private static int printLastIndexOf(int i, int lastIndex, int[] arr) {
        if(-1 == lastIndex)
            return -1;
        if(arr[lastIndex] == i)
            return lastIndex;
        else
            return printLastIndexOf(i, lastIndex-1, arr);
    }
}
