package no.ntnu.capgeminitest.binding.android.propertyprovider;

import no.ntnu.capgeminitest.data.Property;

abstract public class PropertyProvider {
    abstract public Property<?> getSourcePropertyFor(String propertyName);
    abstract public Property<?> getTargetPropertyFor(String propertyName);
}
