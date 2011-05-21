package com.github.binding;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.github.binding.PropertyExtractor.CouldNotGetFieldException;


public class PropertyExtractorTest {
    class MyTest {
        public Property<Integer> x = new Property<Integer>(10);
        public Integer y = new Integer(5);
        @SuppressWarnings("unused")
        private Property<Integer> x2 = new Property<Integer>(20);
        Integer y2 = new Integer(5);
    }
    
    private PropertyExtractor extractor = new PropertyExtractor();
    private MyTest test = new MyTest();
        
    @Test public void testGetProperty() {
        @SuppressWarnings("unchecked")
        Property<Integer> p =
            (Property<Integer>)extractor.unsafeGetNamedProperty(test, "x");

        assertThat(p.get(), equalTo(10));
    }
    
    @Test(expected=CouldNotGetFieldException.class)
    public void testGetInvalidProperty1() {
        extractor.unsafeGetNamedProperty(test, "y");
    }
    
    @Test(expected=CouldNotGetFieldException.class)
    public void testGetInvalidProperty2() {
        extractor.unsafeGetNamedProperty(test, "x2");
    }
    
    @Test(expected=CouldNotGetFieldException.class)
    public void testGetInvalidProperty3() {
        extractor.unsafeGetNamedProperty(test, "y2");
    }
}
