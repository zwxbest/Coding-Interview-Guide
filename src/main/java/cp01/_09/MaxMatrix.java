package cp01._09;

import java.util.Stack;

/**
 * 求最大子矩阵的大小
 *
 * 第二步maxRecFromBottom,找最有第一个小于当前值,和MaxTree很像,区别是maxTree需要保存关系
 *
 * maxTree是找左右第一个大的值,这个找一边就够了
 *
 * @author zhangweixiao - 19-3-21
 */
public class MaxMatrix {

    /**
     * @param map 第一维度表示行,第二维度表示列
     * @return
     */
    public int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }

        int maxArea = 0;

        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                //计算每个值上方连续1的数量
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            //是否需要更新到当前行的最大值
            maxArea = Math.max(maxArea, maxRecFromBottom(height));
        }
        return maxArea;
    }

    public int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        //此次遍历stack存储左边第一个小的
        //从左往右,从顶往底,从大到小
        for (int i = 0; i < height.length; i++) {
            //height[i]更小，前面的pop掉并且统计，直到遇到＜＝目前的
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                //不可能出现 k1 k2 j,height[k1] > height[j],height[k2] > height[j]
                //如果h[k1]<=height[k2],k2会被pop走
                //如果h[k2] < h[k1],k1已经不在了,比如 5 4 3,5早就被pop了

                //空的时候为-1,-1+1=0,
                int k = stack.empty() ? -1 : stack.peek();
                int curArea = ((i - 1) - k) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - 1 - k) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }


}
