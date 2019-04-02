package com.tuowazi.code_view_guide.cp01._02;

/**
 * 由两个栈组成的队列
 *
 * Created by zwxbest on 2019/3/16.
 */
public interface TwoStackQueue<E> {
    void add(E element);

    E poll();

    E peek();
}
