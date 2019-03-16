package cp01;

import base.BaseTest;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by zwxbest on 2019/3/16.
 */
public class StackWithMin1Test extends StackWithMinTest {



    private StackWithMin1<Integer> stackWithMin1 = new StackWithMin1<>();

    /**
     * 相同数据
     */
    @Test
    public void testGetMinStack(){
        super.testSame(stackWithMin1);
    }


    /**
     * 正序
     */
    @Test
    public void testGetMinStack2(){
        super.testAsc(stackWithMin1);
    }

    /**
     * 倒序
     */
    @Test
    public void testGetMinStack3(){
        super.testDesc(stackWithMin1);
    }

    /**
     * 随机
     */
    @Test
    public void testGetMinStack4(){
        super.testRandom(stackWithMin1);
    }


}
