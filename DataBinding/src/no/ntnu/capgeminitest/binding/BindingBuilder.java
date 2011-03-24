package no.ntnu.capgeminitest.binding;

/**
 * Create (potentially unsafe) bindings between two properties.
 */
public class BindingBuilder<T> {
    Property<T> from;
    Property<T> to;
    boolean useConstantValue;
    T constantValue;
    
    public BindingBuilder<T> from(Property<T> from) {
        this.from = from;
        return this;
    }
    
    public BindingBuilder<T> to(Property<T> to) {
        this.to = to;
        return this;
    }
    
    public BindingBuilder<T> withDefaultValue(T defaultValue) {
        useConstantValue = true;
        this.constantValue = defaultValue;
        return this;
    }
    
    public void build() {
        if (from == null || to == null) {
            throw new RuntimeException("Cannot create binding: " + from + " -> " + to 
                    + ": Null object.");
        } else if (useConstantValue) {
            Property<T> intermediate = new Property<T>(constantValue) {
                @Override protected void onChange(Object unused) {
                    to.set(constantValue);
                }
            };
            from.bind(intermediate);
        } else {
            from.bind(to);
        }
    }
        
}
