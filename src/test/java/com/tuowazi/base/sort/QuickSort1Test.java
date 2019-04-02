package com.tuowazi.base.sort;

import com.tuowazi.base.sort.quick.QuickSort;
import com.tuowazi.base.sort.quick.QuickSort1;
import org.junit.BeforeClass;

/**
 * @author zhangweixiao - 19-4-2
 */
public class QuickSort1Test extends SortTest {

    @BeforeClass
    public static void beforeClass(){
        baseSort = new QuickSort1();
    }
}

