package com.tuowazi.base.code_view_guide.cp01._03;

import java.util.Stack;

/**
 * 如何仅用递归函数和栈操作逆序一个栈
 *
 * @author zhangweixiao - 19-3-18
 */
public class ReverseStack<E>  {

    public void reverseStack(Stack<E> stack) {
        if (stack.isEmpty()) {
            return;
        }
        E lastElement = getLastElement(stack);
        reverseStack(stack);
        //第一次执行的时候stack已经为空,依次倒顺还原回去
        stack.push(lastElement);
    }

    private E getLastElement(Stack<E> stack) {
        E element = stack.pop();
        if (stack.empty()) {
            return element;
        }
        E last = getLastElement(stack);
        //stack还原回去
        stack.push(element);
        //栈底一层层传上来
        return last;
    }
}
