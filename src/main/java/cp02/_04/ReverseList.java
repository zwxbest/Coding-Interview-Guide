package cp02._04;

    import cp02.node.Node;

/**
 * @author zhangweixiao - 19-3-26
 */
public class ReverseList  {

    public Node reverseList(Node head){
        Node pre = null;
        Node next;
        //每一轮让当前head逆转指向
        while (head != null){
            //保存next
            next = head.next;
            //pre为逆转指向的next
            head.next = pre;
            //更新pre
            pre = head;
            //更新next
            head = next;
        }
        return pre;
    }
}
