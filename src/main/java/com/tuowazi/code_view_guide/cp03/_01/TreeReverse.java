package com.tuowazi.code_view_guide.cp03._01;

import node.BiNode;
import node.Node;

/**
 * @author zhangweixiao
 */
public class TreeReverse {


    public String preOrderRecur(BiNode head) {
        if (head == null) {
            return "";
        }
        String ret = head.value + ",";
        ret += preOrderRecur(head.left);
        ret += preOrderRecur(head.right);
        return ret;
    }

    public String inOrderRecur(BiNode head) {
        if (head == null) {
            return "";
        }
        String ret = "";
        ret += preOrderRecur(head.left);
        ret += head.value + ",";
        ret += preOrderRecur(head.right);
        return ret;
    }

    public String postOrderRecur(BiNode head) {
        if (head == null) {
            return "";
        }
        String ret = "";
        ret += preOrderRecur(head.left);
        ret += preOrderRecur(head.right);
        ret += head.value + ",";
        return ret;
    }
}
