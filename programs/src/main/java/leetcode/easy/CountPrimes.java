package leetcode.easy;

public class CountPrimes {
    public int countPrimes(int n) {
        long startMillisSeconds = System.currentTimeMillis();
        int count = 0;
        if(n>=0)
        {
            for(int num=2;num<=n;num++)
            {
                count = count + isPrime(num);
            }
        }
        else
            throw new IllegalArgumentException("Number is negative...");
        long endMillisSecond = System.currentTimeMillis();
        System.out.println("Total Time Taken for "+ n +" = " + (endMillisSecond-startMillisSeconds) +"ms");
        return count;
    }

    private int isPrime(int num) {
        boolean flag = true;
        if(num==2 || num==3)
            return 1;
        for(int i=num/2;i>=2;i--)
        {
            if(num%i == 0)
            {
                flag = false;
                break;
            }

        }
        if(flag)
            return 1;
        return 0;
    }
}
