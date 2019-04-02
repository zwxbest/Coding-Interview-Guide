package com.tuowazi.code_view_guide.cp01._02;

import java.util.Stack;

/**
 * 最差的写法2，每次pop要倒腾两次
 * Created by zwxbest on 2019/3/16.
 */
public class TwoStackQueue3<E> implements TwoStackQueue<E>{

    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();

    public void add(E element){
        stack1.push(element);

    }

    public E poll(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        if(stack2.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        E poll = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return poll;
    }

    public E peek(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        if(stack2.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        E poll = stack2.peek();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return poll;
    }
}
