package cp02._03;

import cp02.node.Node;

/**
 * @author zhangweixiao - 19-3-25
 */
public class RemoveNode1 implements RemoveNode {

    @Override
    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        //长度为2,将头节点删除
        if (head.next.next == null) {
            return head.next;
        }
        //从长度为1开始,每增加2个,删除的节点往后挪1个
        //删除节点的上一个节点

        //处理长度>=3的情况
        Node pre = head;
        while (pre.next.next.next != null && pre.next.next.next.next != null) {
            pre = pre.next;
        }

        pre.next = pre.next.next;
        return head;
    }

    @Override
    public Node removeNodeByRatio(Node head, int a, int b) {
        if (b == 0) {
            throw new RuntimeException("b 不能等于0");
        }
        //如果要删除的不在链表区间中
        if (a <= 0 || a > b) {
            return head;
        }
        if(head == null){
            return head;
        }
        //先计算长度
        int length = 1;
        Node cur = head;
        while (cur.next != null) {
            length++;
        }

        //长度>=2
        int pos = (int) Math.ceil(1d * a * length / b);
        //删除第pos个节点
        Node pre = head;
        for(int i=1;i<pos;i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

}
