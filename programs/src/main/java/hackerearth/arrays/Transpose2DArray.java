package hackerearth.arrays;

import java.util.Scanner;

public class Transpose2DArray {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);

        int m = s.nextInt();
        int n = s.nextInt();

        int[][] array = new int[m][n];

        for(int i=0; i<m; i++)
        {
            for(int j=0;j<n;j++)
            {
                array[i][j] = s.nextInt();
            }
        }


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(array[j][i]+" ");
            }
            System.out.println();
        }
    }
}
