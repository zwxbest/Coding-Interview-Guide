package com.tuowazi.base.sort.compare;

import com.tuowazi.base.sort.BaseSort;
import com.tuowazi.base.sort.merge.*;

public class MergeSortCompare {

    public static void main(String[] args) {
        BaseSort.COUNT = 500_0000;
        MergeSort.main(null);
        MergeSort2.main(null);
        MergeSort3.main(null);
        MergeSort4.main(null);
        MergeSortBU.main(null);
    }
}
