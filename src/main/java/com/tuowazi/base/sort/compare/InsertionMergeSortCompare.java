package com.tuowazi.base.sort.compare;

import com.tuowazi.base.sort.BaseSort;
import com.tuowazi.base.sort.insertion.InsertionSort2;
import com.tuowazi.base.sort.merge.MergeSort;

/**
 * 对比上浮的冒泡排序
 *
 * @author zhangweixiao
 */
public class InsertionMergeSortCompare {

    public static void main(String[] args)  {
        BaseSort.COUNT = 5_0000;
        MergeSort.main(null);
        InsertionSort2.main(null);
    }
}
