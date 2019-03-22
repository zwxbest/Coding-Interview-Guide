package cp01._01;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 *
 * getMin操作的时间复杂度都是O(1)
 * Created by zwxbest on 2019/3/16.
 */
public interface StackWithMin<E extends Comparable<E>> {

    void push(E element);

    E pop();

    E min();

}
