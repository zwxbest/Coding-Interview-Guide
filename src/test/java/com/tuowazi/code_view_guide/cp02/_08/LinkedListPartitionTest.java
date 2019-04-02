package com.tuowazi.code_view_guide.cp02._08;

import com.tuowazi.test.BaseTest;
import node.Node;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-4-2
 */
public class LinkedListPartitionTest extends BaseTest {

    private   LinkedListPartition linkedListPartition = new LinkedListPartition() ;


    //没有小
    @Test
    public void test1() {
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);

        Node node = linkedListPartition.listPartition(head, 1);
        assertEqual(node.next.next.next.next, null);
    }

    //没有相等的
    @Test
    public void test2() {
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(6);

        Node node = linkedListPartition.listPartition(head, 3);
        assertEqual(node.next.next.next.next, null);
    }

    //没有大于的
    @Test
    public void test3() {
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);

        Node node = linkedListPartition.listPartition(head, 6);
        assertEqual(node.next.next.next.next, null);
    }
}
