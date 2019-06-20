package com.tuowazi.base.sort;

import com.tuowazi.base.sort.quick.QuickSort1;
import com.tuowazi.base.sort.quick.QuickSort2;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-4-2
 */
public class QuickSort2Test extends SortTest {

    @BeforeClass
    public static void beforeClass(){
        baseSort = new QuickSort2();
    }

    @Test
    public void testManySame(){
        super.testManySame();
    }
}

