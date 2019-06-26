package com.tuowazi.code_view_guide.cp03._09;

import com.google.common.collect.Maps;
import java.util.Map;
import node.BiNode;
import node.Node;

/**
 * @author zhangweixiao - 2019/6/26
 */
public class BSTTopSize2 {

    public class Record {

        public int left;//左节点的拓扑贡献记录
        public int right;//右节点的拓扑贡献记录

        public Record(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public int getBstTopSize2(BiNode head) {
        Map<BiNode, Record> map = Maps.newHashMap();
        return posOrder(head, map);
    }

    /**
     * @param map 拓扑贡献记录
     */
    private int posOrder(BiNode h, Map<BiNode, Record> map) {
        if (h == null) {
            return 0;
        }
        int ls = posOrder(h.left, map);
        int rs = posOrder(h.right, map);
        modifyMap(h.left, h.value, map, true);
        modifyMap(h.right, h.value, map, false);
        Record lr = map.get(h.left);
        Record rr = map.get(h.right);

        int lbst = lr == null ? 0 : lr.left + lr.right + 1;
        int rbst = rr == null ? 0 : rr.left + rr.right + 1;
        map.put(h, new Record(lbst, rbst));
        return Math.max(lbst + rbst + 1, Math.max(ls, rs));

    }

    /**
     * 修改拓扑贡献记录
     *
     * @param value 父节点的值
     * @param isLeft 是否是左子树
     */
    private int modifyMap(BiNode n, int value, Map<BiNode, Record> m, boolean isLeft) {
        System.out.println("n is " + (n == null ? "null " : n.value) + " | " + "value is " + value +" ||");
        if (n == null || (!m.containsKey(n))) {
            return 0;
        }
        Record r = m.get(n);
        if ((isLeft && n.value > value) || ((!isLeft) && n.value < value)) {
            m.remove(n);
            //不满足搜索树，返回需要去掉的贡献记录值
            return r.left + r.right + 1;
        } else {
            int minus = modifyMap(isLeft ? n.right : n.left, value, m, isLeft);
            if (isLeft) {
                r.right = r.right - minus;
            } else {
                r.left = r.left - minus;
            }
            m.put(n, r);
            return minus;
        }
    }
}
