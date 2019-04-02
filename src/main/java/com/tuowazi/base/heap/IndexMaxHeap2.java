package com.tuowazi.base.heap;

// 使用最大索引堆进行堆排序, 来验证我们的最大索引堆的正确性
// 最大索引堆的主要作用不是用于排序, 我们在这里使用排序只是为了验证我们的最大索引堆实现的正确性
// 在后续的图论中, 无论是最小生成树算法, 还是最短路径算法, 我们都需要使用索引堆进行优化:)
public class IndexMaxHeap2 extends IndexMaxHeap {

    protected int[] reverse;    // 最大索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置

    public IndexMaxHeap2(int capacity){
        super(capacity);
        reverse = new int[capacity + 1];
    }

    // 从最大索引堆中取出堆顶元素, 即索引堆中所存储的最大数据
    public int  extractMax() {
        assert count > 0;
        int  ret = data[indexes[1]];
        swap(1, count);
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);

        return ret;
    }

    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    @SuppressWarnings("unchecked")
    public void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]] ){
                j++;
            }
            if ( data[indexes[k]]  >=data[indexes[j]] ){
                break;
            }
            swap(k, j);
            k = j;
        }
    }


    // 向最大索引堆中插入一个新的元素, 新元素的索引为i, 元素为item
    // 传入的i对用户而言,是从0索引的
    @Override
    public void insert(int i, int  item) {

        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        // 再插入一个新元素前,还需要保证索引i所在的位置是没有元素的。
        assert !contain(i);

        i += 1;
        data[i] = item;
        //indexes是一个中介
        indexes[count + 1] = i;
        reverse[i] = count + 1;
        count++;

        shiftUp(count);
    }

    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    @SuppressWarnings("unchecked")
    public void shiftUp(int k) {
        while (k > 1 &&  data[indexes[k / 2]] < data[indexes[k]] ) {
            swap(k, k / 2);
            k /= 2;
        }
    }
    // 看索引i所在的位置是否存在元素
    boolean contain(int i) {
        assert i + 1 >= 1 && i + 1 <= capacity;
        return reverse[i + 1] != 0;
    }

}
