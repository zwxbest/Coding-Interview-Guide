package com.tuowazi.base.code_view_guide.cp01._02;

import java.util.Stack;

/**
 * 好一点的写法，只有pop时stack2为空，从stack1补充数据。
 * 否则直接pop
 * stack1直接push
 * Created by zwxbest on 2019/3/16.
 */
public class TwoStackQueue4<E> implements TwoStackQueue<E>{

    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();

    public void add(E element){
        stack1.push(element);

    }

    public E poll(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return stack2.pop();
    }

    public E peek(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return stack2.peek();
    }
}
