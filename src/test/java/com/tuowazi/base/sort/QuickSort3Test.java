package com.tuowazi.base.sort;

import com.tuowazi.base.sort.quick.QuickSort2;
import com.tuowazi.base.sort.quick.QuickSort3;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-4-2
 */
public class QuickSort3Test extends SortTest {

    @BeforeClass
    public static void beforeClass(){
            baseSort = new QuickSort3();
    }

    @Test
    public void testManySame(){
        super.testManySame();
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
}

