package com.tuowazi.code_view_guide.cp03._02;

import node.BiNode;

/**
 * @author zhangweixiao - 2019/5/29
 */
public class PrintEdge2 {

    public String printEdge2(BiNode head){
        String retStr = "";
        if(head == null){
            return retStr;
        }
        retStr += head.value+" ";
        if (head.left != null && head.right != null) {
            //深度遍历，先打印左边，再打印右边
            retStr += printLeftEdge(head.left,true);
            retStr += printRightEdge(head.right,true);
        } else {
            //左右子树又一个空的
            retStr += printEdge2(head.left != null ? head.left : head.right);
        }
        return  retStr;
    }

    private String printLeftEdge(BiNode node,boolean traverse){
        String retStr = "";
        if(node == null){
            return retStr;
        }
        if(traverse || (node.left == null && node.right == null)){
            retStr+=node.value+" ";
        }
        retStr += printLeftEdge(node.left, traverse);
        //当左子树木为空时，才打印右子树
        retStr += printLeftEdge(node.right, traverse && node.left == null);
        return retStr;
    }

    private String printRightEdge(BiNode node,boolean traverse){
        String retStr = "";
        if(node == null){
            return retStr;
        }
        retStr +=printRightEdge(node.left,traverse && node.right== null);
        retStr +=printRightEdge(node.right,traverse);
        //后序
        if(traverse || (node.left == null && node.right == null)){
            retStr+=node.value+" ";
        }
        return retStr;
    }
}
