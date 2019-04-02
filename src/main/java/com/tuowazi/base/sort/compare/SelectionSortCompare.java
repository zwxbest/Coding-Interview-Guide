package com.tuowazi.base.sort.compare;

import com.tuowazi.base.sort.BaseSort;
import com.tuowazi.base.sort.selection.SelectionSort;
import com.tuowazi.base.sort.selection.SelectionSort2;

/**
 * 对比上浮的冒泡排序
 *
 * @author zhangweixiao
 */
public class SelectionSortCompare {

    public static void main(String[] args)  {
        BaseSort.COUNT = 5_0000;
        SelectionSort.main(null);
        SelectionSort2.main(null);
    }
}
