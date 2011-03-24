package no.ntnu.capgeminitest.binding.android.propertyprovider;

import no.ntnu.capgeminitest.data.Property;

public interface PropertyProvider {
    /**
     * Return a property for the binding with name {@code bindingName}.
     * 
     * Example: For a bindingName such as "textTo" on a TextView, create a
     * property that will be updated when the text is changed.
     */
    Property<?> getProperty(String bindingName);
}
