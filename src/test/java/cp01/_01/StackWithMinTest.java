package cp01._01;

import base.BaseTest;
import cp01._01.StackWithMin;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by zwxbest on 2019/3/16.
 */
@Ignore
public class StackWithMinTest extends BaseTest {

    protected static StackWithMin<Integer> stackWithMin;
    /**
     * 相同数据
     */
    @Test
    public  void testSame( ){
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
    @Test
    public void testAsc(){
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
    @Test
    public void testDesc(){
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
    @Test
    public void testRandom(){
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
