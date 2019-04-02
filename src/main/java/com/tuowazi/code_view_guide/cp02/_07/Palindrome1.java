package com.tuowazi.code_view_guide.cp02._07;

import java.util.Stack;
import node.Node;

/**
 * @author zhangweixiao - 19-3-29
 */
public class Palindrome1 implements Palindrome {

    @Override
    public boolean isPalindrome(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
