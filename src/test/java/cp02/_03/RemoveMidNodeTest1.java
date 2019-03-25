package cp02._03;

import base.BaseTest;
import cp02.node.Node;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-25
 */
public class RemoveMidNodeTest1 extends RemoveMidNodeTest {

    @BeforeClass
    public static void BeforeClass(){
        removeMidNode = new RemoveMidNode1();
    }


}
