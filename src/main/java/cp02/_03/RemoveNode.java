package cp02._03;

import cp02.node.Node;

/**
 * @author zhangweixiao - 19-3-25
 */
public interface RemoveNode {

    Node removeMidNode(Node head);

    /**
     * 移除a/b位置的节点,向上取整
     */
    Node removeNodeByRatio(Node head,int a,int b);
}
