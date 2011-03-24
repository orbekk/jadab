package no.ntnu.capgeminitest.dbacalculator;

import no.ntnu.capgeminitest.binding.android.BindingActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class DbaCalculator extends BindingActivity {
    public static final String TAG = "DbaCalculator";
    public static final String dbaNamespace = "http://org.ntnu.no/groups/capgeminitest/data-binding/";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        
        DbaCalculatorLogic logic = new DbaCalculatorLogic();
        setBoundContentView(R.layout.main);
        
        bind("DisplayText", logic.text);
        bind("TextClicked", logic.numberIncrementer);
    }
    
    public View calcOnCreateView(String name, Context context, AttributeSet attrs) {
        Log.d(TAG, "Creating view with name " + name + " and attributes: ");
        printAttributes(attrs);
        return null;
    }
    
    private void printAttributes(AttributeSet attrs) {
        int count = attrs.getAttributeCount();
        for (int i = 0; i < count; i++) {
            String attrName = attrs.getAttributeName(i);
            String attrValue = attrs.getAttributeValue(i);
            Log.d(TAG, "\t" + attrName + ": " + attrValue);
        }
    }
}