package com.tuowazi.code_view_guide.cp04._02;

    import com.tuowazi.test.BaseTest;
    import org.junit.Test;

/**
 * @author zhangweixiao - 2019/7/1
 */
public class MinPathSumTest extends BaseTest {

    @Test
    public void test() {
        MinPathSum minPathSum = new MinPathSum();
        int[][] m = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int minPathSum1 = minPathSum.getMinPathSum(m);
        assertEqual(minPathSum1, 12);
    }
}
