package cp02._06;

import node.Node;

/**
 * 环形单链表的约瑟夫问题
 *
 * @author zhangweixiao - 19-3-27
 */
public class JosephusCircle {

    public Node josephusKill(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }

        //找到最后一个节点,因为如果m=1,那第一个报数的就死掉了,最后一个连接第二个重做环
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            //因为从last开始,先++
            if (++count == m) {
                //删除next后,再连成环形
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            //head作为last的下一个节点
            head = last.next;
        }
        return head;
    }
}
