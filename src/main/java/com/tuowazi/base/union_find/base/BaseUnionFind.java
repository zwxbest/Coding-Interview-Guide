package com.tuowazi.base.union_find.base;

/**
 * @author zhangweixiao - 19-2-25
 */
public abstract class BaseUnionFind implements UnionFind {

    public static int COUNT = 1_0000;

    protected int getCount() {
        return COUNT;
    }

    // 测试第一版本的并查集, 测试元素个数为n
    public void run() {

        int n = getCount();

        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            unionElements(a, b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            isConnected(a, b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println(String.format("在%s中,%d个数据,用了%.2fs",getName(),n,(endTime - startTime)/1000f));
    }


}
