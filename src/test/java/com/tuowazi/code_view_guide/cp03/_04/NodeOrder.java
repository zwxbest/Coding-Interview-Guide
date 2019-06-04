package com.tuowazi.code_view_guide.cp03._04;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.tuowazi.test.BaseTest;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;

/**
 * @author zhangweixiao - 2019/6/3
 */
public class NodeOrder extends BaseTest {


    @Getter
    public static class Node{
        int id;
        int nextId;
        public Node(int id){
            this.id = id;
        }
    }

    public static void main(String[] args) {
        //2-3-1
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node2.nextId = 3;
        node3.nextId = 1;
        List<Node> orderedNodes = order(Lists.newArrayList(node1,node2,node3));
        System.out.println(1);
    }

    private static List<Node> order(List<Node> nodes){

        Map<Integer,Node> nodeMap = Maps.newHashMap();

        Set<Integer> allNextIds = Sets.newHashSet();
        for (Node node : nodes) {
            nodeMap.put(node.id,node);
            allNextIds.add(node.nextId);
        }
        Set<Integer> allIds = Sets.newHashSet(nodeMap.keySet());
        allIds.removeAll(allNextIds);
        Node head = nodeMap.get(Integer.valueOf(allIds.toArray()[0].toString())) ;

        List<Node> orderedNodes = Lists.newArrayList();

        while (head != null){
            orderedNodes.add(head);
            head = nodeMap.get(head.nextId);
        }
        return orderedNodes;


    }
}
