package com.tuowazi.code_view_guide.cp03._01;

import com.tuowazi.code_view_guide.cp03._01.TreeReverse;
import com.tuowazi.test.BaseTest;
import node.BiNode;
import org.junit.Test;

/**
 * @author zhangweixiao
 */
public class TreeReverseTest  extends BaseTest{

    public TreeReverse treeReverse = new TreeReverse();

    //     1
    //    /\
    //   2  3
    //   /   \
    //  4      5


    //前序
    @Test
    public void test(){

        BiNode head = new BiNode(1);
        head.left = new BiNode(2);
        head.right = new BiNode(3);
        head.left.left = new BiNode(4);
        head.right.right = new BiNode(5);
        assertEqual(treeReverse.preOrderRecur(head),"1,2,4,3,5,");
    }

    //中序
    @Test
    public void test1(){
        BiNode head = new BiNode(1);
        head.left = new BiNode(2);
        head.right = new BiNode(3);
        head.left.left = new BiNode(4);
        head.right.right = new BiNode(5);
        assertEqual(treeReverse.inOrderRecur(head),"2,4,1,3,5,");
    }

    /**
     * 后序遍历
     */
    @Test
    public void test2(){
        BiNode head = new BiNode(1);
        head.left = new BiNode(2);
        head.right = new BiNode(3);
        head.left.left = new BiNode(4);
        head.right.right = new BiNode(5);
        assertEqual(treeReverse.postOrderRecur(head),"2,4,3,5,1,");
    }
}
