package recursion;

import java.util.HashMap;

import java.math.BigInteger;

public class Fibonacci {
    public static void main(String[] args) {
        for(int i=1;i<2001;i++){
            System.out.println(i + " " + fib(BigInteger.valueOf(i)));
        }

    }

    static HashMap<BigInteger, BigInteger> memo = new HashMap<>();
    private static BigInteger fib(BigInteger n) {
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n.compareTo(BigInteger.ONE) < 0){
            return n;
        }
        else{
            memo.put(n, fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.valueOf(2L)))));
        }
        return memo.get(n);
    }
}
