package cp01;

import java.util.Stack;

/**
 * min和data的元素数量不相等，每次pop时判断是否对min进行pop
 * Created by zwxbest on 2019/3/16.
 */
public class StackWithMin1<E extends Comparable<E>> implements StackWithMin<E> {

    private Stack<E> data = new Stack<>();
    private Stack<E> min = new Stack<>();

    public void push(E element){
        data.push(element);
        if (min.isEmpty() || min.peek().compareTo(element) >= 0) {
            min.push(element);
        }
    }

    public E pop(){
        if(data.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        E element = data.pop();
        E minElement = min.peek();
        if(element == minElement){
            min.pop();
        }
        return element;
    }

    public E min(){
        if(min.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return min.peek();
    }

}
