package com.tuowazi.base.search.floor_ceil;

import java.util.Arrays;

public class FloorCeilBinarySearch {

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

     int floor(int target) {

        // 寻找比target小的最大索引
        int left = -1, right = arr.length - 1;
        while (left < right) {
            // 使用向上取整避免死循环
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] >= target)
                right = mid - 1;
            else
                left = mid;
        }

        assert left == right;

        // 如果该索引+1就是target本身, 该索引+1即为返回值
        if (left + 1 < arr.length && arr[left + 1] == target)
            return left + 1;

        // 否则, 该索引即为返回值
        return left;
    }

    // 二分查找法, 在有序数组arr中, 查找target
    // 如果找到target, 返回最后一个target相应的索引index
    // 如果没有找到target, 返回比target大的最小值相应的索引, 如果这个最小值有多个, 返回最小的索引
    // 如果这个target比整个数组的最大元素值还要大, 则不存在这个target的ceil值, 返回整个数组元素个数n
     int ceil(int target) {

        // 寻找比target大的最小索引值
        int l = 0, r = arr.length;
        while (l < r) {
            // 使用普通的向下取整即可避免死循环
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target)
                l = mid + 1;
            else // arr[mid] > target
                r = mid;
        }

        assert l == r;

        // 如果该索引-1就是target本身, 该索引+1即为返回值
        if (r - 1 >= 0 && arr[r - 1] == target)
            return r - 1;

        // 否则, 该索引即为返回值
        return r;
    }

    public static void main(String[] args) {
        FloorCeilBinarySearch binarySearch = new FloorCeilBinarySearch();
        binarySearch.arr = new int[]{1,3,5,6,9};
        int target = 3;
        System.out.println(String.format("在%s中，%s的floor在第%s个位置,ceil在第%s个位置", Arrays.toString(binarySearch.arr),target,binarySearch.floor(target),binarySearch.ceil(target)));
        System.out.println(String.format("在%s中，%s的floor在第%s个位置,ceil在第%s个位置", Arrays.toString(binarySearch.arr),target,binarySearch.floor(target),binarySearch.ceil(target)));
        System.out.println(String.format("在%s中，%s的floor在第%s个位置,ceil在第%s个位置", Arrays.toString(binarySearch.arr),target,binarySearch.floor(target),binarySearch.ceil(target)));
        System.out.println(String.format("在%s中，%s的floor在第%s个位置,ceil在第%s个位置", Arrays.toString(binarySearch.arr),target,binarySearch.floor(target),binarySearch.ceil(target)));
    }
    public void search(int target){

    }
}
