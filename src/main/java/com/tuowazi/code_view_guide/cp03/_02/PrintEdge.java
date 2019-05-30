package com.tuowazi.code_view_guide.cp03._02;

import node.BiNode;

/**
 * @author zhangweixiao
 */
public class PrintEdge {

    public String printEdge(BiNode head) {
        String retStr = "";
        if (head == null) {
            return retStr;
        }
        int height = getHeight(head, 0);
        //每行最多有两个边界
        BiNode[][] edgeMap = new BiNode[height][2];
        setEdgeMap(head, 0, edgeMap);
        //打印左边界
        for (int i = 0; i < edgeMap.length; i++) {
            retStr += edgeMap[i][0].value+ " ";
        }
        //打印不是左边界也不是有边界的叶子节点
        retStr+=printLeafNotInMap(head,0,edgeMap);

        //打印右边界，但不是左边界的节点
        for (int i = edgeMap.length -1 ; i > 0; i--) {
            if(edgeMap[i][0]!=edgeMap[i][1]){
                retStr+=edgeMap[i][1].value+" ";
            }
        }
        return  retStr;
    }

    /**
     * 树的高度
     */
    private int getHeight(BiNode h, int height) {
        if (h == null) {
            return height;
        }
        return Math.max(getHeight(h.left, height + 1), getHeight(h.right, height + 1));
    }

    private void setEdgeMap(BiNode node, int height, BiNode[][] edgeMap) {
        if (node == null) {
            return;
        }
        //第一个和第二个可能是一样的
        if (edgeMap[height][0] == null) {
            edgeMap[height][0] = node;
        }
        edgeMap[height][1] = node;
        setEdgeMap(node.left, height + 1, edgeMap);
        setEdgeMap(node.right, height + 1, edgeMap);
    }

    //打印不是左边界也不是有边界的叶子节点
    private String printLeafNotInMap(BiNode node, int height, BiNode[][] edgeMap) {
        String retStr = "";
        if (node == null) {
            return retStr;
        }
        if (node.left == null && node.right == null && node != edgeMap[height][0]
            && node != edgeMap[height][1]) {
            retStr += node.value + " ";
        }
        retStr+=printLeafNotInMap(node.left, height + 1, edgeMap);
        retStr+=printLeafNotInMap(node.right, height + 1, edgeMap);
        return retStr;
    }
}
