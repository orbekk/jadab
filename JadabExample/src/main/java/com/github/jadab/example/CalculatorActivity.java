package com.github.jadab.example;

import android.os.Bundle;
import android.util.Log;

import com.github.binding.android.BindingActivity;
import com.github.jadab.example.logic.DbaCalculatorLogic;

public class CalculatorActivity extends BindingActivity {

    private static String TAG = "CalculatorActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
		DbaCalculatorLogic logic = new DbaCalculatorLogic();
		setBoundContentView(R.layout.main);
		bindViewModel(logic);
    }

}

