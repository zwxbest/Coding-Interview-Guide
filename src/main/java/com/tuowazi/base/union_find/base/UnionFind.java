package com.tuowazi.base.union_find.base;

// 我们的第二版Union-Find
public interface UnionFind {

    int find(int p);

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

    String getName();
}
