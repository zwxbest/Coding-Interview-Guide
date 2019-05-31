package com.tuowazi.code_view_guide.cp03._04;

import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import node.BiNode;
import node.Node;

/**
 * @author zhangweixiao - 2019/5/31
 */
public class SerialTree {

    public String serialByPre(BiNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public BiNode reconByPreString(String preStr) {
        List<String> values = Lists.newArrayList(preStr.split("!"));
        Queue<String> queue = Lists.newLinkedList(values);
        return reconPreOrder(queue);
    }

    /**
     * 有###表示结束树
     *
     * @param queue queue
     * @return 返回
     */
    private BiNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }
        BiNode head = new BiNode(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    public String serialByLevel(BiNode head){
            if(head == null){
                return "#!";
            }
            String res = head.value+"!";
            Queue<BiNode> queue = new LinkedList<>();
            queue.offer(head);
            while (!queue.isEmpty()){
                head = queue.poll();
                if(head.left!=null){
                    res+=head.left.value+"!";
                    queue.offer(head.left);
                }else {
                    res+="#!";
                }
                if(head.right!=null){
                    res+=head.right.value+"!";
                    queue.offer(head.right);
                }else {
                    res+="#!";
                }
            }
            return res;
    }

    public BiNode reconByLevelString(String levelStr){
        String[] values  = levelStr.split("!");
        int index  = 0 ;
        BiNode head = generateNodeByString(values[index++]);
        Queue<BiNode> queue = new LinkedList<>();
        if(head != null){
            queue.offer(head);
        }
        BiNode node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return head;
    }

    public BiNode generateNodeByString(String val){
        if(val.equals("#")){
            return null;
        }
        return new BiNode(Integer.valueOf(val));
    }
}
