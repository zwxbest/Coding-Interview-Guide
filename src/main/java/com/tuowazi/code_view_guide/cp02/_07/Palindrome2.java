package com.tuowazi.code_view_guide.cp02._07;

import java.util.Stack;
import node.Node;

/**
 * 只比较一半
 *
 * @author zhangweixiao - 19-3-29
 */
public class Palindrome2 implements Palindrome {

    @Override
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        //中间的node
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
