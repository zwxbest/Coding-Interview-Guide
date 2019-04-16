package com.tuowazi.code_view_guide.cp02._10;

import java.util.Stack;
import node.Node;

/**
 * 利用链表的逆序求解，可以省掉用栈的空间。
 *
 * @author zhangweixiao - 19-4-16
 */
public class AddList2 implements AddList {

    public Node addList(Node head1, Node head2) {
        head1 = reverseNode(head1);
        head2 = reverseNode(head2);
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node c1 = head1;
        Node c2 = head2;

        Node node = null;
        Node pre = null;

        while (c1 != null || c2 != null) {
            n1 = c1 != null ? c1.value : 0;
            n2 = c2 != null ? c2.value : 0;
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }

        if(ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        reverseNode(head1);
        reverseNode(head2);
        return node;
    }

    public Node reverseNode(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
