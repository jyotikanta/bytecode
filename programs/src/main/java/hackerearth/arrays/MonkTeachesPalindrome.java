package hackerearth.arrays;

import java.util.Scanner;

public class MonkTeachesPalindrome {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int noOfTestCase = s.nextInt();
        for(int i=0;i<noOfTestCase;i++)
        {
            String inputString = s.nextLine();
            boolean isPalindrome = isPalindrome(inputString);
            if(isPalindrome)
                System.out.println("YES "+ (inputString.length()%2==0?"EVEN":"ODD"));
            else
                System.out.println("NO");
        }
    }

    private static boolean isPalindrome(String inputString) {
        StringBuffer sb = new StringBuffer(inputString);
        return (sb.reverse().toString().equalsIgnoreCase(inputString));
    }
}
