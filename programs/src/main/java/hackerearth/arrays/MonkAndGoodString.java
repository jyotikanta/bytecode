package hackerearth.arrays;

import java.util.Scanner;

public class MonkAndGoodString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String badString = s.nextLine();
        byte[] badStringASCII = badString.getBytes();
        int oldLen = 0;
        for (int i = 0; i < badStringASCII.length; i++)
        {
            if(isPrime(badStringASCII[i]))
            {
                int currentLen = 0;
                while(i<badStringASCII.length)
                {
                    if(isPrime(badStringASCII[i]))
                    {
                        currentLen+=1;
                    }
                    else
                    {
                        break;
                    }
                    i+=1;
                }
                if(oldLen<currentLen)
                {
                    oldLen = currentLen;
                }
            }
        }
        System.out.println(oldLen);
    }

    private static boolean isPrime(byte ascii)
    {
        return (ascii==97 || ascii==101 || ascii==105 || ascii==111 || ascii==117);
    }
}
