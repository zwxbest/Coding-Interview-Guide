package cp01;

import base.BaseTest;
import org.junit.Test;

/**
 * Created by zwxbest on 2019/3/16.
 */
public class StackWithMinTest extends BaseTest {

    /**
     * 相同数据
     */
    public  void testSame(StackWithMin<Integer> stackWithMin ){
        stackWithMin.push(1);
        stackWithMin.push(1);
        stackWithMin.push(1);
        assertEqual(stackWithMin.min(),1);

        Integer pop = stackWithMin.pop();
        assertEqual(pop,1);
        assertEqual(stackWithMin.min(),1);

        pop = stackWithMin.pop();
        assertEqual(pop,1);
        assertEqual(stackWithMin.min(),1);

        pop = stackWithMin.pop();
        assertEqual(pop,1);
        thrown.expectMessage("stack is empty");
        stackWithMin.min();
    }


    /**
     * 正序
     */
    public void testAsc(StackWithMin<Integer> stackWithMin){
        stackWithMin.push(1);
        stackWithMin.push(2);
        stackWithMin.push(3);
        assertEqual(stackWithMin.min(),1);

        Integer pop = stackWithMin.pop();
        assertEqual(pop,3);
        assertEqual(stackWithMin.min(),1);

        pop = stackWithMin.pop();
        assertEqual(pop,2);
        assertEqual(stackWithMin.min(),1);

        pop = stackWithMin.pop();
        assertEqual(pop,1);
        thrown.expectMessage("stack is empty");
        stackWithMin.min();
    }

    /**
     * 倒序
     */
    public void testDesc(StackWithMin<Integer> stackWithMin){
        stackWithMin.push(3);
        stackWithMin.push(2);
        stackWithMin.push(1);
        assertEqual(stackWithMin.min(),1);

        Integer pop = stackWithMin.pop();
        assertEqual(pop,1);
        assertEqual(stackWithMin.min(),2);

        pop = stackWithMin.pop();
        assertEqual(pop,2);
        assertEqual(stackWithMin.min(),3);

        pop = stackWithMin.pop();
        assertEqual(pop,3);
        thrown.expectMessage("stack is empty");
        stackWithMin.min();
    }

    /**
     * 随机
     */
    public void testRandom(StackWithMin<Integer> stackWithMin){
        stackWithMin.push(2);
        stackWithMin.push(1);
        stackWithMin.push(3);
        assertEqual(stackWithMin.min(),1);

        Integer pop = stackWithMin.pop();
        assertEqual(pop,3);
        assertEqual(stackWithMin.min(),1);

        pop = stackWithMin.pop();
        assertEqual(pop,1);
        assertEqual(stackWithMin.min(),2);

        pop = stackWithMin.pop();
        assertEqual(pop,2);
        thrown.expectMessage("stack is empty");
        stackWithMin.min();
    }


}
