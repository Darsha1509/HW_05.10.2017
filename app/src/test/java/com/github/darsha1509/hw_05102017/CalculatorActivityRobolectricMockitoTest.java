package com.github.darsha1509.hw_05102017;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyShort;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk=26)
public class CalculatorActivityRobolectricMockitoTest {

    private ICalculator mMockCalculator;
    private ICalculator mSpyCalculator;

    private ActivityController<CalculatorActivity> activityController;

    EditText leftEditText;
    EditText rightEditText;

    CalculatorActivity calculatorActivity;

    @Before
    public void onInit(){
        activityController = Robolectric.buildActivity(CalculatorActivity.class);
        activityController.create();
        activityController.start();
        activityController.resume();
        calculatorActivity = activityController.get();

        mMockCalculator = mock(Calculator.class);
        mSpyCalculator = spy(Calculator.class);

        leftEditText = (EditText) calculatorActivity.findViewById(R.id.left_edit_text);
        rightEditText = (EditText) calculatorActivity.findViewById(R.id.right_edit_text);

    }

    @Test
    public void MockTest(){
        leftEditText.setText(anyString());
        rightEditText.setText(anyString());

        when(mMockCalculator.add(leftEditText.getText().toString(), rightEditText.getText().toString()))
                .thenReturn("7");
        assertEquals(mMockCalculator.add("3", "7"), "7");
        verify(mMockCalculator).add("3", "7");
    }

    @Test
    public void SpyTest(){
        leftEditText.setText("2");
        rightEditText.setText("3");

        Button difBtn = (Button) calculatorActivity.findViewById(R.id.dif_btn);
        difBtn.performClick();

        TextView resultTextView = (TextView)calculatorActivity.findViewById(R.id.result_text_view);
        String result = resultTextView.getText().toString();

        assertEquals(mSpyCalculator.difference("2", "3"), result);
        verify(mSpyCalculator).difference("2", "3");

    }

    @After
    public void onDestroy(){
        activityController.pause();
        activityController.stop();
        activityController.destroy();
    }
}
