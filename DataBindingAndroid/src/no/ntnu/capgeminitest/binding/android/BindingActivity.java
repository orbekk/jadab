package no.ntnu.capgeminitest.binding.android;

import java.util.Map;

import no.ntnu.capgeminitest.binding.Property;
import no.ntnu.capgeminitest.binding.android.propertyprovider.PropertyProviderFactory;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

public abstract class BindingActivity extends Activity {
    
    private PropertyProviderFactory propertyProviderFactory =
            PropertyProviderFactory.getDefaultFactory();
    
    /**
     * Set content view from a layout resource.
     * 
     * This is the
     */
    public View createBindingView(int id, Map<String, Property<?>> bindings) {
        return getBindingLayoutInflater().inflate(id, null);
    }
    
    public void setContentViewWithBindings(int id, Map<String, Property<?>> bindings) {
        setContentView(createBindingView(id, bindings));
    }
    
    private LayoutInflater getBindingLayoutInflater() {
        LayoutInflater inflater = getLayoutInflater().cloneInContext(this);
        BindingFactory factory = new BindingFactory(propertyProviderFactory, inflater);
        inflater.setFactory(factory);
        
        return inflater;
    }
}
