package recursion;

import java.util.HashMap;

public class GridTraveller {
    public static void main(String[] args) {
        System.out.println(gridTraveller(100L,100L));
    }

    static HashMap<String,Long> memo = new HashMap<>();
    private static long gridTraveller(long m, long n) {
        if(memo.containsKey(m+","+n))
            return memo.get(m+","+n);
        if(m==1&&n==1)
            return 1;
        if(m==0||n==0)
            return 0;
        long noOfRoutes = gridTraveller(m-1,n) + gridTraveller(m,n-1);
        memo.put(m+","+n, noOfRoutes);
        return memo.get(m+","+n);
    }
}
