package leetcode;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlusOneTest {

    @DataProvider(name = "numbersAndTarget")
    public Object[][] provideData() {
        return new Object[][]
                {
                        {new int[]{2, 0, 1, 3}, new int[]{2,0,1,4}},
                        {new int[]{2, 0, 1, 4}, new int[]{2,0,1,5}},
                        {new int[]{3, 6, 1, 0}, new int[]{3,6,1,1}},
                        {new int[]{1, 3, 6, 9},new int[]{1,3,6,0}}
                };
    }

    @Test(groups = {"smoke"}, dataProvider = "numbersAndTarget")
    public void testSolution(int[] arr, int expectedArr) {
        PlusOne plusOne = new PlusOne();
        Assert.assertEquals(plusOne.solution(arr), expectedArr);
    }
}