package cp01;

import org.junit.Test;

/**
 * Created by zwxbest on 2019/3/16.
 */
public class StackWithMin2Test extends StackWithMinTest {



    private StackWithMin2<Integer> stackWithMin2 = new StackWithMin2<>();

    /**
     * 相同数据
     */
    @Test
    public void testGetMinStack(){
        super.testSame(stackWithMin2);
    }


    /**
     * 正序
     */
    @Test
    public void testGetMinStack2(){
        super.testAsc(stackWithMin2);
    }

    /**
     * 倒序
     */
    @Test
    public void testGetMinStack3(){
        super.testDesc(stackWithMin2);
    }

    /**
     * 随机
     */
    @Test
    public void testGetMinStack4(){
        super.testRandom(stackWithMin2);
    }


}
