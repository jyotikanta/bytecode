package hackerearth.arrays;

import java.util.Scanner;
//One dimensional array addition
public class Arrays1DMAWP {
    public static void main(String args[]) throws Exception {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();

        int[] array1 = new int[size];
        int[] array2 = new int[size];

        for(int i=0;i<size;i++)
        {
            array1[i] = input.nextInt();
        }

        for(int i=0;i<size;i++)
        {
            array2[i] = input.nextInt();
        }

        for(int i=0;i<size;i++)
        {
            System.out.print(array1[i]+array2[i]+" ");
        }
    }
}
