/**
 * Copyright 2011 Kjetil Ørbekk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. See accompanying LICENSE file.
 */

package no.ntnu.capgeminitest.binding;

import java.util.List;
import java.util.ArrayList;

import no.ntnu.capgeminitest.event.PropertyChangeListener;
import no.ntnu.capgeminitest.util.ObjectUtil;

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
    
    /**
     * A listener that is used to update this property.
     * 
     * When this property is bound to another property, it will listen to
     * changes to the other property and update itself on change.
     */
    private class OnPropertyChangeUpdater implements PropertyChangeListener<T> {
        @Override public void propertyChanged(Property<T> property) {
            set(property.get());
        }      
    }
    
    private T data;
    private List<PropertyChangeListener<T>> listeners = new ArrayList<PropertyChangeListener<T>>();
    private OnPropertyChangeUpdater updateListener = new OnPropertyChangeUpdater();
    
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
     * Override this method to receive property changes.
     * 
     * Called before other bindings are notified.
     * 
     * Note: Changing the property inside {@code onChange} triggers a recursive call.
     */
    protected void onChange(T newValue) {
        // Empty.
    }
    
    /** 
     * Create a binding between this property and {@code other}.
     * 
     * Immediately notify {@code other} of our value, unless our value is null.
     */
    public void bind(Property<T> other) {
        PropertyChangeListener<T> listener = other.getOnPropertyChangeUpdater();
        addListener(listener);
        if (get() != null) {
            listener.propertyChanged(this);
        }
    }
    
    /**
     * Create a binding builder with this as the source.
     * 
     * Example:
     * <pre>
     * {@code
     * property.bind().to(anotherProperty).build();
     * }
     * </pre>
     */
    public BindingBuilder<T> bind() {
        return new BindingBuilder<T>().from(this);
    }
    
    /**
     * Set the data for this property.
     * 
     * Notifies listeners that the data was changed.
     */
    public void set(T data) {
        if (ObjectUtil.equals(this.data, data)) {
            this.data = data;
        } else {
            this.data = data;
            onChange(data);
            notifyListeners();
        }
    }

    protected void notifyListeners() {
        for (PropertyChangeListener<T> listener : listeners) {
            listener.propertyChanged(this);
        }
    }

    void addListener(PropertyChangeListener<T> listener) {
        listeners.add(listener);
    }

    void removeListener(PropertyChangeListener<T> listener) {
        listeners.remove(listener);
    }
    
    PropertyChangeListener<T> getOnPropertyChangeUpdater() {
        return updateListener;
    }
}
