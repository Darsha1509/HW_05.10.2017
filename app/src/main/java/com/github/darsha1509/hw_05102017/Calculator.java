package com.github.darsha1509.hw_05102017;

import android.content.Context;
import android.widget.Toast;

class Calculator implements ICalculator{

    private final Context context;

    Calculator(final Context pContext) {
        context = pContext;
    }

    @Override
    public String add(final String value_1, final String value_2) {
        final float result = Float.parseFloat(value_1)+Float.parseFloat(value_2);
        return String.valueOf(result);
    }

    @Override
    public String difference(final String value_1, final String value_2) {
        final float result = Float.parseFloat(value_1)-Float.parseFloat(value_2);
        return String.valueOf(result);
    }

    @Override
    public String multiply(final String value_1, final String value_2) {
        final float result = Float.parseFloat(value_1)*Float.parseFloat(value_2);
        return String.valueOf(result);
    }

    @Override
    public String division(final String value_1, final String value_2) {
        float result = 0;
        if(!"0".equals(value_2)){
            result = Float.parseFloat(value_1)/Float.parseFloat(value_2);
        }else{
            Toast.makeText(context, context.getString(R.string.div_0), Toast.LENGTH_SHORT).show();
        }
        return String.valueOf(result);
    }
}
