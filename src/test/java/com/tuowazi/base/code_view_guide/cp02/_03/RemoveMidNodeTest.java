package com.tuowazi.base.code_view_guide.cp02._03;

import base.BaseTest;
import node.Node;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-25
 */
@Ignore
public class RemoveMidNodeTest extends BaseTest {

    protected static RemoveMidNode1 removeMidNode;

    @Test
    public void test() {

        Node node = removeMidNode.removeMidNode(null);
        assertEqual(node, null);
    }

    @Test
    public void test1() {
        Node head = new Node(1);
        Node node = removeMidNode.removeMidNode(head);
        assertEqual(node, head);
    }

    /**
     * 长度为2
     */
    @Test
    public void test2() {
        Node head = new Node(1);
        head.next = new Node(2);
        Node node = removeMidNode.removeMidNode(head);
        assertEqual(node.value, 2);
    }

    /**
     * 长度为3
     */
    @Test
    public void test3() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node node = removeMidNode.removeMidNode(head);
        assertEqual(node.value, 1);
        assertEqual(node.next.value, 3);
    }

    /**
     * 长度为4
     */
    @Test
    public void test4() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node node = removeMidNode.removeMidNode(head);
        assertEqual(node.value, 1);
        assertEqual(node.next.value, 3);
        assertEqual(node.next.next.value, 4);
    }

    /**
     * 长度为5
     */
    @Test
    public void test5() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node node = removeMidNode.removeMidNode(head);
        assertEqual(node.value, 1);
        assertEqual(node.next.value, 2);
        assertEqual(node.next.next.value, 4);
        assertEqual(node.next.next.next.value, 5);
    }


}
