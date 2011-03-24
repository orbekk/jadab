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
        
        if (isBindable(attrs)) {
            Log.d(TAG, "Bindable view: " + name);
            Log.d(TAG, "Trying to inflate from custom class.");
            try {
                String prefix = AndroidPrefix.getComponentPrefix(name);
                return originalInflater.createView(name, prefix, attrs);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Tried to bind view: " + name +
                        " but could not find bindable class: " + e.getMessage());
            }
        } else {       
            return null;
        }
    }
    
    public boolean isBindable(AttributeSet attrs) {
        return attrs.getAttributeBooleanValue(Constants.NAMESPACE, "bindable", false);
    }
}
