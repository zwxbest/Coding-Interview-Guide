package com.tuowazi.base.sort.merge;

import com.tuowazi.base.sort.AdvanceSort;
import java.util.Arrays;

//自底向上完成归并排序
//2-4-8 排序，不需要分组
public class MergeSortBU extends AdvanceSort {

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
    //注意16这个长度
    @Override
    protected  void sort(int[] arr) {
        int length = arr.length;
        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
        for (int i = 0; i < length; i += 16){
            //对每个16长度的数组使用插入排序
            insertionSort(arr, i, Math.min(i + 15, length - 1));
        }

        //先把16作为一个单位的合并，然后32，然后64等等合并
        for (int size = 16; size < length; size += size)
            //每次跨越两个size
            for (int i = 0; i < length - size; i += size + size){
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                int mid = i+size-1;
                if (arr[mid] > arr[mid+1]){
                    merge(arr, i, mid, Math.min(i + size + size - 1, length - 1));
                }
            }
    }


    @Override
    protected String getName(){
        return "自底向上的归并排序";
    }

    public static void main(String[] args) {
        new MergeSortBU().sort();
    }
}