package com.github.darsha1509.hw_05102017;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mLeftEditText;
    EditText mRightEditText;

    Button mAddBtn;
    Button mDifBtn;
    Button mMultBtn;
    Button mDivBtn;

    TextView mResultTextView;

    ICalculator mCalculator;

    @Override
    public void onClick(final View pView) {

        final String leftNum = mLeftEditText.getText().toString();
        final String rightNum = mRightEditText.getText().toString();

        String result ="";

        mCalculator= new Calculator();

        switch(pView.getId()){
            case R.id.add_btn:
                result = mCalculator.add(leftNum, rightNum);
                break;
            case R.id.dif_btn:
                result = mCalculator.difference(leftNum, rightNum);
                break;
            case R.id.mult_btn:
                result = mCalculator.multiply(leftNum, rightNum);
                break;
            case R.id.div_btn:
                result = mCalculator.division(leftNum, rightNum);
                break;
        }

        mResultTextView.setText(result);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        mLeftEditText = (EditText) findViewById(R.id.left_edit_text);
        mRightEditText = (EditText) findViewById(R.id.right_edit_text);

        mAddBtn = (Button) findViewById(R.id.add_btn);
        mDifBtn = (Button) findViewById(R.id.dif_btn);
        mMultBtn = (Button) findViewById(R.id.mult_btn);
        mDivBtn = (Button) findViewById(R.id.div_btn);

        mResultTextView = (TextView) findViewById(R.id.result_text_view);

        mAddBtn.setOnClickListener(this);
        mDifBtn.setOnClickListener(this);
        mMultBtn.setOnClickListener(this);
        mDivBtn.setOnClickListener(this);

        Log.d(LOG_TAG, "onCreate()");
    }



}
