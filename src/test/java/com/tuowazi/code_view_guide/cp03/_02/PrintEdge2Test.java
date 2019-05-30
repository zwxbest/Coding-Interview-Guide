package com.tuowazi.code_view_guide.cp03._02;

import node.BiNode;
import org.junit.Test;

/**
 * @author zhangweixiao - 2019/5/28
 */
public class PrintEdge2Test {

    @Test
    public void test() {
        BiNode head = new BiNode(1);
        head.left = new BiNode(2);
        head.right = new BiNode(3);

        head.left.right = new BiNode(4);

        head.right.left = new BiNode(5);
        head.right.right = new BiNode(6);

        head.left.right.left = new BiNode(7);
        head.left.right.right = new BiNode(8);

        head.right.left.left = new BiNode(9);
        head.right.left.right = new BiNode(10);

        head.left.right.right.right = new BiNode(11);

        head.right.left.left.left = new BiNode(12);

        head.left.right.right.right.left = new BiNode(13);
        head.left.right.right.right.right = new BiNode(14);

        head.right.left.left.left.left = new BiNode(15);
        head.right.left.left.left.right = new BiNode(16);

        PrintEdge2 printEdge = new PrintEdge2();
        String s = printEdge.printEdge2(head);
        System.out.println("边界节点");
        System.out.println(s);

    }
}
