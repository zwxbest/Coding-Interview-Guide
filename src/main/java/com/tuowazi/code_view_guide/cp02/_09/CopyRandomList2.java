package com.tuowazi.code_view_guide.cp02._09;

import java.util.HashMap;
import java.util.Map;
import node.Node;

/**
 * 复制含有随机指针节点的链表
 *
 * @author zhangweixiao - 19-4-3
 */
public class CopyRandomList2 implements CopyRandomList {

    //l->1'->2->2'->3->3'->null
    @Override
    public RandomNode copyListWithRand(RandomNode head) {
        if (head == null) {
            return null;
        }
        RandomNode cur = head;
        RandomNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomNode(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        //设置rand指针
        //next是副本
        while (cur != null) {
            next = cur.next.next;
            cur.next.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        //拆分两个链表
        RandomNode copyHead = head.next;
        cur = head;
        RandomNode curCopy = null;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            //1->2
            cur.next = next;
            //1'->2'
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return copyHead;
    }
}
