package com.tuowazi.base.sort.quick.extend;

import com.tuowazi.base.sort.AdvanceSort;
import java.util.Arrays;

/**
 第n小的元素，时间复杂度O(n)

 */
public class TheSmallN extends AdvanceSort {

    private int theSmallN = 0;

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    // partition 过程, 和快排的partition一样
    // 思考: 双路快排和三路快排的思想能不能用在selection算法中? :)
    private  int partition(int[] arr, int left, int right) {
        //left定义为枢轴
        int v = arr[left];
        //partition用来记录小于v和大于v的分界点
        int partition = left; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = left + 1; i <= right; i++) {
            //遍历的点比partition的值小
            compareTimes++;
            if (arr[i] < v) {
                //小于枢轴点的元素放在左侧
                //枢轴的位置是变得，但是值是不变的
                partition++;
                //index小于partition的肯定在比v小
                swap(arr, partition, i);
            }
        }
        //最后parition所在位置的左边都是比v小的
        //将枢轴点放到该在的位置，这样小于枢轴点的就在左侧了
        if (left != partition) {
            swap(arr, left, partition);
        }
        //返回枢轴的位置
        return partition;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private int  getBigN(int[] arr, int l, int r) {
        //l==r也return
        if (l == r) {
            return arr[l];
        }
        int p = partition(arr, l, r);
        if(p ==  theSmallN -1){
            return arr[p];
        }else if (p < theSmallN -1 ){
            return getBigN(arr, p + 1, r);
        }else {
            return   getBigN(arr, l, p - 1);
        }
    }

    public int getSmallN(int[] arr) {
        int n = arr.length;
        if(theSmallN < 1 || theSmallN > n){
            throw new RuntimeException("n应该大于等于1，小于等于"+n);
        }
        int bigN = getBigN(arr, 0, n - 1);
        return bigN;
    }

    public static void main(String[] args) {
        TheSmallN theSmallN = new TheSmallN();
        theSmallN.theSmallN = 4;
        int[] arr = new int[]{3,6,2,9,1};
        System.out.println(String.format("在%s中，第%s小的数字是%s", Arrays.toString(arr),theSmallN.theSmallN,theSmallN.getSmallN(arr)));;
        arr = new int[]{1,2,3,6,9};
        System.out.println(String.format("在%s中，第%s小的数字是%s", Arrays.toString(arr),theSmallN.theSmallN,theSmallN.getSmallN(arr)));
        arr = new int[]{9,6,3,2,1};
        System.out.println(String.format("在%s中，第%s小的数字是%s", Arrays.toString(arr),theSmallN.theSmallN,theSmallN.getSmallN(arr)));
        arr = new int[]{6,6,6,6,6};
        System.out.println(String.format("在%s中，第%s小的数字是%s", Arrays.toString(arr),theSmallN.theSmallN,theSmallN.getSmallN(arr)));
    }
}
