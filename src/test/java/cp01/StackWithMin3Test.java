package cp01;

import org.junit.Test;

/**
 * Created by zwxbest on 2019/3/16.
 */
public class StackWithMin3Test extends StackWithMinTest {



    private StackWithMin3<Integer> stackWithMin3 = new StackWithMin3<>();

    /**
     * 相同数据
     */
    @Test
    public void testGetMinStack(){
        super.testSame(stackWithMin3);
    }


    /**
     * 正序
     */
    @Test
    public void testGetMinStack2(){
        super.testAsc(stackWithMin3);
    }

    /**
     * 倒序
     */
    @Test
    public void testGetMinStack3(){
        super.testDesc(stackWithMin3);
    }

    /**
     * 随机
     */
    @Test
    public void testGetMinStack4(){
        super.testRandom(stackWithMin3);
    }


}
