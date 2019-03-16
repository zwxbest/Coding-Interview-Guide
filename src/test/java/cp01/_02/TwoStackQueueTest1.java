package cp01._02;

import base.BaseTest;
import cp01._01.StackWithMinTest;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by zwxbest on 2019/3/16.
 */
public class TwoStackQueueTest1<E>  extends TwoStackQueueTest{

   @BeforeClass
    public static void beforeClass(){
       twoStackQueue = new TwoStackQueue1<>();
   }
}
