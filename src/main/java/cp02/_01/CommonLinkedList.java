package cp02._01;

import node.Node;

/**
 * 打印两个有序链表的公共部分
 *
 * 有序列表,从头到尾,从小到大
 *
 * @author zhangweixiao - 19-3-22
 */
public class CommonLinkedList {

    public Node getCommonLinkedList(Node head1, Node head2) {

        Node curNode = null;
        Node head = null;

        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                if (curNode == null) {
                    curNode = new Node(head1.value);
                    head = curNode;
                } else {
                    curNode.next = new Node(head1.value);
                    curNode = curNode.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return head;

    }
}
