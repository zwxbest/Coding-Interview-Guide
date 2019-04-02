package com.tuowazi.base.code_view_guide.cp01._02;

import java.util.Stack;

/**
 * 最差的写法，每次pop和push都要倒腾
 * Created by zwxbest on 2019/3/16.
 */
public class TwoStackQueue1<E> implements TwoStackQueue<E> {

    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();

    @Override
    public void add(E element){
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(element);
    }

    @Override
    public E poll(){
       while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        if(stack2.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return stack2.pop();
    }

    @Override
    public E peek(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        if(stack2.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return stack2.peek();
    }
}
