package com.tuowazi.code_view_guide.cp01._02;

import java.util.Stack;

/**
 * 最差的写法2，每次push要倒腾两次
 * Created by zwxbest on 2019/3/16.
 */
public class TwoStackQueue2<E> implements TwoStackQueue<E>{

    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();

    public void add(E element){
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(element);
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public E poll(){
        if(stack2.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return stack2.pop();
    }

    public E peek(){
        if(stack2.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return stack2.peek();
    }
}
