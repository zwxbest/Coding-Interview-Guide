package com.tuowazi.base.code_view_guide.cp01._02;

import base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by zwxbest on 2019/3/16.
 */
@Ignore
public class TwoStackQueueTest  extends BaseTest{

    protected static TwoStackQueue<Integer> twoStackQueue;

    @Test
    public void testSame(){
        twoStackQueue.add(1);
        twoStackQueue.add(1);
        twoStackQueue.add(1);
        assertEqual(twoStackQueue.peek(),1);
        assertEqual(twoStackQueue.poll(),1);
        assertEqual(twoStackQueue.peek(),1);
        assertEqual(twoStackQueue.poll(),1);
        assertEqual(twoStackQueue.peek(),1);
        assertEqual(twoStackQueue.poll(),1);
        thrown.expectMessage("queue is empty");
        twoStackQueue.peek();
    }

    @Test
    public void testAsc(){
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        twoStackQueue.add(3);
        assertEqual(twoStackQueue.peek(),1);
        assertEqual(twoStackQueue.poll(),1);
        assertEqual(twoStackQueue.peek(),2);
        assertEqual(twoStackQueue.poll(),2);
        assertEqual(twoStackQueue.peek(),3);
        assertEqual(twoStackQueue.poll(),3);
        thrown.expectMessage("queue is empty");
        twoStackQueue.peek();
    }

    @Test
    public void testRandom(){
        twoStackQueue.add(2);
        twoStackQueue.add(1);
        twoStackQueue.add(3);
        assertEqual(twoStackQueue.peek(),2);
        assertEqual(twoStackQueue.poll(),2);
        assertEqual(twoStackQueue.peek(),1);
        assertEqual(twoStackQueue.poll(),1);
        assertEqual(twoStackQueue.peek(),3);
        assertEqual(twoStackQueue.poll(),3);
        thrown.expectMessage("queue is empty");
        twoStackQueue.peek();
    }


    /**
     * 一边压入一边弹出
     */
    @Test
    public void testPushPop(){
        twoStackQueue.add(2);
        twoStackQueue.add(1);
        assertEqual(twoStackQueue.peek(),2);
        assertEqual(twoStackQueue.poll(),2);
        twoStackQueue.add(3);
        assertEqual(twoStackQueue.peek(),1);
        assertEqual(twoStackQueue.poll(),1);
        assertEqual(twoStackQueue.peek(),3);
        assertEqual(twoStackQueue.poll(),3);
        thrown.expectMessage("queue is empty");
        twoStackQueue.peek();
    }
}
