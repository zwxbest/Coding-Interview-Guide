package cp01._10;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zwxbest on 2019/3/21.
 */
public class MaxMinSubArrayCount {

    private Deque<Integer> qmin = new LinkedList<>();
    private Deque<Integer> qmax = new LinkedList<>();


    /**
     * 上述过程中，所有的下标值最多进qmax和qmin—次，出qmax和qmin—次。i和j的值也不断增加，并且从来不减小。所以整个过程的时间复杂度为 O(N)
     */
    public int getSubArrayCount(int[] arr, int num) {

        qmin.clear();
        qmax.clear();

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int i = 0;
        //把j放在外面是技巧,因为qmin和qmax第一遍就已经保存所有结果了
        int j = 0;
        int count = 0;
        for (; i < arr.length; i++) {
            for (; j < arr.length; j++) {
                //qmin从头到尾，从小到大
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                //必须last,比如arr[1..5] 1 2 3 4 5,如果只保存1,那么i遍历到2,1被pop走,数据就不对了
                qmin.addLast(j);
                //qmax从头到尾，从大到小
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
            }
            //arr[i..j],i在前
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            //每次遍历完j再计算,比如1 2 3 4 5,不能1-4计算一次,1-5计算1次
            //所有的子数组都满足要求
            //j会超过最大下表,比如 1 2 3 4 5,一开始j4i0,后来j5i1,j5i2
            count += j - i;
        }
        return count;
    }
}
