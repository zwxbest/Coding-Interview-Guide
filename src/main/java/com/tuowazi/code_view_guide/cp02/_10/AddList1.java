package com.tuowazi.code_view_guide.cp02._10;

import java.util.Stack;
import javafx.application.Preloader;
import node.Node;

/**
 * 利用 栈结构求解。
 * @author zhangweixiao - 19-4-16
 */
public class AddList1 implements AddList{

    public Node addList(Node head1,Node head2) {
        Stack<Integer> s1= new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null){
            s1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null){
            s2.push(head2.value);
            head2 = head2.next;
        }

        //进位
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;

        Node pre = null;

        while (!s1.isEmpty() || !s2.isEmpty()){
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty()? 0 :s2.pop();

            n = n1+n2+ca;

            pre = node;
            node = new Node(n%10);
            node.next = pre;
            ca = n/10;
        }

        if(ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;

    }
}
