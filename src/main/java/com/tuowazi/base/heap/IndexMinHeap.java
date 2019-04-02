package com.tuowazi.base.heap;

public class IndexMinHeap extends MinHeap {

    protected int[] indexes;

    // 从最大索引堆中取出堆顶元素,
    @SuppressWarnings("unchecked")
    public int  extractMin() {
        assert count > 0;
        int  ret = data[indexes[1]];
        swap(1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    @SuppressWarnings("unchecked")
    public void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]] < data[indexes[j]]){
                j++;
            }
            if ( data[indexes[k]] <= data[indexes[j]] ){
                break;
            }
            swap(k, j);
            k = j;
        }
    }


    public void insert(int i, int  item) {
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        i += 1;
        data[i] = item;
        //indexes是一个中介
        indexes[count + 1] = i;
        count++;

        shiftUp(count);
    }

    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    @SuppressWarnings("unchecked")
    public void shiftUp(int k) {
        while (k > 1 &&  data[indexes[k / 2]] >   data[indexes[k]] ) {
            swap(k, k / 2);
            k /= 2;
        }
    }
    @Override
    protected void swap(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
    }


    public IndexMinHeap(int capacity){
        super(capacity);
        indexes = new int[capacity+1];
    }
}
