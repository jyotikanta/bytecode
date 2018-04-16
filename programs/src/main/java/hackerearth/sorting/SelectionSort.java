package hackerearth.sorting;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] inputArray = new int[n];
        for(int i=0;i<n;i++)
        {
            inputArray[i] = s.nextInt();
        }

        for(int i=0;i<n-1;i++)
        {
            int minimum = i;
            for(int j=i+1;j<n;j++)
            {
                if(inputArray[j]<inputArray[minimum])
                {
                    minimum = j;
                }
            }
            int temp = inputArray[i];
            inputArray[i] = inputArray[minimum];
            inputArray[minimum] = temp;
        }

        for(int i=0;i<n;i++)
        {
            System.out.print(inputArray[i]+" ");
        }

    }
}
