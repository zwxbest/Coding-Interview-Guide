package com.tuowazi.code_view_guide.cp02._09;

import com.tuowazi.test.BaseTest;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-4-3
 */
public class CopyRandomListTest extends BaseTest {

    protected static CopyRandomList copyRandomList;

    @Test
    public void test(){
        RandomNode head = new RandomNode(1);
        RandomNode node1 = new RandomNode(2);
        RandomNode node2 = new RandomNode(3);
        head.next = node1;
        node1.next = node2;
        head.rand = node2;
        node2.rand = node1;

        RandomNode randomHead = copyRandomList.copyListWithRand(head);
        assertEqual(randomHead.next.value,node1.value);
        assertEqual(randomHead.next.next.value,node2.value);
        assertEqual(randomHead.rand.value,node2.value);
        assertEqual(randomHead.rand.rand.value,node1.value);

    }
}
