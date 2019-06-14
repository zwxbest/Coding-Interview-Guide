package com.tuowazi.code_view_guide.cp03._05;

import com.tuowazi.test.BaseTest;
import node.BiNode;
import org.junit.Test;

/**
 * @author zhangweixiao - 2019/6/14
 */
public class MaxLengthTest extends BaseTest {

    @Test
    public void test(){
        BiNode head = new BiNode(-3);
        head.left = new BiNode(3);
        head.left.left = new BiNode(1);
        head.left.right = new BiNode(0);
        head.left.right.left = new BiNode(1);
        head.left.right.right = new BiNode(6);
        head.right = new BiNode(-9);
        head.right.left = new BiNode(2);
        head.right.right = new BiNode(1);

        MaxLength maxLength = new MaxLength();
        assertEqual(maxLength.getMaxLength(head,6),4);
        assertEqual(maxLength.getMaxLength(head,-9),1);


    }
}
