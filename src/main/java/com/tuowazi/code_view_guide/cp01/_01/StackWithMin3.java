package com.tuowazi.base.code_view_guide.cp01._01;

import java.util.Stack;

/**
 * 针对min2，>= 0该为>0,两种都是对的
 * Created by zwxbest on 2019/3/16.
 */
public class StackWithMin3<E extends Comparable<E>> implements StackWithMin<E> {

    private Stack<E> data = new Stack<>();
    private Stack<E> min = new Stack<>();

    public void push(E element){
        data.push(element);
        if (min.isEmpty() || min.peek().compareTo(element) > 0) {
            min.push(element);
        }else {
            min.push(min.peek());
        }
    }

    public E pop(){
        if(data.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        E element = data.pop();
        min.pop();
        return element;
    }

    public E min(){
        if(min.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return min.peek();
    }

}
