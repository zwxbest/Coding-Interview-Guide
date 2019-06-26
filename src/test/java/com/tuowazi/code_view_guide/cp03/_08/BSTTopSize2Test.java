package com.tuowazi.code_view_guide.cp03._08;

import com.tuowazi.code_view_guide.cp03._09.BSTTopSize2;
import com.tuowazi.test.BaseTest;
import node.BiNode;
import org.junit.Test;

/**
 * @author zhangweixiao - 2019/6/26
 */
public class BSTTopSize2Test extends BaseTest {

    @Test
    public void test1(){
        BiNode head = new BiNode(6);
        head.left = new BiNode(1);
        head.left.left = new BiNode(0);
        head.left.right = new BiNode(3);
        head.right = new BiNode(12);
        head.right.left = new BiNode(10);
        head.right.left.left = new BiNode(4);
        head.right.left.left.left = new BiNode(2);
        head.right.left.left.right = new BiNode(5);
        head.right.left.right = new BiNode(14);
        head.right.left.right.left = new BiNode(11);
        head.right.left.right.right=new BiNode(15);
        head.right.right= new BiNode(13);
        head.right.right.left = new BiNode(20);
        head.right.right.right = new BiNode(16);
        BSTTopSize2 bstTopSize = new BSTTopSize2();
        assertEqual(bstTopSize.getBstTopSize2(head),8);
    }
}
