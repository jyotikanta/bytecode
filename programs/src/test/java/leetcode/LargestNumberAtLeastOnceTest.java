package leetcode;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LargestNumberAtLeastOnceTest {


    @DataProvider(name = "numbersAndTarget")
    public Object[][] provideData() {
        return new Object[][]
                {
                        {new int[]{2, 0, 1, 3}, -1},
                        {new int[]{2, 0, 1, 4}, 3},
                        {new int[]{3, 6, 1, 0}, 1},
                        {new int[]{15},0}
                };
    }

    @Test(groups = {"smoke"}, dataProvider = "numbersAndTarget")
    public void testSolution(int[] nums, int expected) {
        LargestNumberAtLeastOnce solution = new LargestNumberAtLeastOnce();
        Assert.assertEquals(solution.dominantIndex(nums), expected);
    }

}