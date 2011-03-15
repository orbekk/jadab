package no.ntnu.capgeminitest.data;

public class Property<T> {
	T data;
	
	public Property(T data) {
		this.data = data;
	}
	
	public T get() {
		return data;
	}
	
	public void set(T data) {
		this.data = data;
	}
}
