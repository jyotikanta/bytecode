package topcoder;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RangeEncodingTest {

    @DataProvider(name = "setAndRange")
    public Object[][] provideData() {
        return new Object[][]
                {
                        {new int[]{1,2,3,4,5,6,7,8,9,10}, 1},
                        {new int[]{1,6,10,20,32,49}, 6},
                        {new int[]{2,4,5,6,8,9,10,11,12,15}, 4},
                        {new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47}, 14},
                        {new int[]{10,11,12,13,14,15,20,21,22,23,25,27,28,29,30,31,32,33}, 4},
                        {new int[]{33}, 1}
                };
    }

    @Test(groups = {"smoke"}, dataProvider = "setAndRange")
    public void testRangeEncoding(int[] num, int expected) {
        RangeEncoding rangeEncoding = new RangeEncoding();
        int actual = rangeEncoding.minRanges(num);
        Assert.assertEquals(actual, expected);
    }

}