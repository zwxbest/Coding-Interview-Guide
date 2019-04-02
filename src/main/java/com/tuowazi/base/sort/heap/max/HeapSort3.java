package com.tuowazi.base.sort.heap.max;

import com.tuowazi.base.sort.BaseSort;

// 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
public class HeapSort3 extends BaseSort {

    public void sort(int[] arr) {
        int n = arr.length;

        // 注意，此时我们的堆是从0开始索引的
        //从最后一个元素的父节点开始
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1

        //从第一个非叶子节点开始做堆排序，构造出最大堆
        for (int i = (n - 1 - 1) / 2; i >= 0; i--){
            shiftDown2(arr, n, i);
        }
        //构造出了最大堆
        for (int i = n - 1; i > 0; i--) {
            //交换后最后一个元素都是最大的
            //第一个和最后一个交换
            swap(arr, 0, i);
            //上面交换过去的最大元素不动，其余的调整并保持堆特性
            //每次只需要shiftDown第0个就可以了。
            //对第一个元素shiftDown
            shiftDown2(arr, i, 0);
        }
    }

    // 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
    // 该优化思想和我们之前对插入排序进行优化的思路是一致的
    private static void shiftDown2(int[] arr, int n, int k) {

        int e = arr[k];
        //左孩子节点是2*k+1
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            //找到两个孩子节点中最大的那个
            if (j + 1 < n && arr[j + 1] > arr[j]){
                j += 1;
            }
            //如果比最大的孩子都大就shiftDown喽
            //比孩子最大的还大就停止。
            if (e >= arr[j]){
                break;
            }
            //比孩子节点还小
            //不需要一直交换
            arr[k] = arr[j];
            k = j;
        }
        //找到一个孩子节点比他小了
        arr[k] = e;
    }

    protected String getName(){
        return "原地堆排序";
    }

    public static void main(String[] args) {
        new HeapSort3().sort();
    }
}
