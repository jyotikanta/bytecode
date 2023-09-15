package recursion;

public class PrintAllIndex {
    public static void main(String[] args) {
        int[] arr = {7,9,2,5,8,1,1,0,7,2,5,9};
        System.out.println(printFirstIndexOf(0, 0, arr));
    }

    private static int printFirstIndexOf(int i, int startIndex, int[] arr) {
        if(arr.length == startIndex)
            return -1;
        if(arr[startIndex] == i)
            return startIndex;
        else
            return printFirstIndexOf(i, startIndex+1, arr);
    }
}
