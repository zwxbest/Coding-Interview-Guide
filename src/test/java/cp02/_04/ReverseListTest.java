package cp02._04;

import base.BaseTest;
import cp02.node.Node;
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
}
