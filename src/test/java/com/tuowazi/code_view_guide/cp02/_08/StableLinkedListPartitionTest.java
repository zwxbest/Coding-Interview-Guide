package com.tuowazi.code_view_guide.cp02._08;

import com.tuowazi.test.BaseTest;
import node.Node;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-4-2
 */
public class StableLinkedListPartitionTest extends BaseTest {

    private   StableLinkedListPartition linkedListPartition = new StableLinkedListPartition() ;


    //没有小
    @Test
    public void test1() {
        Node head = new Node(6);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);

        Node node = linkedListPartition.listPartition(head, 1);
        assertEqual(node.value, 6);
        assertEqual(node.next.value, 2);
        assertEqual(node.next.next.value, 4);
        assertEqual(node.next.next.next.value, 3);
    }

    //没有相等的
    @Test
    public void test2() {
        Node head = new Node(6);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);

        Node node = linkedListPartition.listPartition(head, 5);
        assertEqual(node.value, 2);
        assertEqual(node.next.value, 4);
        assertEqual(node.next.next.value, 3);
        assertEqual(node.next.next.next.value, 6);
    }

    //没有大于的
    @Test
    public void test3() {
        Node head = new Node(6);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);

        Node node = linkedListPartition.listPartition(head, 7);
        assertEqual(node.value, 6);
        assertEqual(node.next.value, 2);
        assertEqual(node.next.next.value, 4);
        assertEqual(node.next.next.next.value, 3);
    }
}
