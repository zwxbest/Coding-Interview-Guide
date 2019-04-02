package com.tuowazi.base.heap;

public interface Heap {

    void shiftUp(int k);

    void shiftDown(int k);

    int size();

    int  getTop();

    int  extractTop();

    void insert(int item);

    boolean isEmpty();
}
