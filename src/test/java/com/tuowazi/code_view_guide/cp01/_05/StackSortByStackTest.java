package com.tuowazi.code_view_guide.cp01._05;

import com.tuowazi.test.BaseTest;
import java.util.Stack;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-18
 */
public class StackSortByStackTest extends BaseTest {

    private StackSortByStack<Integer> stackSortByStack = new StackSortByStack<>();

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stackSortByStack.sort(stack);
        assertEqual(stack.pop(),1);
        assertEqual(stack.pop(),2);
        assertEqual(stack.pop(),3);
    }

}
