package com.tuowazi.base.code_view_guide.cp02._07;

import node.Node;

/**
 * 反转链表再恢复
 *
 * @author zhangweixiao - 19-3-29
 */
public class Palindrome3 implements Palindrome {

    @Override
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next; //中间节点
            n2 = n2.next.next; //遍历到结尾
        }
        n2 = n1.next; //右边第一个节点
        n1.next = null;  //中间节点的next指向null
        Node n3 = null;
        //右半区反转
        while (n2!=null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2; //向右移动
            n2 = n3; //向右移动
        }

        n3 = n1;//保存最后一个节点,用来恢复反转的

        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        //恢复反转
        n1 = n3.next;
        n3.next = null;
        while (n1 != null){
            n2  = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return true;
    }
}
