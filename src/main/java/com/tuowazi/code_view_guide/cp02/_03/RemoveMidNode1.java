package com.tuowazi.code_view_guide.cp02._03;

import node.Node;

/**
 * @author zhangweixiao - 19-3-25
 */
public class RemoveMidNode1 implements RemoveMidNode {

    @Override
    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        //长度为2,将头节点删除
        if (head.next.next == null) {
            return head.next;
        }
        //从长度为1开始,每增加2个,删除的节点往后挪1个
        //删除节点的上一个节点

        //处理长度>=3的情况
        Node pre = head;
        while (pre.next.next.next != null && pre.next.next.next.next != null) {
            pre = pre.next;
        }

        pre.next = pre.next.next;
        return head;
    }



}
