package com.example.imagebitmaptest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

import com.example.imagebitmaptest.R;

/**
 * Date：2021/5/23
 * Time：12:10
 * author:Stenven
 **/
public class ToggleRadioButton extends android.support.v7.widget.AppCompatRadioButton {

    public ToggleRadioButton(Context context) {
        this(context, null);
    }

    public ToggleRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.radioButtonStyle);
    }

    public ToggleRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void toggle() {
        setChecked(!isChecked());
        if (!isChecked()) {
            ((RadioGroup)getParent()).clearCheck();
        }
    }
}
