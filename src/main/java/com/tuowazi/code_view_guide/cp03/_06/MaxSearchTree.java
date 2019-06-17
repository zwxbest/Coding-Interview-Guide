package com.tuowazi.code_view_guide.cp03._06;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import node.BiNode;
import node.Node;

/**
 * @author zhangweixiao - 2019/6/14
 */
public class MaxSearchTree {

    public BiNode biggestSubBST(BiNode head) {
        int[] record = new int[3];
        return posOrder(head,record);
    }

    private BiNode posOrder(BiNode head, int[] record) {
        if (head == null) {
            //0
            record[0] = 0;
            //1存最小值
            record[1] = Integer.MAX_VALUE;
            //2存最大值
            record[2] = Integer.MIN_VALUE;
            return null;
        }
        int value = head.value;
        BiNode left = head.left;
        BiNode right = head.right;
        //左子树的最大搜索树的头
        BiNode lBST = posOrder(left, record);
        //节点数
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];
        BiNode rBST = posOrder(right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        record[1] = Math.min(lMin, value);
        record[2] = Math.max(rMax, value);

        if (left == lBST && right == rBST && lMax < value && value < rMin) {
            record[0] = lSize + rSize + 1;
            return head;
        }
        record[0] = Math.max(lSize, rSize);
        return lSize > rSize ? lBST : rBST;
    }
}
