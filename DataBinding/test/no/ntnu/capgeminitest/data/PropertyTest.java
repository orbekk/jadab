package no.ntnu.capgeminitest.data;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import no.ntnu.capgeminitest.event.PropertyChangeListener;

import org.junit.Before;
import org.junit.Test;

public class PropertyTest {

    class FakeListener implements PropertyChangeListener<Integer> {
        Integer received = null;

        @Override
        public void propertyChanged(Property<Integer> property) {
            received = property.get();
        }
    }
    
    class TestProperty extends Property<Integer> {
        Integer received = null;
        
        public TestProperty() { super(null); }
        
        @Override protected void onChange(Integer newValue) {
            received = newValue;
        }
    }

    private FakeListener listener = new FakeListener();
    Property<Integer> property;

    @Before
    public void setUp() {
        property = new Property<Integer>(5);
    }

    @Test
    public void testSetGet() {
        assertThat(property.get(), equalTo(5));
        property.set(10);
        assertThat(property.get(), equalTo(10));
    }

    @Test
    public void testListener() {
        property.addListener(listener);
        property.set(7);
        assertThat(listener.received, equalTo(7));
    }
    
    @Test
    public void testOnChange() {
        Property<Integer> property_ = new Property<Integer>(20) {
            @Override protected void onChange(Integer newValue) {
                assertThat(newValue, equalTo(25));
                assertThat(listener.received, equalTo(null));
            }
        };
        
        property_.addListener(listener);
        property_.set(25);
        assertThat(listener.received, equalTo(25));
    }
    
    @Test
    public void testBinding() {
        Property<Integer> source = new Property<Integer>(37);
        Property<Integer> target = new Property<Integer>(null);
        
        assertThat(target.get(), equalTo(null));
        source.bind(target);
        assertThat(target.get(), equalTo(37));
        source.set(83);
        assertThat(target.get(), equalTo(83));
    }
    
    @Test
    public void testBindingIsOneWay() {
        Property<Integer> source = new Property<Integer>(37);
        Property<Integer> target = new Property<Integer>(null);
        
        assertThat(target.get(), equalTo(null));
        assertThat(source.get(), equalTo(37));
        source.bind(target);
        assertThat(source.get(), equalTo(37));
        assertThat(target.get(), equalTo(37));
        
        target.set(103);
        assertThat(source.get(), equalTo(37));
        assertThat(target.get(), equalTo(103));
    }
    
    @Test
    public void testOnChangeBinding() {
        Property<Integer> source = new Property<Integer>(15);
        TestProperty target = new TestProperty();
        
        assertThat(target.received, equalTo(null));
        
        source.bind(target);
        assertThat(target.received, equalTo(15));

        source.set(35);
        assertThat(target.received, equalTo(35));
    }
    
    @Test
    public void testMultipleTargets() {
        Property<Integer> source = new Property<Integer>(38);
        Property<Integer> target1 = new Property<Integer>(null);
        Property<Integer> target2 = new Property<Integer>(null);
        
        source.bind(target1);
        source.bind(target2);

        assertThat(target1.get(), equalTo(38));
        assertThat(target2.get(), equalTo(38));
        
        source.set(1);
        assertThat(target1.get(), equalTo(1));
        assertThat(target2.get(), equalTo(1));
    }
}
