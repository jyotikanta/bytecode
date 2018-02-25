package leetcode.easy;

public class CountPrimesInLessTime {

    public int countPrimes(int n) {
        long startMillisSeconds = System.currentTimeMillis();
        if (n < 3)
            return 0;

        boolean[] f = new boolean[n];
        //Arrays.fill(f, true); boolean[] are initialed as false by default
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i])
                continue;

            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }

        long endMillisSecond = System.currentTimeMillis();
        System.out.println("Total Time Taken for "+ n +" = " + (endMillisSecond-startMillisSeconds) +"ms");
        return count;


    }
}
