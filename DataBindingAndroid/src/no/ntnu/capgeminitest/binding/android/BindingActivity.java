package no.ntnu.capgeminitest.binding.android;

import java.util.Map;
import no.ntnu.capgeminitest.data.Property;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

public abstract class BindingActivity extends Activity {
    
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
        LayoutInflater inflater = getLayoutInflater();
        BindingFactory factory = new BindingFactory(inflater);
        LayoutInflater bindingInflater = inflater.cloneInContext(this);
        bindingInflater.setFactory(factory);
        
        return bindingInflater;
    }
}
