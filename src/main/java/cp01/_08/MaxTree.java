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

    public Node getMaxTree(int[] arr) {
        //初始化
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            Node curNode =nodes[i];
            //每次上一个元素
            while (!stack.isEmpty() && stack.peek().getValue() < curNode.getValue()){
                setMap(stack,lBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()){
            setMap(stack,lBigMap);
        }
        return null;
    }

    private void  setMap(Stack<Node> stack,Map<Node,Node> map){
        //当前要处理的node
        Node node = stack.pop();
        //看看左边是否有比node大的。
        if(stack.isEmpty()){
            map.put(node,null);
        }else {
            map.put(node,stack.peek());
        }
    }

    public static void main(String[] args) {
        MaxTree maxTree = new MaxTree();
//        maxTree.getMaxTree(new int[]{1,2,3,4,5});
//        maxTree.getMaxTree(new int[]{5,4,3,2,1});
          maxTree.getMaxTree(new int[]{5,4,3,2,6});
        System.out.println(1);
    }
}
