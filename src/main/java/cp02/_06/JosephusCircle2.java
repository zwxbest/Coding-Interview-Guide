package cp02._06;


import node.Node;

/**
 * 环形单链表的约瑟夫问题
 *
 * @author zhangweixiao - 19-3-27
 */
public class JosephusCircle2  implements JosephusCircle{

    @Override
    public Node josephusKill(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        int size =1;
        Node cur  = head.next;
        while (cur != head) {
            size++;
            cur = cur.next;
        }
        int aliveOne = getLive(size,m);
        while (--aliveOne !=0){
                head = head.next;
        }
        head.next = head;
        return head;
    }

    /**
     * 活着的那个人
     */
    private int getLive(int i,int m){
        if(i == 1){
            return 1;
        }
        //old=(new+m-1)%i+1
        return (getLive(i-1,m)+m-1)%i+1;
    }
}
