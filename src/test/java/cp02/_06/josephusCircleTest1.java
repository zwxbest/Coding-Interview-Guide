package cp02._06;

import base.BaseTest;
import cp02.node.Node;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-27
 */
public class josephusCircleTest1 extends josephusCircleTest{


    @BeforeClass
    public static void beforeClass(){
        josephusCircle = new JosephusCircle1();
    }

}
