package com.tuowazi.base.search.binary_search.wrong;

import java.util.Arrays;

/**
 * todo:-Xmx5120m -XX:+PrintCommandLineFlags
 * 错误的写法
 */
public class WrongBinarySearch {

    protected int[] arr;

    // 二分查找法,在有序数组arr中,查找target
    // 如果找到target,返回相应的索引index
    // 如果没有找到target,返回-1
    public  int find(int target) {
        // 在arr[left...right]之中查找target
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            //fixme:会整型溢出
            int mid = (left + right)/2;
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
        WrongBinarySearch binarySearch = new WrongBinarySearch();
        //Integer.MAX_VALUE/2+3 = 1_073_741_823+3 = 1_073_741_826
        binarySearch.arr = new int[1_073_741_826];
        //1_073_741_824+1_073_741_825 =2147483649，溢出
        //需要空间4b*1073741826 = 4294967304,至少4G多
        binarySearch.arr[1_073_741_825] = 1;
        int target = 1;
        System.out.println(String.format("在%s中，%s在第%s个位置", Arrays.toString(binarySearch.arr),target,binarySearch.find(target)));
    }
}
