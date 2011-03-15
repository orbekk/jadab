package no.ntnu.capgeminitest.data;

import java.util.List;
import java.util.ArrayList;

import no.ntnu.capgeminitest.event.PropertyChangeListener;

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
