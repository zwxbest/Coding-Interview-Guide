package com.tuowazi.code_view_guide.cp02._01;

import com.tuowazi.test.BaseTest;
import node.Node;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-22
 */
public class CommonLinkedListTest extends BaseTest {

    /**
     * 两个链表没有共同部分
     */
    @Test
    public void test() {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = new Node(6);

        CommonLinkedList commonLinkedList = new CommonLinkedList();
        Node commonHead = commonLinkedList.getCommonLinkedList(head1, head2);
        assertEqual(commonHead, null);
    }

    /**
     * 两个链表完全相同
     */
    @Test
    public void test1() {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        CommonLinkedList commonLinkedList = new CommonLinkedList();
        Node commonHead = commonLinkedList.getCommonLinkedList(head1, head2);
        assertEqual(commonHead.value, 1);
        assertEqual(commonHead.next.value, 2);
        assertEqual(commonHead.next.next.value, 3);
    }

    /**
     * 两个链表部分相同
     */
    @Test
    public void test2() {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        CommonLinkedList commonLinkedList = new CommonLinkedList();
        Node commonHead = commonLinkedList.getCommonLinkedList(head1, head2);
        assertEqual(commonHead.value, 2);
        assertEqual(commonHead.next.value, 3);
    }
}
