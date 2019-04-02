package com.tuowazi.base.sort;

import java.util.Arrays;

/**
 * @author zhangweixiao
 */
public class BaseSort {

    protected long swapTimes = 0;
    protected long compareTimes = 0;
    //赋值次数
    protected long assignTimes = 0;

    public static int COUNT = 1_0000;
    public static int[] RANDOM_ARRAY;

    //不同算法进行比较时，保证数据一样
    //asc，desc和same的数据由count保证一样
    //random也要保证一样
    private int[] getRandomArray(){
        if(RANDOM_ARRAY == null){
            RANDOM_ARRAY =  generateRandomArray(getCount());
        }
        return Arrays.copyOf(RANDOM_ARRAY,RANDOM_ARRAY.length);
    }

    protected int getCount() {
        return COUNT;
    }

    /**
     * 生成有n个元素的随机数组
     */
    public static int[] generateRandomArray(int n) {

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (n + 1));
        }
        return arr;
    }

    protected  void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        swapTimes++;
    }


    /**
     * 降序数组
     */
    public static int[] generateDescOrderedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }


    /**
     * 升序数组
     */
    public static int[] generateAscOrderedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 相同数据的数组
     */
    public static int[] generateIdenticalArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 44;
        }
        return arr;
    }

    protected void sort(int[] arr) {
    }


    /**
     * 先验证排序算法的正确性，再测试性能
     */
    private void checkValid(){
        int[] arrSorted = new int[]{1,2,3,4};
        //随机
        int[] arr = new int[]{3,2,1,4};
        sort(arr);
        arrEqual(arr,arrSorted);
        //升序
        arr = new int[]{1,2,3,4};
        sort(arr);
        arrEqual(arr,arrSorted);
        //降序
        arr = new int[]{4,3,2,1};
        sort(arr);
        arrEqual(arr,arrSorted);
        //相等
        arr = new int[]{2,2,2,2};
        sort(arr);
        arrEqual(arr,new int[]{2,2,2,2});
    }

    protected void arrEqual(int[] arr1,int[] arr2){
        if(arr1.length!=arr2.length){
            throw new RuntimeException("排序算法错误");
        }
        for (int i= 0 ;i < arr1.length;i++) {
            if(arr1[i]!=arr2[i]){
                throw new RuntimeException("排序算法错误");
            }
        }
    }

    protected String getName(){
        return  "";
    }

    protected void sort() {
        checkValid();
        System.out.println(String.format("在%s中，排序%s个数",getName(),splitNum(getCount()) ));
        swapTimes  = assignTimes = compareTimes = 0;
        long beforeTime = System.currentTimeMillis();
        sort(getRandomArray());
        long afterTime = System.currentTimeMillis();
        System.out.println(String.format("随机数组用时%s秒，比较%s次，赋值%s次,交换%s次,共赋值%s次",(afterTime - beforeTime)/1000f,splitNum(compareTimes),splitNum(assignTimes),splitNum(swapTimes),splitNum(swapTimes*3+assignTimes)));
        beforeTime = System.currentTimeMillis();
        swapTimes  = assignTimes = compareTimes = 0;
        sort(generateAscOrderedArray(getCount()));
        afterTime = System.currentTimeMillis();
        System.out.println(String.format("升序数组用时%s秒，比较%s次，赋值%s次,交换%s次,共赋值%s次",(afterTime - beforeTime)/1000f,splitNum(compareTimes),splitNum(assignTimes),splitNum(swapTimes),splitNum(swapTimes*3+assignTimes)));
        beforeTime = System.currentTimeMillis();
        swapTimes  = assignTimes = compareTimes = 0;
        sort(generateDescOrderedArray(getCount()));
        afterTime = System.currentTimeMillis();
        System.out.println(String.format("降序数组用时%s秒，比较%s次，赋值%s次,交换%s次,共赋值%s次",(afterTime - beforeTime)/1000f,splitNum(compareTimes),splitNum(assignTimes),splitNum(swapTimes),splitNum(swapTimes*3+assignTimes)));
        beforeTime = System.currentTimeMillis();
        swapTimes  = assignTimes = compareTimes = 0;
        sort(generateIdenticalArray(getCount()));
        afterTime = System.currentTimeMillis();
        System.out.println(String.format("相同数组用时%s秒，比较%s次，赋值%s次,交换%s次,共赋值%s次",(afterTime - beforeTime)/1000f,splitNum(compareTimes),splitNum(assignTimes),splitNum(swapTimes),splitNum(swapTimes*3+assignTimes)));
    }

    /**
     * 分割展示，四个一组
     * @param num
     * @return
     */
    private static String splitNum(long num){
        StringBuilder sb = new StringBuilder();
        char[] numChars = String.valueOf(num).toCharArray();
        int len = numChars.length;
        for(int i = 0;i< len;i++){
            if(i!=0 && (len-i)%4==0){
                sb.append("_");
            }
            sb.append(numChars[i]);
        }
        return sb.toString();
    }

 }
