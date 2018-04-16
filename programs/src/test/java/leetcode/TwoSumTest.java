package leetcode;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TwoSumTest {
    @DataProvider(name = "numbersAndTarget")
    public Object[][] provideData() {
        return new Object[][]
                {
                        {new int[]{2, 7, 11, 15}, 13, new int[]{0, 2}},
                        {new int[]{2, 1, 5, 1}, 6, new int[]{1, 2}},
                        {new int[]{1, 5, -4, 7, 0, 0}, 3, new int[]{2, 3}},
                        {new int[]{1, 5, -4, 7, 0, 0}, 0, new int[]{4, 5}},
                        {new int[]{3, 2, 4}, 6, new int[]{1, 2}}
                };
    }

    @Test(groups = {"smoke"}, dataProvider = "numbersAndTarget")
    public void testTwoSum(int[] num, int target, int expected[]) {
        TwoSum twoSum = new TwoSum();
        int actual[] = twoSum.twoSum(num,target);

        String indexActual = Integer.toString(actual[0]).concat(",").concat(Integer.toString(actual[1]));
        String indexExpected = Integer.toString(expected[0]).concat(",").concat(Integer.toString(expected[1]));
        Assert.assertEquals(indexActual,indexExpected);
    }
}
