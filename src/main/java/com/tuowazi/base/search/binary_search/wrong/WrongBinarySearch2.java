package com.tuowazi.base.search.binary_search.wrong;

import java.util.Arrays;

/**
 * todo:-Xmx5120m -XX:+PrintCommandLineFlags
 * 错误的写法
 */
public class WrongBinarySearch2 {

    protected int[] arr;

    // 二分查找法,在有序数组arr中,查找target
    // 如果找到target,返回相应的索引index
    // 如果没有找到target,返回-1
    public  int find(int target) {
        // 在arr[left...right]之中查找target
        int left = 0, right = arr.length - 1;
        //fixme:没有=会漏掉每个right，因为/2是floor操作
        while (left < right) {
            int mid = left + (right - left) / 2;
            assert mid > 0;

            if (arr[mid] == target)
                return mid;
            if (arr[mid] >  target )
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        WrongBinarySearch2 binarySearch = new WrongBinarySearch2();
        binarySearch.arr = new int[]{1,3,5,8,10};
        int target = 1;
        System.out.println(String.format("在%s中，%s在第%s个位置", Arrays.toString(binarySearch.arr),target,binarySearch.find(target)));
        System.out.println(String.format("在%s中，%s在第%s个位置", Arrays.toString(binarySearch.arr),target = 10,binarySearch.find(target)));
        System.out.println(String.format("在%s中，%s在第%s个位置", Arrays.toString(binarySearch.arr),target = 3,binarySearch.find(target)));


    }
}
