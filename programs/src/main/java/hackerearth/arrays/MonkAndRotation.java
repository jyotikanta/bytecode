package hackerearth.arrays;

import java.util.Scanner;

public class MonkAndRotation {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);

        int noOfTestCase = s.nextInt();

        for (int i = 0; i < noOfTestCase; i++) {
            int noOfElement = s.nextInt();
            int[] array = new int[noOfElement];
            int stepsOfRotation = s.nextInt();
            for (int j = 0; j < noOfElement; j++) {
                array[j] = s.nextInt();
            }
            rotateArray(array, stepsOfRotation);
        }

    }

    private static void rotateArray(int[] array, int steps) {
        int startIndex = array.length - (steps % array.length);

        StringBuilder sb = new StringBuilder();

        for (int i = startIndex; i < array.length; i++) {
            sb.append(array[i] + " ");
        }

        for (int i = 0; i < startIndex; i++) {
            sb.append(array[i] + " ");
        }
        System.out.println(sb);
    }
}
