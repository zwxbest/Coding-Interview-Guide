package com.tuowazi.code_view_guide.cp02._04;

import base.BaseTest;
import node.DoubleNode;
import node.Node;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-26
 */
public class ReverseListTest extends BaseTest {

    ReverseList reverseList = new ReverseList();

    @Test
    public void test() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head = reverseList.reverseList(head);
        assertEqual(head.value, 3);
        assertEqual(head.next.value, 2);
        assertEqual(head.next.next.value, 1);
        assertEqual(head.next.next.next, null);
    }

    @Test
    public void test1() {
        Node head = new Node(1);
        head = reverseList.reverseList(head);
        assertEqual(head.value, 1);
        assertEqual(head.next, null);
    }

    @Test
    public void test2() {
        Node head = reverseList.reverseList(null);
        assertEqual(head, null);
    }

    @Test
    public void test3() {
        DoubleNode head = new DoubleNode(1);
        head.next = new DoubleNode(2);
        head.next.last = head;
        head.next.next = new DoubleNode(3);
        head.next.last = head.next;
        head = reverseList.reverseDoubleList(head);
        assertEqual(head.value, 3);
        assertEqual(head.next.value, 2);
        assertEqual(head.next.last.value,3);
        assertEqual(head.next.next.value, 1);
        assertEqual(head.next.next.last.value,2);
        assertEqual(head.next.next.next, null);
    }
}
