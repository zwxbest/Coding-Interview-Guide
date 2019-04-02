package com.tuowazi.code_view_guide.cp02._05;

import base.BaseTest;
import node.Node;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-27
 */
public class ReversePartListTest extends BaseTest {

    private ReversePartList reversePartList = new ReversePartList();

    @Test
    public void test() {

        Node head = reversePartList.reversePart(null, 1, 10);
        assertEqual(head, null);
    }

    /**
     * 长度超限
     */
    @Test
    public void test1() {
        Node head = new Node(1);
        Node node = reversePartList.reversePart(head, 1, 2);
        assertEqual(node, head);
    }

    /**
     * 长度不合法
     */
    @Test
    public void test2() {
        Node head = new Node(1);
        Node node = reversePartList.reversePart(head, 2, 1);
        assertEqual(node, head);
    }

    /**
     * 长度不合法
     */
    @Test
    public void test3() {
        Node head = new Node(1);
        Node node = reversePartList.reversePart(head, 0, 1);
        assertEqual(node, head);
    }

    /**
     * 逆转中间部分
     */
    @Test
    public void test4() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head = reversePartList.reversePart(head, 2, 3);
        assertEqual(head.value,1 );
        assertEqual(head.next.value,3);
        assertEqual(head.next.next.value,2);
        assertEqual(head.next.next.next.value,4);
    }

    /**
     * 从开头逆转到中间
     */
    @Test
    public void test5() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head = reversePartList.reversePart(head, 1, 3);
        assertEqual(head.value,3 );
        assertEqual(head.next.value,2);
        assertEqual(head.next.next.value,1);
        assertEqual(head.next.next.next.value,4);
    }

    /**
     * 从中间逆转到结尾
     */
    @Test
    public void test6() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head = reversePartList.reversePart(head, 2, 4);
        assertEqual(head.value,1 );
        assertEqual(head.next.value,4);
        assertEqual(head.next.next.value,3);
        assertEqual(head.next.next.next.value,2);
    }
}
