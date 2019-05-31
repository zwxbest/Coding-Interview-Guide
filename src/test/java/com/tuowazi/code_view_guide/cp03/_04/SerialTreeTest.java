package com.tuowazi.code_view_guide.cp03._04;

import com.tuowazi.test.BaseTest;
import node.BiNode;
import org.junit.Test;

/**
 * @author zhangweixiao - 2019/5/31
 */
public class SerialTreeTest extends BaseTest {

    @Test
    public void test() {
        BiNode head = new BiNode(12);
        head.left = new BiNode(3);
        SerialTree serialTree = new SerialTree();
        String s = serialTree.serialByPre(head);
        assertEqual(s, "12!3!#!#!#!");
        BiNode node = serialTree.reconByPreString(s);
        assertEqual(node.value, 12);
        assertEqual(node.left.value, 3);
        assertEqual(node.left.left, null);
        assertEqual(node.left.right, null);

        String s1 = serialTree.serialByLevel(head);
        BiNode node1 = serialTree.reconByLevelString(s1);
        assertEqual(node1.value, 12);
        assertEqual(node1.left.value, 3);
        assertEqual(node1.left.left, null);
        assertEqual(node1.left.right, null);
    }

    @Test
    public void test1() {
        BiNode head = new BiNode(1);
        head.left = new BiNode(2);
        head.left.left = new BiNode(4);
        head.right = new BiNode(3);
        head.right.right = new BiNode(5);
        SerialTree serialTree = new SerialTree();
        String s1 = serialTree.serialByLevel(head);
        BiNode node1 = serialTree.reconByLevelString(s1);
        assertEqual(node1.value, 1);
        assertEqual(node1.left.value, 2);
        assertEqual(node1.left.left.value, 4);
        assertEqual(node1.right.value, 3);
        assertEqual(node1.right.right.value,5);
    }
}
