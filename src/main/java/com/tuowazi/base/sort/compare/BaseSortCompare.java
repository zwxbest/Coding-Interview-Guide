package com.tuowazi.base.sort.compare;

import com.tuowazi.base.sort.BaseSort;
import com.tuowazi.base.sort.bubble.down.BubbleDownSort2;
import com.tuowazi.base.sort.insertion.InsertionSort2;
import com.tuowazi.base.sort.selection.SelectionSort2;

/**
 * 基础排序比较
 * @author zhangweixiao
 */
public class BaseSortCompare {

    //插入比选择牛逼的地方在于:插入式相邻交换，选择不是
    //插入比冒泡牛逼的地方在于：插入是 i = 1; i < n，冒泡是int j = 0; j < i-1，
    //可能i在for的条件上比较耗费时间？
    public static void main(String[] args)  {
        BaseSort.COUNT = 5_0000;
        BubbleDownSort2.main(null);
        InsertionSort2.main(null);
        SelectionSort2.main(null);
    }
}
