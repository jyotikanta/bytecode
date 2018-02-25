package hackerearth.sorting;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] inputArray = new int[n];
        for(int i=0;i<n;i++)
        {
            inputArray[i] = s.nextInt();
        }
        int noOfSwap=0;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(inputArray[j]>inputArray[j+1])
                {
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = temp;
                    noOfSwap += 1;
                }
            }
        }
        System.out.println(noOfSwap);
    }
}
