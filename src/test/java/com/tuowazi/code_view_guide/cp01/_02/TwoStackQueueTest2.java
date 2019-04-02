package com.tuowazi.code_view_guide.cp01._02;

import org.junit.BeforeClass;

/**
 * Created by zwxbest on 2019/3/16.
 */
public class TwoStackQueueTest2<E>  extends TwoStackQueueTest{

   @BeforeClass
    public static void beforeClass(){
       twoStackQueue = new TwoStackQueue2<>();
   }
}
