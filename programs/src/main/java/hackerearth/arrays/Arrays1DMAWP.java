package hackerearth.arrays;

import java.util.Scanner;

public class Arrays1DMAWP {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        MonkAndGoodString monkAndGoodString = new MonkAndGoodString();

        int m = s.nextInt();

        int[] array1 = new int[m];
        int[] array2 = new int[m];

        for(int i=0;i<m;i++)
        {
            array1[i] = s.nextInt();
        }

        for(int i=0;i<m;i++)
        {
            array2[i] = s.nextInt();
        }

        for(int i=0;i<m;i++)
        {
            System.out.print(array1[i]+array2[i]+" ");
        }
    }
}
