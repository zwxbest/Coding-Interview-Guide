package cp02._06;

import base.BaseTest;
import node.Node;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-27
 */
public class JosephusCircleTest extends BaseTest{

    JosephusCircle josephusCircle = new JosephusCircle();

    @Test
    public void test(){

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head;

        Node node = josephusCircle.josephusKill(head, 2);
        assertEqual(node.value,1);
        assertEqual(node.next,node);
    }

    /**
     * 以1计算
     */
    @Test
    public void test1(){

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head;

        Node node = josephusCircle.josephusKill(head, 1);
        assertEqual(node.value,4);
    }

    /**
     * 以3计算
     */
    @Test
    public void test2(){

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head;

        Node node = josephusCircle.josephusKill(head, 3);
        assertEqual(node.value,1);
    }
}
