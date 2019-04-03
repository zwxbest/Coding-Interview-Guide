package com.tuowazi.code_view_guide.cp02._09;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制含有随机指针节点的链表
 *
 * @author zhangweixiao - 19-4-3
 */
public class CopyRandomList1 implements CopyRandomList {

    @Override
    public RandomNode copyListWithRand(RandomNode head) {
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomNode(cur.value));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }
}
