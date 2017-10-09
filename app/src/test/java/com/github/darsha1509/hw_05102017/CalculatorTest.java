package com.github.darsha1509.hw_05102017;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 26)
public class CalculatorTest {

    private ICalculator mCalculator;

    @Before
    public void setup() {
        final CalculatorActivity calculatorActivity = Robolectric.setupActivity(CalculatorActivity.class);
        mCalculator = new Calculator(calculatorActivity);
    }

    @Test
    public void testZeros() throws Exception {
        assertEquals("0.0", mCalculator.add("0", "0"));
        assertEquals("0.0", mCalculator.difference("0", "0"));
        assertEquals("0.0", mCalculator.multiply("0", "0"));
        assertEquals("0.0", mCalculator.division("0", "1"));
    }

    @Test
    public void testPositive() throws Exception {
        assertEquals("2.0", mCalculator.add("1", "1"));
        assertEquals("0.0", mCalculator.difference("1", "1"));
        assertEquals("1.0", mCalculator.multiply("1", "1"));
        assertEquals("1.0", mCalculator.division("1", "1"));
    }

    @Test
    public void testNegative() throws Exception {
        assertEquals("-2.0", mCalculator.add("-1", "-1"));
        assertEquals("0.0", mCalculator.difference("-1", "-1"));
        assertEquals("1.0", mCalculator.multiply("-1", "-1"));
        assertEquals("1.0", mCalculator.division("-1", "-1"));
    }

    @Test
    public void testSumIsBlankForBlankEquation() throws Exception {
        assertEquals("", mCalculator.add("", ""));
        assertEquals("", mCalculator.difference("", ""));
        assertEquals("", mCalculator.multiply("", ""));
        assertEquals("", mCalculator.division("", ""));
    }
}
