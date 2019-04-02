package com.tuowazi.base.union_find;

import com.tuowazi.base.union_find.base.BaseUnionFind;
import com.tuowazi.base.union_find.compress_path.UnionFindCompress;
import com.tuowazi.base.union_find.compress_path2.UnionFindCompress2;
import com.tuowazi.base.union_find.union_by_rank.UnionFindByRank;
import com.tuowazi.base.union_find.union_by_size.UnionFindUnionBySize;

/**
 * @author zhangweixiao - 19-2-25
 */
public class UnionFindCompare {


    public static void main(String[] args) {
//        BaseUnionFind.COUNT = 100_000;
//        new ArrayUnionFind().run();
//        new TreeUnionFind().run();
//        new UnionFindUnionBySize().run();
//        new UnionFindByRank().run();
//        new UnionFindCompress().run();
//        new UnionFindCompress2().run();

        System.out.println("=========================");
        BaseUnionFind.COUNT = 1_000_000;
        new UnionFindUnionBySize().run();
        new UnionFindByRank().run();
        new UnionFindCompress().run();
        new UnionFindCompress2().run();

    }

}
