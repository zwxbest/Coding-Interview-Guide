package com.tuowazi.code_view_guide.cp02._02;

import com.tuowazi.test.BaseTest;
import node.Node;
import org.junit.Test;

public class RemoveLastKNodeOrderTest extends BaseTest {

    RemoveLastKNode removeLastKNode = new RemoveLastKNode();

    /**
     * 倒数第k个是头
     */
    @Test
    public void test(){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node node = removeLastKNode.removeLastKthNode(head, 3);
        assertEqual(node.value,2);
        assertEqual(node.next.value,3);
    }


    /**
     * 没有倒数第k个
     */
    @Test
    public void test1(){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        thrown.expectMessage("没有倒数第k个节点");
        Node node = removeLastKNode.removeLastKthNode(head, 4);
    }

    /**
     * 有倒数第k个
     */
    @Test
    public void test2(){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node node = removeLastKNode.removeLastKthNode(head, 2);
        assertEqual(node.value,1);
        assertEqual(node.next.value,3);
    }
}
