package com.tuowazi.base.code_view_guide.cp01._08;

import base.BaseTest;
import org.junit.Test;

/**
 * 和搜索二叉树的区别是没有规定左边小右边大 中序遍历可得到原数组
 *
 * @author zhangweixiao - 19-3-19
 */
public class MaxTreeTest extends BaseTest {


    private MaxTree maxTree = new MaxTree();

    /**
     * 正序
     */
    @Test
    public void test() {

        Node head = maxTree.getMaxTree(new int[]{1, 2, 3, 4});
        assertEqual(head.value, 4);
        assertEqual(head.left.value, 3);
        assertEqual(head.left.left.value, 2);
        assertEqual(head.left.left.left.value, 1);
    }

    /**
     * 倒序
     */
    @Test
    public void test1() {

        Node head = maxTree.getMaxTree(new int[]{4, 3, 2, 1});
        assertEqual(head.value, 4);
        assertEqual(head.left.value, 3);
        assertEqual(head.left.left.value, 2);
        assertEqual(head.left.left.left.value, 1);
    }

    /**
     * 随机
     */
    @Test
    public void test2() {

        Node head = maxTree.getMaxTree(new int[]{3, 2, 1, 4});
        assertEqual(head.value, 4);
        assertEqual(head.left.value, 3);
        assertEqual(head.left.left.value, 2);
        assertEqual(head.left.left.left.value, 1);
    }
}
