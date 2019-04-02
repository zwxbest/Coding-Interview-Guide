package com.tuowazi.base.sort.compare;

import com.tuowazi.base.sort.BaseSort;
import com.tuowazi.base.sort.bubble.down.BubbleDownSort;
import com.tuowazi.base.sort.bubble.down.BubbleDownSort1;
import com.tuowazi.base.sort.bubble.down.BubbleDownSort2;

/**
 * 对比上浮的冒泡排序
 *
 * @author zhangweixiao
 */
public class BubbleDownSortCompare {

    public static void main(String[] args)  {
        BaseSort.COUNT = 5_0000;
        BubbleDownSort.main(null);
        BubbleDownSort1.main(null);
        BubbleDownSort2.main(null);
    }
}
