package com.tuowazi.base.sort.compare;

import com.tuowazi.base.sort.BaseSort;
import com.tuowazi.base.sort.bubble.up.BubbleUpSort;
import com.tuowazi.base.sort.bubble.up.BubbleUpSort1;
import com.tuowazi.base.sort.bubble.up.BubbleUpSort2;

/**
 * 对比上浮的冒泡排序
 *
 * @author zhangweixiao
 */
public class BubbleUpSortCompare  {

    public static void main(String[] args)  {
        BaseSort.COUNT = 5_0000;
        BubbleUpSort.main(null);
        BubbleUpSort1.main(null);
        BubbleUpSort2.main(null);
    }
}
