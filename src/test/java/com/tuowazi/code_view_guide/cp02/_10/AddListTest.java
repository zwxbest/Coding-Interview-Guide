package com.tuowazi.code_view_guide.cp02._10;

import com.tuowazi.test.BaseTest;
import node.Node;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-4-16
 */
public class AddListTest extends BaseTest {

    protected static AddList addList;

    @Test
    public void test(){

        Node head1 = new Node(1);
        head1.next = new Node(9);

        Node head2 = new Node(8);
        head2.next = new Node(2);
        Node node = addList.addList(head1, head2);

        assertEqual(node.value,1);

        assertEqual(node.next.value,0);

        assertEqual(node.next.next.value,1);
    }
}
