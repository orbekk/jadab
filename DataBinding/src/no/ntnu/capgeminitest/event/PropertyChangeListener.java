package no.ntnu.capgeminitest.event;

import java.util.EventListener;
import no.ntnu.capgeminitest.data.Property;

public interface PropertyChangeListener extends EventListener {
	void propertyChanged(Property property);
}
