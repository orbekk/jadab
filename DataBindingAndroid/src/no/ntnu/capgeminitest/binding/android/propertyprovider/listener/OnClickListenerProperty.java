package no.ntnu.capgeminitest.binding.android.propertyprovider.listener;

import android.view.View;
import android.view.View.OnClickListener;
import no.ntnu.capgeminitest.binding.Property;

/**
 * Set a property on every click event.
 * 
 * Creates a new dummy object every time a click event is received.
 */
public class OnClickListenerProperty implements OnClickListener {
    public Property<Object> property = new Property<Object>(null);
    
    public void onClick(View v) {
        property.set(new Object());
    }
}
