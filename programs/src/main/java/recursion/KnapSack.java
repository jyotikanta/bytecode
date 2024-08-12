package recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class KnapSack {

    static int[][] dp;
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};

        int W = 30;
        dp = new int[wt.length+1][W+1];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }

        int n = val.length;

        System.out.println(knapSack(W, wt, val, n));

    }

    private static int knapSack(int w, int[] wt, int[] val, int n) {
        if(n==0||w==0){
            return 0;
        }
        if(dp[n][w]!=-1){
            return dp[n][w];
        }
        if(w>=wt[n-1])
            return dp[n][w] = Math.max(val[n-1] + knapSack(w-wt[n-1],wt,val,n-1), knapSack(w,wt,val,n-1));
        else
            return dp[n][w] = knapSack(w,wt,val,n-1);
    }
}
