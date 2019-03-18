package cp01._05;

import java.util.Stack;

/**
 * @author zhangweixiao - 19-3-18
 */
public class StackSortByStack<E extends Comparable<E>> {

    private Stack<E> help = new Stack<>();

    public void sort(Stack<E> stack){
        while (!stack.isEmpty()){
            E element = stack.pop();
            while (!help.isEmpty() && help.peek().compareTo(element) >0){
                //push到stack的数据维持着小到大.
                stack.push(help.pop());
            }
            //help中总是从栈顶到栈底大到小
            help.push(element);
        }
        //stack栈顶到底小到大
        while (!help.empty()){
            stack.push(help.pop());
        }
    }
}
