package com.tuowazi.code_view_guide.cp01._03;

import base.BaseTest;
import java.util.Stack;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-18
 */
public class ReverseStackTest  extends BaseTest{

    private ReverseStack<Integer> reverseStack = new ReverseStack<>();

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverseStack.reverseStack(stack);
        assertEqual(stack.pop(), 1);
        assertEqual(stack.pop(), 2);
        assertEqual(stack.pop(), 3);
    }

    @Test
    public void test1() {

        ReverseStack<Integer> reverseStack = new ReverseStack<>();
        Stack<Integer> stack = new Stack<>();
        reverseStack.reverseStack(stack);
        assertEqual(stack.isEmpty(), true);
    }
}
