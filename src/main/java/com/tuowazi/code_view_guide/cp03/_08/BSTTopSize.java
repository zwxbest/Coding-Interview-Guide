package com.tuowazi.code_view_guide.cp03._08;

import node.BiNode;

/**
 * @author zhangweixiao - 2019/6/26
 */
public class BSTTopSize {

    public int bstTopSize1(BiNode head) {
        if (head == null) {
            return 0;
        }
        System.out.println("head is "+head.value +" %% ");
        int max = maxTopo(head, head);
        max = Math.max(bstTopSize1(head.left), max);
        max = Math.max(bstTopSize1(head.right), max);
        return max;
    }

    public int maxTopo(BiNode h, BiNode n) {
        System.out.print("h is "+ (h == null?"null":h.value)+" & ");
        System.out.print("n is "+ (n == null?"null":n.value)+" & ");
        System.out.println();
        if (h != null && n != null && isBSTNode(h, n, n.value)) {
            return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
        }
        return 0;
    }

    private boolean isBSTNode(BiNode h, BiNode n, int value) {
        if (h == null) {
            return false;
        }
        System.out.print("h.value "+h.value +" | ");
        System.out.print("n's value "+n.value+" | ");
        System.out.print("value "+value+" | ");
        System.out.println();
        if (h == n) {
            return true;
        }
        return isBSTNode(h.value > value ? h.left : h.right, n, value);
    }
}
