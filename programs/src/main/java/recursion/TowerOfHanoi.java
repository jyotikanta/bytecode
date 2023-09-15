package recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    static int noofSteps = 0;
    public static void main(String[] args) {
        String t1 = "t1";
        String t2 = "t2";
        String t3 = "t3";
        int noOfDiscs = new Scanner(System.in).nextInt();
        printTowerOfHanoiSteps(noOfDiscs, t1, t2, t3);
        System.out.println(noofSteps);
    }

    private static void printTowerOfHanoiSteps(int noOfDiscs, String t1, String t2, String t3) {
        if(noOfDiscs == 0)
            return;
        printTowerOfHanoiSteps(noOfDiscs-1, t1, t3, t2);
        System.out.println(noOfDiscs + " "+t1  + " -> " + t2);
        printTowerOfHanoiSteps(noOfDiscs-1, t3, t2, t1);
        noofSteps++;
    }
}
