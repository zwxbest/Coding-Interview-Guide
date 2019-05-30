package com.tuowazi.code_view_guide.cp03._03;

import node.BiNode;
import org.junit.Test;

/**
 * @author zhangweixiao - 2019/5/30
 */
public class PrintBinaryTreee {

    @Test
    public void test(){
        BiNode head= new BiNode(1);
        head.left = new BiNode(2);
        head.left.left = new BiNode(4);
        head.left.right = new BiNode(7);

        head.right = new BiNode(3);
        head.right.left= new BiNode(5);
        head.right.right = new BiNode(6);
        PrintBiTree printBiTree =new PrintBiTree();
        printBiTree.printTree(head);
    }
}
