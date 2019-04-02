package com.tuowazi.base.sort.compare;

import com.tuowazi.base.sort.BaseSort;
import com.tuowazi.base.sort.merge.MergeSort3;
import com.tuowazi.base.sort.shell.ShellSort;

public class ShellMergeCompare {
    public static void main(String[] args) {
        BaseSort.COUNT =  5000_0000;
        MergeSort3.main(null);
        ShellSort.main(null);
    }
}
