package com.github.darsha1509.hw_05102017;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculatorMockitoTest {

    private ICalculator mMockCalculator;
    private ICalculator mSpyCalculator;

    @Before
    public void setup() {
        mMockCalculator = mock(Calculator.class);
        mSpyCalculator = spy(new Calculator());
    }

    @Test
    public void testZerosMock() throws Exception {
        when(mMockCalculator.add("0", "0")).thenReturn("0.0");
        assertEquals(mMockCalculator.add("0", "0"), "0.0");
        verify(mMockCalculator).add("0", "0");
    }

    @Test
    public void testPositiveMock() throws Exception {
        stub(mMockCalculator.difference("1", "1")).toReturn("0.0");
        assertEquals(mMockCalculator.difference("1", "1"), "0.0");
        verify(mMockCalculator).difference("1", "1");
    }

    @Test
    public void testNegativeSpy() throws Exception {
        assertEquals(mSpyCalculator.multiply("-1", "-1"), "1.0");
        verify(mSpyCalculator).multiply("-1", "-1");

    }

    @Test
    public void testSumIsBlankForBlankEquationSpy() throws Exception {
        assertEquals(mSpyCalculator.division("", ""), "");
        verify(mSpyCalculator).division("", "");
    }
}
