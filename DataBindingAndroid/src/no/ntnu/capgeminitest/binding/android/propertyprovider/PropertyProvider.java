package no.ntnu.capgeminitest.binding.android.propertyprovider;

import android.view.View;
import no.ntnu.capgeminitest.binding.Property;

public interface PropertyProvider {
    /**
     * Return a property for the binding with name {@code bindingName}.
     * 
     * Example: For a bindingName such as "textTo" on a TextView, create a
     * property that will be updated when the text is changed.
     * 
     * The property will be bound to the view using.
     */
    Property<?> getBoundProperty(View view, String bindingName);
}
