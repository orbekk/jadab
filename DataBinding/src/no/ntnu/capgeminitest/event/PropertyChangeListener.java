package no.ntnu.capgeminitest.event;

import java.util.EventListener;
import no.ntnu.capgeminitest.data.Property;

/**
 * An event for a change of a property.
 * 
 * The property is of type {@Property<T>}.
 */
public interface PropertyChangeListener<T> extends EventListener {
    void propertyChanged(Property<T> property);
}
