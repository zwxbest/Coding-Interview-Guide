package com.tuowazi.base.sort.compare;

import com.tuowazi.base.sort.BaseSort;
import com.tuowazi.base.sort.quick.QuickSort;
import com.tuowazi.base.sort.quick.QuickSort2;
import com.tuowazi.base.sort.quick.QuickSort3;

public class QuickSortCompare extends BaseSort {
    public static void main(String[] args) {
        BaseSort.COUNT = 100_0000;
        QuickSort.main(null);
        QuickSort2.main(null);
        QuickSort3.main(null);
    }
}
