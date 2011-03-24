package no.ntnu.capgeminitest.binding.android;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class BindingFactory implements LayoutInflater.Factory {

    public static final String TAG = "BindingFactory";
    private LayoutInflater originalInflater;
    
    public BindingFactory(LayoutInflater originalInflater) {
        this.originalInflater = originalInflater;
    }
    
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        Log.d(TAG, name);
        
        int count = attrs.getAttributeCount();
        for (int i = 0; i < count; i++) {
            String attrName = attrs.getAttributeName(i);
            String attrValue = attrs.getAttributeValue(i);
            Log.d(TAG, "\t" + attrName + ": " + attrValue);
        }
        
        return null;
    }
}
