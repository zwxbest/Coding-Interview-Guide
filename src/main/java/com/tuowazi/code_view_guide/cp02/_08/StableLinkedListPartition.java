package com.tuowazi.code_view_guide.cp02._08;

import node.Node;

/**
 * 1.将原链表中的所有节点依次划分进三个链表，三个链表分别为small代表左部分，equal代表中间部分，big代表右部分。
 *
 * @author zhangweixiao - 19-4-2
 */
public class StableLinkedListPartition {

    public Node listPartition(Node head, int pivot) {
        if (head == null) {
            return null;
        }

        Node smallHead = null;
        Node smallTail = null;
        Node equalHead = null;
        Node equalTail = null;
        Node bigHead = null;
        Node bigTail = null;

        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (smallHead == null) {
                    smallHead = head;
                    smallTail = head;
                } else {
                    smallTail.next = head;
                    smallTail = head;
                }
            } else if (head.value == pivot) {
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
            } else {
                if (bigHead == null) {
                    bigHead = head;
                    bigTail = head;
                } else {
                    bigTail.next = head;
                    bigTail = head;
                }
            }
            head = next;
        }

        //小的和相等的接起来
        if (smallTail != null){
            smallTail.next = equalHead;
            equalTail = equalTail == null?smallTail:equalTail;
        }
        //相等的和大的连起来
        if(equalTail !=null){
            equalTail.next = bigHead;
        }
        if(smallHead != null){
            return smallHead;
        }
        if(equalHead != null){
            return equalHead;
        }
        return bigHead;
    }


}
