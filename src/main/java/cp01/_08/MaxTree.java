package cp01._08;

import com.sun.deploy.resources.Deployment_sv;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zwxbest on 2019/3/19.
 */
public class MaxTree {

    @Getter
    @Setter
    static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //stack从栈顶到栈底，保持从小到大的顺序
    Stack<Node> stack = new Stack<>();
    //value为左边第一比key大的值
    Map<Node, Node> lBigMap = new HashMap<>();
    Map<Node, Node> rBigMap = new HashMap<>();

    public Node getMaxTree1(int[] arr) {
        //初始化
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            Node curNode = nodes[i];
            if(stack.isEmpty()){
                lBigMap.put(curNode,null);
            }else {
                Node pop = stack.pop();
                if(pop.getValue() < curNode.getValue()){
                    lBigMap.put(curNode,null);
                }else {
                    lBigMap.put(curNode,pop);
                }
            }
            stack.push(curNode);
        }
        stack.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            Node curNode = nodes[i];
            if(stack.isEmpty()){
                rBigMap.put(curNode,null);
            }else{
                Node pop = stack.pop();
                if(pop.getValue() < curNode.getValue()){
                    rBigMap.put(curNode,null);
                }else {
                    rBigMap.put(curNode,pop);
                }
            }
            stack.push(curNode);
        }
        //根据rBigMap和lBigMap构造二叉树
        Node head = null;
        for (int i = 0; i < arr.length; i++) {
            Node curNode = nodes[i];
            Node lParent = lBigMap.get(curNode);
            Node rParent = rBigMap.get(curNode);
            if(lParent == null && rParent == null){
                head = curNode;
            } else if(lParent == null){
                if(rParent.left == null){
                    rParent.left = curNode;
                }else {
                    rParent.right = curNode;
                }
            }else if(rParent == null){
                if(lParent.left == null){
                    lParent.left = curNode;
                }else {
                    lParent.right = curNode;
                }
            }else {
                Node parent = lParent.getValue()<rParent.getValue()?lParent:rParent;
                if(parent.left == null){
                    parent.left = curNode;
                }else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        MaxTree maxTree = new MaxTree();
//        maxTree.getMaxTree(new int[]{1,2,3,4,5});
//        maxTree.getMaxTree(new int[]{5,4,3,2,1});
        MaxTree maxTree1 = new MaxTree();
        Node maxTree11 = maxTree1.getMaxTree1(new int[]{5, 4, 3, 2, 6});
        System.out.println(1);
    }
}
