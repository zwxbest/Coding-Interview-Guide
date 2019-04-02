package com.tuowazi.code_view_guide.cp01._01;

import java.util.Stack;

/**
 * min和data的元素数量相等，每次pop时始终对min进行pop，压入费时间
 * Created by zwxbest on 2019/3/16.
 */
public class StackWithMin2<E extends Comparable<E>> implements StackWithMin<E> {

    private Stack<E> data = new Stack<>();
    private Stack<E> min = new Stack<>();

    public void push(E element){
        data.push(element);
        if (min.isEmpty() || min.peek().compareTo(element) >= 0) {
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
