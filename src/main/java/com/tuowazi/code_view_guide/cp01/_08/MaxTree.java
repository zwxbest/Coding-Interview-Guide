package com.tuowazi.base.code_view_guide.cp01._08;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 构造数组的MaxTree
 *
 * 和搜索二叉树的区别是没有规定左边小右边大
 *
 * 中序遍历可得到原数组的从小到大排序
 *
 * @author zhangweixiao - 19-3-19
 */
public class MaxTree {


    //stack从顶到底,从左到右,从大到小
    //每次pop的时候计算被pop的左边或者右边第一个大的
    //比如 1 2 3,push 1,pop 1,push 2,pop 2,push 3,pop 3
    //比如 3 2 1,push 3,push 2,push 1
    //stack需要在遇到比栈顶大的值的时候就pop出栈顶
    //比如 5 2 1 4,遇到4的时候pop 2,pop 1,保留5,这样4左边第一个大的是5
    //不能提前计算.比如上面,如果提前计算,pop出5,那4就找不到5了
    //因为stack不能遍历
    private Stack<Node> stack = new Stack<>();

    private HashMap<Node, Node> lBigMap = new HashMap<>();

    private HashMap<Node, Node> rBigMap = new HashMap<>();

    public Node getMaxTree(int[] arr) {
        //初始化node
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            Node curNode = nodes[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
                popAndSet(stack, lBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popAndSet(stack, lBigMap);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            Node curNode = nodes[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
                popAndSet(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popAndSet(stack, rBigMap);
        }
        Node head = null;
        for (int i = 0; i < arr.length; i++) {
            Node curNode = nodes[i];
            Node lParent = lBigMap.get(curNode);
            Node rParent = rBigMap.get(curNode);
            if (lParent == null && rParent == null) {
                //最大值,作为头
                head = curNode;
            } else if (lParent == null) {
                setChild(rParent, curNode);
            } else if (rParent == null) {
                setChild(lParent, curNode);
            } else {
                Node parent = lParent.value < rParent.value ? lParent : rParent;
                setChild(parent, curNode);
            }
        }
        return head;

    }


    private void setChild(Node parent, Node curNode) {
        if (parent.left == null) {
            parent.left = curNode;
        } else {
            parent.right = curNode;
        }
    }

    private void popAndSet(Stack<Node> stack, Map<Node, Node> map) {
        Node pop = stack.pop();
        if (stack.isEmpty()) {
            map.put(pop, null);
        } else {
            map.put(pop, stack.peek());
        }
    }
}
