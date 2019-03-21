package cp01._07;

import java.util.LinkedList;

/**
 * 为什么选择用双端队列 ?因为头部要保存最大的,需要pop以及peek操作.尾部要保持最近的,需要push操作
 *
 * 为什么将下标存进去? 因为要计算长度
 *
 * 队列中间的下标要保持连续
 *
 * @author zhangweixiao - 19-3-20
 */
public class MaxWindow {

    private LinkedList<Integer> dequeue = new LinkedList<>();

    public int[] getMaxWindow(int[] arr, int w) {
        dequeue.clear();

        int[] max = new int[arr.length - w + 1];

        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {

            if (dequeue.isEmpty()) {
                dequeue.add(i);
            } else {
                //头部只保持当前最大的
                while (!dequeue.isEmpty() && arr[dequeue.peek()] <= arr[i]) {
                    dequeue.pollLast();
                }
                //尾部保持最新的
                dequeue.add(i);
            }

            if (i - dequeue.peekFirst() >= w) {
                //扔掉超过长度的
                dequeue.pollFirst();
            }
            //从w-1就要开始maxWindow了
            if (i >= w - 1) {
                if (dequeue.size() > w) {
                    dequeue.pollFirst();
                }
                max[maxIndex++] = arr[dequeue.peekFirst()];
            }
        }
        return max;
    }
}
