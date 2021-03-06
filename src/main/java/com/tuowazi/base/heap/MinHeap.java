package com.tuowazi.base.heap;

import java.util.Random;

public class MinHeap  extends AbstractHeap {

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MinHeap(int capacity) {
        super(capacity);
    }
    // 构造函数, 通过一个给定数组创建一个最大堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MinHeap(int[] arr) {
        super(arr);
    }

    @SuppressWarnings("unchecked")
    public void shiftUp(int k) {
        while (k > 1 && data[k / 2] > data[k]) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    //从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    //取出之后将最后一个元素补到堆顶
    //同时向下调整
    public int  extractMin() {
      return extractTop();
    }

    @SuppressWarnings("unchecked")
    public void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k; // 在此轮循环中,data[k]和data[j]交换位置
            //左右那个小和哪个换
            if (j + 1 <= count && data[j + 1] <data[j] ){
                j++;
            }
            // data[j] 是 data[2*k]和data[2*k+1]中的最大值
            //如果k比j大，停止交换
            if (data[k] <= data[j]) {
                break;
            }
            //如果k比2k大， 比2k+1小，和2k+1交换，此时2k+1比2k和k都大
            //也就是把两个孩子节点中最大的交换到上面
            //现在k比j小，交换k到下一层
            swap(k, j);
            k = j;
        }
    }

    // 测试 MaxHeap
    public static void main(String[] args) {
        Random random = new Random();
        MinHeap maxHeap = new MinHeap(100);
        int N = 31; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for (int i = 0; i < N; i++){
            maxHeap.insert( random.nextInt(M));
        }
        maxHeap.treePrint();

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从小到大的顺序取出来的
        for (int i = 0; i < N; i++) {
            arr[i] = maxHeap.extractMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for (int i = 1; i < N; i++)
            assert arr[i - 1] >= arr[i];
    }
}
