package no.ntnu.capgeminitest.data;

import java.util.List;
import java.util.ArrayList;

import no.ntnu.capgeminitest.event.PropertyChangeListener;

/**
 * Hold a property for a class.
 * 
 * A sophisticated wrapper for a property, supporting {@code PropertyChangeListener}s.
 * 
 * Used with the data binding framework.
 * 
 * @param <T>
 *            The type of this property.
 */
public class Property<T> {
    
    private T data;
    private List<PropertyChangeListener<T>> listeners = new ArrayList<PropertyChangeListener<T>>();

    public Property(T data) {
        this.data = data;
    }

    /**
     * @return The data contained in this property.
     */
    public T get() {
        return data;
    }

    /**
     * Set the data for this property.
     * 
     * Notifies listeners that the data was changed.
     */
    public void set(T data) {
        this.data = data;
        notifyListeners();
    }

    protected void notifyListeners() {
        for (PropertyChangeListener<T> listener : listeners) {
            listener.propertyChanged(this);
        }
    }

    public void addListener(PropertyChangeListener<T> listener) {
        listeners.add(listener);
    }

    public void removeListener(PropertyChangeListener<T> listener) {
        listeners.remove(listener);
    }
    
    /**
     * Override this method to receive property changes.
     * 
     * Called before other bindings are notified.
     * 
     * Note: Changing the property inside {@code onChange} triggers a recursive call.
     */
    protected void onChange(T newValue) {
        // Empty.
    }
}
