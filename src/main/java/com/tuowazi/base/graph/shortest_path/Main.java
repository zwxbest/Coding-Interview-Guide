package com.tuowazi.base.graph.shortest_path;

import com.tuowazi.base.graph.base.ReadGraph;
import com.tuowazi.base.graph.base.SparseGraph;
import com.tuowazi.base.graph.find_path.DfsPath;

public class Main {

    // 测试无权图最短路径算法
    public static void main(String[] args) {

        String filename = "graph/shortestPath.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();

        // 比较使用深度优先遍历和广度优先遍历获得路径的不同
        // 广度优先遍历获得的是无权图的最短路径
        DfsPath dfs = new DfsPath(g, 0);
        System.out.print("DFS : ");
        dfs.showPath(6);

        ShortestPath bfs = new ShortestPath(g, 0);
        System.out.print("BFS : ");
        bfs.showPath(6);

        System.out.println();

        filename = "graph/shortestPath2.txt";
        SparseGraph g2 = new SparseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename);
        g2.show();

        // 比较使用深度优先遍历和广度优先遍历获得路径的不同
        // 广度优先遍历获得的是无权图的最短路径
        DfsPath dfs2 = new DfsPath(g2, 0);
        System.out.print("DFS : ");
        dfs2.showPath(3);

        ShortestPath bfs2 = new ShortestPath(g, 0);
        System.out.print("BFS : ");
        bfs.showPath(3);
    }
}