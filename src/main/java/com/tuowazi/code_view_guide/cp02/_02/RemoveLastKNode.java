package com.tuowazi.code_view_guide.cp02._02;

import node.DoubleNode;
import node.Node;

/**
 * 在单链表和双链表中删除倒数第K个节点
 * @author zhangweixiao - 19-3-22
 */
public class RemoveLastKNode {

    public Node removeLastKthNode(Node head,int lastKth){
        if(head == null || lastKth < 1){
            return head;
        }
        Node cur  = head;
        while (cur != null){
            cur = cur.next;
            lastKth --;
        }

        if(lastKth > 0){
          throw new RuntimeException("没有倒数第k个节点");
        } else if(lastKth == 0){
            //头节点就是倒数第几k个节点
            head = head.next;
        }else {
            //链表长度为N,目前lastKth的值为 k-n,倒数第k个节点，即为n-k+1,前面是n-k
            Node cur1 = head;
            for(int i=lastKth+1;i<0;i++){
                cur1  = cur1.next;
            }
            cur1.next  = cur1.next.next;
        }
        return head;
    }

    public DoubleNode removeLastKthNode(DoubleNode head,int lastKth){
        if(head == null || lastKth < 1){
            return head;
        }
        DoubleNode cur  = head;
        while (cur != null){
            cur = cur.next;
            lastKth --;
        }
        if(lastKth > 0){
            throw new RuntimeException("没有倒数第k个节点");
        } else if(lastKth == 0){
            //头节点就是倒数第几k个节点
            head.next.last = null;
            head = head.next;
        }else {
            //链表长度为N,目前lastKth的值为 k-n,倒数第k个节点，即为n-k+1,前面是n-k
            DoubleNode cur1 = head;
            for(int i=lastKth+1;i<0;i++){
                cur1  = cur1.next;
            }
            cur1.next.next.last = cur1;
            cur1.next  = cur1.next.next;
        }
        return head;
    }
}
