package com.tuowazi.test;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Created by zwxbest on 2019/3/16.
 */
public class BaseTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public <T> void assertEqual(T a, T b) {
        Assert.assertThat(a, IsEqual.equalTo(b));
    }
}
