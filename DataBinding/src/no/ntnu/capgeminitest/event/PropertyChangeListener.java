package no.ntnu.capgeminitest.event;

import java.util.EventListener;
import no.ntnu.capgeminitest.data.Property;

public interface PropertyChangeListener<T> extends EventListener {
    void propertyChanged(Property<T> property);
}
