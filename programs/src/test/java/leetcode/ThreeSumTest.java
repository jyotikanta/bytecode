package leetcode;

import interviews.company.google.IndexTriplet;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreeSumTest {

    @DataProvider(name = "numbersAndTarget")
    public Object[][] provideData() {
        List<List<Integer>> list1 = new ArrayList<>();
        ArrayList<Integer> innerList1 = new ArrayList<>();
        innerList1.add(-1);
        innerList1.add(0);
        innerList1.add(1);
        list1.add(innerList1);
        ArrayList<Integer> innerList2 = new ArrayList<>();
        innerList2.add(-1);
        innerList2.add(-1);
        innerList2.add(2);
        list1.add(innerList2);
        return new Object[][]
                {
                        //1 2 2 1 -3 1 7
                        {new int[]{-1,0,1,2,-1,-4}, list1}
                };
    }

    @Test(groups = {"smoke"}, dataProvider = "numbersAndTarget")
    public void testThreeSum(int[] num, List<List<Integer>> expected) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> actual = threeSum.threeSum(num);
        Assert.assertEquals(actual, expected);
    }
}
