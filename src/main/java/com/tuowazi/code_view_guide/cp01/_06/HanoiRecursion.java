package com.tuowazi.code_view_guide.cp01._06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangweixiao - 19-3-19
 */
public class HanoiRecursion implements Hanoi{

    private static final String left = "left";

    private static final String mid = "mid";

    private  static final String right = "right";

    List<Step> steps = new ArrayList<>();

    @Override
    public int hanoi(int num) {

        if (num < 1) {
            return 0;
        }

        steps.clear();
        return process(num, left, right);
    }


    /**
     * @param num 塔的序号,从上到下,从1开始
     * @param from 从哪
     * @param to 到哪
     * @return 每轮递归处理需要几步
     */
    private int process(int num, String from, String to) {
        //只剩最上层的塔
        if (num == 1) {
            //从mid或者到mid
            if (from.equals(mid) || to.equals(mid)) {
                steps.add(new Step(num, from, to));
                return 1;
            } else {
                //从左到右或者从右到左
                steps.add(new Step(num, from, mid));
                steps.add(new Step(num, mid, to));
                return 2;
            }
        }

        //处理N层塔

        //从mid或者到mid
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left)) || (to.equals(left)) ? right : left;
            //先将1~N-1层塔从左移动到右
            int stepCount1 = process(num - 1, from, another);
            //第N层塔从from移动到to
            steps.add(new Step(num, from, to));
            int stepCount2 = 1;
            int stepCount3 = process(num - 1, another, to);
            return stepCount1 + stepCount2 + stepCount3;
        } else {
            //如果剩下的N层塔都在“左”，希望全部移到“右”,或者相反
            //1~N-1移动,与N的方向一样
            int stepCount1 = process(num - 1, from, to);
            //第N层从from移动到mid
            steps.add(new Step(num, from, to));
            int stepCount2 = 1;
            //1~N-1从to移动到from
            int stepCount3 = process(num - 1, to, from);
            //第N层从mid移动到to
            int stepCount4 = 1;
            steps.add(new Step(num, mid, to));
            //1~N-1层从from移动到to
            int StepCount5 = process(num - 1, from, to);
            return stepCount1 + stepCount2 + stepCount3 + stepCount4 + StepCount5;
        }
    }
}
