package cp01._06;

import base.BaseTest;
import cp01._02.TwoStackQueue1;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-19
 */
public class HanoiRecursionTest extends HanoiTest {

    @BeforeClass
    public static void beforeClass() {
        hanoi = new HanoiRecursion();
    }

}
