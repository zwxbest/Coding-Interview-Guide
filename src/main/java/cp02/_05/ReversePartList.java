package cp02._05;

import cp02.node.Node;

/**
 * @author zhangweixiao - 19-3-27
 */
public class ReversePartList {

    /**
     * @param from 为索引+1
     */
    public Node reversePart(Node head, int from, int to) {

        //范围不合法
        if (head == null || from > to || from < 1) {
            return head;
        }

        int len = 0;
        Node curNode = head;
        //from的前一个结点
        Node fPre = null;
        //to的下一个节点
        Node tNext = null;

        while (curNode != null) {
            len++;
            //如果from为1,那么fPre为null,如果为2,那么fPre就是head
            fPre = len == from - 1 ? curNode : fPre;
            tNext = len == to + 1 ? curNode : tNext;
            curNode = curNode.next;
        }
        if (to > len) {
            return head;
        }

        Node pre = tNext;
        Node next;
        curNode = fPre == null ? head : fPre.next;

        while (curNode != null && curNode != tNext) {
            next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
        }

        if (fPre == null) {
            return pre;
        } else {
            fPre.next = pre;
            return head;
        }
    }
}
