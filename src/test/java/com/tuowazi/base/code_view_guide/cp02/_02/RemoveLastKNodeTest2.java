package com.tuowazi.base.code_view_guide.cp02._02;

import base.BaseTest;
import node.DoubleNode;
import org.junit.Test;

public class RemoveLastKNodeTest2 extends BaseTest {

    RemoveLastKNode removeLastKNode = new RemoveLastKNode();



    /**
     * 倒数第k个是头
     */
    @Test
    public void test(){
        DoubleNode head = new DoubleNode(1);
        head.next = new DoubleNode(2);
        head.next.last = head;
        head.next.next = new DoubleNode(3);
        head.next.next.last = head.next;
        DoubleNode node = removeLastKNode.removeLastKthNode(head, 3);
        assertEqual(node.value,2);
        assertEqual(node.last,null);
        assertEqual(node.next.value,3);
    }


    /**
     * 没有倒数第k个
     */
    @Test
    public void test1(){
        DoubleNode head = new DoubleNode(1);
        head.next = new DoubleNode(2);
        head.next.last = head;
        head.next.next = new DoubleNode(3);
        head.next.next.last = head.next;
        thrown.expectMessage("没有倒数第k个节点");
        DoubleNode node = removeLastKNode.removeLastKthNode(head, 4);
    }

    /**
     * 有倒数第k个
     */
    @Test
    public void test2(){
        DoubleNode head = new DoubleNode(1);
        head.next = new DoubleNode(2);
        head.next.last = head;
        head.next.next = new DoubleNode(3);
        head.next.next.last = head.next;
        DoubleNode node = removeLastKNode.removeLastKthNode(head, 2);
        assertEqual(node.value,1);
        assertEqual(node.next.last.value,1);
        assertEqual(node.next.value,3);
    }
}
