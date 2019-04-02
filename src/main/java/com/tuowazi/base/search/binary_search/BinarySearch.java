package com.tuowazi.base.search.binary_search;

import java.util.Arrays;

public class BinarySearch {

    protected int[] arr;

    // 二分查找法,在有序数组arr中,查找target
    // 如果找到target,返回相应的索引index
    // 如果没有找到target,返回-1
    public  int find(int target) {
        // 在arr[l...r]之中查找target
        int l = 0, r = arr.length - 1;
        while (l <= r) {

            //int mid = (l + r)/2;
            // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
            int mid = l + (r - l) / 2;

            if (arr[mid] == target)
                return mid;
            if (arr[mid] >  target )
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.arr = new int[]{1,3,5,6,9};
        int target = 3;
        System.out.println(String.format("在%s中，%s在第%s个位置", Arrays.toString(binarySearch.arr),target,binarySearch.find(target)));
        System.out.println(String.format("在%s中，%s在第%s个位置", Arrays.toString(binarySearch.arr),target = 0,binarySearch.find(target)));
        System.out.println(String.format("在%s中，%s在第%s个位置", Arrays.toString(binarySearch.arr),target = 4,binarySearch.find(target)));
        System.out.println(String.format("在%s中，%s在第%s个位置", Arrays.toString(binarySearch.arr),target = 10,binarySearch.find(target)));
    }
    public void search(int target){

    }
}
