package no.ntnu.capgeminitest.data;

import java.util.List;
import java.util.ArrayList;

import no.ntnu.capgeminitest.event.PropertyChangeListener;

/**
 * Hold a property for a class.
 * 
 * A sophisticated wrapper for a property, allowing event handling that can be
 * used with the data binding interface.
 * 
 * @param <T>
 *            The type of this property.
 */
public class Property<T> {
    T data;
    List<PropertyChangeListener<T>> listeners = new ArrayList<PropertyChangeListener<T>>();

    public Property(T data) {
        this.data = data;
    }

    public T get() {
        return data;
    }

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
}
