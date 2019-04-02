package com.tuowazi.base.sort;

import com.tuowazi.base.sort.quick.QuickSort;
import com.tuowazi.test.BaseTest;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-4-2
 */
public class SortTest extends BaseTest {


    protected static BaseSort baseSort;

    @Test
    public void testAsc(){
        int[] arr = new int[]{1,2,3,4,5};
        baseSort.sort(arr);
        assertEqual(arr,new int[]{1,2,3,4,5});
    }

    @Test
    public void testDesc(){
        int[] arr = new int[]{5,4,3,2,1};
        baseSort.sort(arr);
        assertEqual(arr,new int[]{1,2,3,4,5});
    }

    @Test
    public void testRandom(){
        int[] arr = new int[]{2,4,3,5,1};
        baseSort.sort(arr);
        assertEqual(arr,new int[]{1,2,3,4,5});
    }

    @Test
    public void testSame(){
        int[] arr = new int[]{2,2,2,2,2};
        baseSort.sort(arr);
        assertEqual(arr,new int[]{2,2,2,2,2});
    }

    /**
     * 测试稳定性
     */
    @Test
    public void stableTest(){
        int[] arr = new int[]{5,3,3,4,3,8,9,10,11};
        baseSort.sort(arr);
    }
}
