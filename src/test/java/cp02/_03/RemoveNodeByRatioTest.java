package cp02._03;

import base.BaseTest;
import node.Node;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-25
 */
public class RemoveNodeByRatioTest extends BaseTest {

    private RemoveNodeByRatio removeNodeByRatio = new RemoveNodeByRatio();

    /**
     * 按照比例删除-null
     */
    @Test
    public void test1(){
        Node node = removeNodeByRatio.removeNodeByRatio(null,1,3);
        assertEqual(node, null);
    }

    /**
     * 1个节点,删除掉
     */
    @Test
    public void test2(){
        Node head = new Node(1);
        Node node = removeNodeByRatio.removeNodeByRatio(head,1,3);
        assertEqual(node, null);
    }

    /**
     * 3个节点,删除第2/5个,也就是第2个
     */
    @Test
    public void test3() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node node = removeNodeByRatio.removeNodeByRatio(head, 2, 5);
        assertEqual(node.value, 1);
        assertEqual(node.next.value,3);
    }

    /**
     * 四个节点,删除第2/3个,也就是2.4
     */
    @Test
    public void test4() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node node = removeNodeByRatio.removeNodeByRatio(head, 2, 3);
        assertEqual(node.value, 1);
        assertEqual(node.next.value,2);
        assertEqual(node.next.next.value,4);
    }
}
