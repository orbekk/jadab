package no.ntnu.capgeminitest.binding.android;

import java.util.HashMap;
import java.util.Map;

import no.ntnu.capgeminitest.binding.android.propertyprovider.PropertyProvider;
import no.ntnu.capgeminitest.binding.android.propertyprovider.PropertyProviderFactory;
import no.ntnu.capgeminitest.data.Property;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class BindingFactory implements LayoutInflater.Factory {

    public static final String TAG = "BindingFactory";
    
    private PropertyProviderFactory propertyProviderFactory;
    private LayoutInflater originalInflater;
    private Map<String, Property<?>> boundProperties;
    
    public BindingFactory(PropertyProviderFactory propertyProviderFactory,
            LayoutInflater originalInflater) {
        this.propertyProviderFactory = propertyProviderFactory;
        this.originalInflater = originalInflater;
    }
    
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        Log.d(TAG, name);
        
        Map<String, String> bindingAttrs = getBindingAttrs(attrs);
        
        if (bindingAttrs != null) {
            Log.d(TAG, "Binding view: " + name);
            Log.d(TAG, "Trying to inflate with properties.");
            try {
                String prefix = AndroidPrefix.getComponentPrefix(name);
                View view = originalInflater.createView(name, prefix, attrs);
                Log.d(TAG, "Inflated view of type: " + view.getClass().getName());
                
                performBindings(bindingAttrs, view);
                
                return view;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Tried to bind view: " + name +
                        " but could not find bindable class: " + e.getMessage());
            }
        } else {       
            return null;
        }
    }
    
    private void performBindings(Map<String, String> attrBindings, View view) {
        PropertyProvider provider = propertyProviderFactory.create(view.getClass());
        
        for (Map.Entry<String, String> entry : attrBindings.entrySet()) {
            String bindingName = entry.getKey();
            String propertyName = entry.getValue();
            
            Property<?> property = provider.getBoundProperty(view, bindingName);
            if (property == null) {
                throw new RuntimeException("Unable to perform binding '" + bindingName +
                        "'='" + propertyName + "': Unknown property.");
            }
            registerProperty(propertyName, property);
        }
    }
    
    private void registerProperty(String propertyName, Property<?> property) {
        if (boundProperties.get(propertyName) == null) {
            boundProperties.put(propertyName, property);
        } else {
            throw new RuntimeException("Property already bound: " + propertyName + ". "
                    + "Support for multiple bindings will appear in a future version.");
        }
    }

    /**
     * Get the binding attributes. Returns a map similar to the following:
     * 
     * <pre>
     * { "textFrom" => "name", "textTo" => "inputName" }
     * </pre>
     * 
     * Meaning that bindings should be created from a property called "name"
     * to the text, and from the text to a property called "inputName".
     * 
     * This corresponds to the (attrName,attrValue) values from the XML.
     */
    private Map<String, String> getBindingAttrs(AttributeSet attrs) {
        Map<String, String> bindingAttrs = new HashMap<String, String>();
        
        int count = attrs.getAttributeCount();
        for (int i = 0; i < count; i++) {
            String attrName = attrs.getAttributeName(i);
            String attrValue = attrs.getAttributeValue(Constants.NAMESPACE, attrName);
            if (attrValue != null) {
                Log.d(TAG, "\tBinding attribute: " + attrName + " = " + attrValue);
                bindingAttrs.put(attrName, attrValue);
            }
        }
        
        if (!bindingAttrs.isEmpty()) {
            return bindingAttrs;
        } else {
            return null;
        }        
    }

    public boolean hasBindings(AttributeSet attrs) {
        return attrs.getAttributeBooleanValue(Constants.NAMESPACE, "bindable", false);
    }
}
