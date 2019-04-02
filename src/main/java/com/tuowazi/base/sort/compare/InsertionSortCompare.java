package com.tuowazi.base.sort.compare;

import com.tuowazi.base.sort.BaseSort;
import com.tuowazi.base.sort.insertion.InsertionSort;
import com.tuowazi.base.sort.insertion.InsertionSort2;

/**
 * 对比上浮的冒泡排序
 *
 * @author zhangweixiao
 */
public class InsertionSortCompare {

    public static void main(String[] args)  {
        BaseSort.COUNT = 5_0000;
        InsertionSort.main(null);
        InsertionSort2.main(null);
    }
}
