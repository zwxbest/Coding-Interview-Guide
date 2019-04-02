package com.tuowazi.base.sort.merge.extend;

import com.tuowazi.base.sort.BaseSort;
import java.util.Arrays;

public class InversePairCount {

    private long solve(int[] arr) {
        int n = arr.length;
        return solve(arr, 0, n - 1);
    }

    // 求arr[left..right]范围的逆序数对个数
    // 思考: 归并排序的优化可否用于求逆序数对的算法? :)
    private  long solve(int[] arr, int left, int right) {

        if (left >= right)
            return 0L;

        int mid = left + (right - left) / 2;
        // 求出 arr[left...mid] 范围的逆序数
        long res1 = solve(arr, left, mid);
        // 求出 arr[mid+1...right] 范围的逆序数
        long res2 = solve(arr, mid + 1, right);

        return res1 + res2 + merge(arr, left, mid, right);
    }

    // merge函数求出在arr[left...mid]和arr[mid+1...right]有序的基础上, arr[left...right]的逆序数对个数
    private  long merge(int[] arr, int left, int mid, int right) {

        int[] aux = Arrays.copyOfRange(arr, left, right + 1);

        // 初始化逆序数对个数 res = 0
        long res = 0L;
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                while (j <= right){
                    arr[k++] = aux[j - left];
                    j++;
                }
            } else if (j > right) {   // 如果右半部分元素已经全部处理完毕
                while (i <= mid){
                    arr[k++] = aux[i - left];
                    i++;
                }
            } else if (aux[i - left] <= aux[j - left]) {  // 左半部分所指元素 <= 右半部分所指元素
                arr[k] = aux[i - left];
                i++;
            } else {   // 右半部分所指元素 < 左半部分所指元素
                arr[k] = aux[j - left];
                j++;
                // 此时, 因为右半部分k所指的元素小
                // 这个元素和左半部分的所有未处理的元素都构成了逆序数对
                // 左半部分此时未处理的元素个数为 mid - j + 1
                res += (long) (mid - i + 1);
            }
        }
        return res;
    }


    private  void checkValid(){
        int[] arrSorted = new int[]{1,2,3,4};
        //随机
        int[] arr = new int[]{3,2,1,4};
        solve(arr);
        arrEqual(arr,arrSorted);
        //升序
        arr = new int[]{1,2,3,4};
        solve(arr);
        arrEqual(arr,arrSorted);
        //降序
        arr = new int[]{4,3,2,1};
        solve(arr);
        arrEqual(arr,arrSorted);
        //相等
        arr = new int[]{2,2,2,2};
        solve(arr);
        arrEqual(arr,new int[]{2,2,2,2});
    }


    private void arrEqual(int[] arr1,int[] arr2){
        if(arr1.length!=arr2.length){
            throw new RuntimeException("排序算法错误");
        }
        for (int i= 0 ;i < arr1.length;i++) {
            if(arr1[i]!=arr2[i]){
                throw new RuntimeException("排序算法错误");
            }
        }
    }

    public static void main(String[] args) {
        InversePairCount pairCount =  new InversePairCount();
        pairCount.checkValid();
        int[] arr = BaseSort.generateRandomArray(5);
        long inversePairCount = pairCount.solve(Arrays.copyOf(arr,arr.length));
        System.out.println(String.format("随机数组%s的的逆序对数量是%s",Arrays.toString(arr),inversePairCount));
        arr = BaseSort.generateAscOrderedArray(5);
        inversePairCount =pairCount.solve(Arrays.copyOf(arr,arr.length));
        System.out.println(String.format("升序数组%s的的逆序对数量是%s",Arrays.toString(arr),inversePairCount));
        arr = BaseSort.generateDescOrderedArray(5);
         inversePairCount =pairCount.solve(Arrays.copyOf(arr,arr.length));
        System.out.println(String.format("随机数组%s的的逆序对数量是%s",Arrays.toString(arr),inversePairCount));
        arr = BaseSort.generateIdenticalArray(5);
        inversePairCount =pairCount.solve(Arrays.copyOf(arr,arr.length));
        System.out.println(String.format("随机数组%s的的逆序对数量是%s",Arrays.toString(arr),inversePairCount));

    }
}
