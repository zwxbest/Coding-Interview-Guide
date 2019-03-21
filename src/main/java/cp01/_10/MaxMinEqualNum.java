package cp01._10;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zwxbest on 2019/3/21.
 */
public class MaxMinEqualNum {

    private Deque<Integer> qmin = new LinkedList<>();
    private Deque<Integer> qmax = new LinkedList<>();

    public int getSubArrayCount(int[] arr, int num) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            for (; j < arr.length; j++) {
                //qmin从头到尾，从小到大
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                //因为j是增大的，必须addLast，这样才能保证顺序
                qmin.addLast(j);
                //qmax从头到尾，从大到小
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }

            //arr[i..j],i在前
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            //所有的子数组都满足要求
            count += j - i;
        }
        return count;
    }
}
