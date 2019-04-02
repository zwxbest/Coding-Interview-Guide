package com.tuowazi.base.graph.find_path;

import com.tuowazi.base.graph.base.ReadGraph;
import com.tuowazi.base.graph.base.SparseGraph;

public class Main {

    // 测试寻路算法
    public static void main(String[] args) {

        String filename = "graph/findPath.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        DfsPath dfsPath = new DfsPath(g, 0);
        System.out.println("DfsPath from 0 to 6 : ");
        dfsPath.showPath(6);
    }
}
