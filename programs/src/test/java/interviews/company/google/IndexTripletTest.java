package interviews.company.google;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IndexTripletTest {

    @DataProvider(name = "numbersAndTarget")
    public Object[][] provideData() {
        return new Object[][]
                {
                        {new int[]{-2, 0, 1, 3}, 2, 2},
                        {new int[]{2, 1}, 3, 0},
                        {new int[]{1, 5, -4, 7, 9, 1}, 2, 1},
                        {new int[]{1, 2, 3, 4, 5}, 10, 6}
                };
    }

    @Test(groups = {"smoke"}, dataProvider = "numbersAndTarget")
    public void testThreeSumSmaller(int[] num, int target, int expected) {
        IndexTriplet indexTriplet = new IndexTriplet();
        int actual = indexTriplet.threeSumSmaller(num, target);
        Assert.assertEquals(actual, expected);
    }
}
