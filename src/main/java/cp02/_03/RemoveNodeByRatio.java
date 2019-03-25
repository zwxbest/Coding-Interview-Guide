package cp02._03;

import cp02.node.Node;

/**
 * @author zhangweixiao - 19-3-25
 */
public class RemoveNodeByRatio {

    public Node removeNodeByRatio(Node head, int a, int b) {
        if (b == 0) {
            throw new RuntimeException("b 不能等于0");
        }
        //如果要删除的不在链表区间中
        if (a <= 0 || a > b) {
            return head;
        }
        if (head == null) {
            return head;
        }
        //先计算长度
        int length = 1;
        Node cur = head;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }

        //长度>=2
        int pos = (int) Math.ceil(1d * a * length / b) - 1;
        //删除第pos个节点
        if (pos == 0) {
            head = head.next;
        } else {
            Node pre = head;
            for (int i = 1; i < pos; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
        }
        return head;
    }
}
