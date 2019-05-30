package com.tuowazi.code_view_guide.cp03._03;

import com.google.errorprone.annotations.Var;
import java.awt.HeadlessException;
import node.BiNode;
import node.Node;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangweixiao - 2019/5/30
 */
public class PrintBiTree {

    public void printTree(BiNode head) {
        System.out.println("Print Binary Tree");
        PrintInOrder(head, 0, "H", 17);
    }

    private void PrintInOrder(BiNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        //先打印right
        PrintInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        val = StringUtils.leftPad(val, (height * len - val.length()) / 2, ' ');
        val = StringUtils.rightPad(val, height * len - val.length(), ' ');
        System.out.println(val);
        PrintInOrder(head.left, height + 1, "^", len);
    }


}
