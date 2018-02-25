package leetcode.easy;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCountPrimeInLessTime {

    @DataProvider(name = "numbers")
    public Object[][] provideData() {
        return new Object[][]
                {
                        {100,25},
                        {23, 8},
                        {300, 62},
                        {10000, 1229},
                        {1, 0},
                        {2,0},
                        {4,2},
                        {0,0}
                };
    }

    @Test(groups = {"smoke"}, dataProvider = "numbers")
    public void testCountPrimes(int num, int expected) {
        String[] arr = {"a","sdad"};
        CountPrimesInLessTime countPrimes = new CountPrimesInLessTime();
        int actual = countPrimes.countPrimes(num);
        Assert.assertEquals(actual,expected);
    }
}
