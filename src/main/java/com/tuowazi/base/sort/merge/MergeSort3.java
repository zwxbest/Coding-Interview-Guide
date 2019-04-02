package com.tuowazi.base.sort.merge;

import com.tuowazi.base.sort.AdvanceSort;
import java.util.Arrays;

public class MergeSort3 extends AdvanceSort {

    //合并部分，需要开辟同样大小的临时辅助空间
    // 将arr[left...mid]和arr[mid+1...right]两部分进行归并
    private  void merge(int[] arr, int left, int mid, int right) {

        //辅助数组
        //为什么是right+1，因为length是按照to-from来的，
        //前面是分成left mid right 长度是right-left+1
        //from是include的，但是to是exclusive的
        int[] aux = Arrays.copyOfRange(arr, left, right + 1);

        // 初始化，i指向左半部分的起始索引位置left；j指向右半部分起始索引位置mid+1
        //mid是分给left一组的
        int i = left, j = mid + 1;
        //k表示下一个需要放的位置
        for (int k = left; k <= right; k++) {
            //处理越界
            compareTimes++;
            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                while (j <= right){
                    assignTimes++;
                    arr[k++] = aux[j - left];
                    j++;
                }
            } else if (j > right) {   // 如果右半部分元素已经全部处理完毕
                while (i <= mid){
                    assignTimes++;
                    arr[k++]=aux[i-left];
                    i++;
                }
                //把分割开的两者比较小的放到arr[k]
                //因为aux的部分arr，所以i-left
            } else if (aux[i - left] <  aux[j - left]) {  // 左半部分所指元素 < 右半部分所指元素
                assignTimes++;
                arr[k] = aux[i - left];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                assignTimes++;
                arr[k] = aux[j - left];
                j++;
            }
        }
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
        private  void sort(int[] arr, int left, int right) {
            // 优化2: 对于小规模数组, 使用插入排序
            if (right - left <= 15) {
                insertionSort(arr, left, right);
                return;
            }
        //首先左半部分有序，然后右半部分有序
        int mid = left+(right-left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        if(arr[mid] > arr[mid+1] ){
            merge(arr, left, mid, right);
        }

    }

    @Override
    protected  void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }


    @Override
    protected String getName(){
        return "用插入排序优化的归并排序";
    }

    public static void main(String[] args) {
        new MergeSort3().sort();
    }
}