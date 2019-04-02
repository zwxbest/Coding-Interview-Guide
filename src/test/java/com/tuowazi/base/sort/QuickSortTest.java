package com.tuowazi.base.sort;

import com.tuowazi.base.sort.quick.QuickSort;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-4-2
 */
public class QuickSortTest extends SortTest {

    @BeforeClass
    public static void beforeClass(){
        baseSort = new QuickSort();
    }

    @Test
    public void testAsc(){
        super.testAsc();
    }

    @Test
    public void testDesc(){
        super.testDesc();
    }

    @Test
    public void testRandom(){
        super.testRandom();
    }

    @Test
    public void testSame(){
        super.testSame();
    }

    /**
     * 测试稳定性
     */
    @Test
    public void stableTest(){
        super.stableTest();
    }
}

