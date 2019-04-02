package com.tuowazi.code_view_guide.cp01._06;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangweixiao - 19-3-19
 */
public class HanoiNoRecursion implements Hanoi {

    List<Step> steps = new ArrayList<>();

    @Getter
    @AllArgsConstructor
    enum Move {
        NONE,
        L2M,
        M2L,
        M2R,
        R2M;

    }

    private Move lastMove = Move.NONE;
    //左中右三个stack

    private Stack<Integer> lStack = new Stack<>();
    private Stack<Integer> mStack = new Stack<>();
    private Stack<Integer> rStack = new Stack<>();

    private static final String left = "left";

    private static final String mid = "mid";

    private static final String right = "right";


    @Override
    public int hanoi(int num) {
        lStack.clear();
        mStack.clear();
        rStack.clear();

        //先把所有塔的编号放到lStack中
        for (int i = num; i > 0; i--) {
            lStack.add(i);
        }

        int totalSteps = 0;

        //直到全部移动到right
        while (rStack.size() < num) {
            totalSteps += move(Move.L2M, lStack, mStack, left, mid);
            totalSteps += move(Move.M2L, mStack, lStack, mid, left);
            totalSteps += move(Move.M2R, mStack, rStack, mid, right);
            totalSteps += move(Move.R2M, rStack, mStack, right, mid);
        }
        return totalSteps;
    }


    private int move(Move move, Stack<Integer> fromStack, Stack<Integer> toStack,
        String from, String to) {
        //相邻不可逆向原则
        boolean canMove = true;

        if (lastMove == Move.L2M) {
            if (move == Move.M2L) {
                canMove = false;
            }
        } else if (lastMove == Move.M2L) {
            if (move == Move.L2M) {
                canMove = false;
            }

        } else if (lastMove == Move.M2R) {
            if (move == Move.R2M) {
                canMove = false;
            }

        } else if (lastMove == Move.R2M) {
            if (move == Move.M2R) {
                canMove = false;
            }
        }
        if(!canMove){
            return 0;
        }
        int stepCount = getStepBySmallOnLarge(fromStack, toStack, from, to);
        if(stepCount == 1){
            //只有成功了才保存成为下一步
            lastMove = move;
            return 1;
        }
        return 0;
    }

    /**
     * 小压大原则
     */
    private int getStepBySmallOnLarge(Stack<Integer> fromStack, Stack<Integer> toStack,
        String from, String to) {
        if(fromStack.isEmpty()){
            return 0;
        }
        if (toStack.isEmpty() || fromStack.peek() < toStack.peek()) {
            steps.add(new Step(fromStack.peek(), from, to));
            toStack.push(fromStack.pop());
            return 1;
        }
        return 0;
    }


}
