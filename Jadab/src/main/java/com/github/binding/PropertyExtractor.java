package com.github.binding;

import java.lang.reflect.Field;

public class PropertyExtractor {

    public class CouldNotGetFieldException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public CouldNotGetFieldException(String message) {
            super(message);
        }
    }
    
    /**
     * Get a property member of an object.
     * 
     * This method finds the property {@code object.name}, if such a property
     * exists. Otherwise, a RuntimeException is thrown, hence the "unsafe".
     */
    public Property<?> unsafeGetNamedProperty(Object object, String name) {
        Object maybeProperty = getFieldValue(object, name);
        if (maybeProperty instanceof Property<?>) {
            return (Property<?>)maybeProperty;
        } else {
            throw new CouldNotGetFieldException("" + object + " has field '" + name +
                    "', but it is not a Property");
        }
    }
    
    private Object getFieldValue(Object object, String name)
            throws CouldNotGetFieldException {
        try {
            Class<?> clazz = object.getClass();
            Field field = clazz.getField(name);
            return field.get(object);
        } catch (SecurityException e) {
            throw new CouldNotGetFieldException("No access: " + name);
        } catch (NoSuchFieldException e) {
            throw new CouldNotGetFieldException("No field named " + name);
        } catch (IllegalArgumentException e) {
            throw new CouldNotGetFieldException("Illegal argument: " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new CouldNotGetFieldException("Illegal access: " + e.getMessage());
        }
    }
}
