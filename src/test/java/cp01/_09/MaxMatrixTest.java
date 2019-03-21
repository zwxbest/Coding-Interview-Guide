package cp01._09;

import base.BaseTest;
import java.util.Stack;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-21
 */
public class MaxMatrixTest extends BaseTest {

    private MaxMatrix maxMatrix = new MaxMatrix();

    @Test
    public void test() {
        int maxRecFromBottom = maxMatrix.maxRecSize(new int[][]{
            {
                1, 0, 1, 1
            }, {
            1, 1, 1, 1
        }, {
            1, 1, 1, 0
        }
        });

        assertEqual(maxRecFromBottom, 6);
    }

}
