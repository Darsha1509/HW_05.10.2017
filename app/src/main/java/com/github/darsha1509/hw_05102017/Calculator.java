package com.github.darsha1509.hw_05102017;

import android.content.Context;
import android.widget.Toast;

class Calculator implements ICalculator {

    Context context;

    @Override
    public String add(final String value_1, final String value_2) {
        if (value_1.isEmpty() || value_2.isEmpty()) {
            return "";
        } else {
            final float result = Float.parseFloat(value_1) + Float.parseFloat(value_2);
            return String.valueOf(result);
        }
    }

    @Override
    public String difference(final String value_1, final String value_2) {
        if (value_1.isEmpty() || value_2.isEmpty()) {
            return "";
        } else {
            final float result = Float.parseFloat(value_1) - Float.parseFloat(value_2);
            return String.valueOf(result);
        }
    }

    @Override
    public String multiply(final String value_1, final String value_2) {
        if (value_1.isEmpty() || value_2.isEmpty()) {
            return "";
        } else {
            final float result = Float.parseFloat(value_1) * Float.parseFloat(value_2);
            return String.valueOf(result);
        }
    }

    @Override
    public String division(final String value_1, final String value_2) {
        if (value_1.isEmpty() || value_2.isEmpty()) {
            return "";
        } else {
            if (!"0".equals(value_2)) {
                final float result = Float.parseFloat(value_1) / Float.parseFloat(value_2);
                return String.valueOf(result);
            } else {
                Toast.makeText(context, context.getString(R.string.div_0), Toast.LENGTH_SHORT).show();
                return "";
            }

        }
    }
}


