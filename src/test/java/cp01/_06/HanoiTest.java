package cp01._06;

import base.BaseTest;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-19
 */
public class HanoiTest extends BaseTest {

    protected static Hanoi hanoi;

    @Test
    public void test(){
        int totalStepCount = hanoi.hanoi(2);
        assertEqual(totalStepCount,8);
    }

}
