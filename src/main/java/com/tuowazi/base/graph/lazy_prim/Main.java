package com.tuowazi.base.graph.lazy_prim;

import com.tuowazi.base.graph.wight_graph.Edge;
import com.tuowazi.base.graph.wight_graph.ReadWeightedGraph;
import com.tuowazi.base.graph.wight_graph.SparseWeightedGraph;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        String filename = "graph/lazyPrim1.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
        Vector<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for (int i = 0; i < mst.size(); i++)
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();
    }
}
