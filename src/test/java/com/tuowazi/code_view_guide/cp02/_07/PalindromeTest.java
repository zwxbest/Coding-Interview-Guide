package com.tuowazi.code_view_guide.cp02._07;

import com.tuowazi.test.BaseTest;
import java.util.Stack;
import node.Node;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-29
 */
@Ignore
public class PalindromeTest extends BaseTest {

    protected static Palindrome palindrome;

    @Test
    public void test() {
        assertEqual(palindrome.isPalindrome(null), true);
    }

    @Test
    public void test1() {
        Node head = new Node(1);
        assertEqual(palindrome.isPalindrome(head), true);
    }


    @Test
    public void test2() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        assertEqual(palindrome.isPalindrome(head), true);
    }

    @Test
    public void test3() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        assertEqual(palindrome.isPalindrome(head), true);
    }


}
