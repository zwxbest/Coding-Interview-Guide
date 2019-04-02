package com.tuowazi.code_view_guide.cp02._04;

    import node.DoubleNode;
    import node.Node;

/**
 * @author zhangweixiao - 19-3-26
 */
public class ReverseList  {

    public Node reverseList(Node head){
        Node pre = null;
        Node next;
        //每一轮让当前head逆转指向
        while (head != null){
            //保存next
            next = head.next;
            //pre为逆转指向的next
            head.next = pre;
            //更新pre
            pre = head;
            //更新next
            head = next;
        }
        return pre;
    }

    public DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next;
        //每一轮让当前head逆转指向
        while (head != null){
            //保存next
            next = head.next;
            //pre为逆转指向的next
            head.next = pre;
            //逆转last为next
            head.last = next;
            //更新pre
            pre = head;
            //更新next
            head = next;
        }
        return pre;
    }
}
