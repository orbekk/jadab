package no.ntnu.capgeminitest.binding.android.propertyprovider;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import no.ntnu.capgeminitest.data.Property;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class PropertyProviderStackTest {
    
    public class FakePropertyProvider implements PropertyProvider {
        public String bindingName;
        public Property<?> property;
        
        public FakePropertyProvider(String bindingName, Property<?> property) {
            this.bindingName = bindingName;
            this.property = property;
        }
        
        @Override
        public Property<?> getProperty(String bindingName) {
            assertThat(bindingName, equalTo(this.bindingName));
            return property;
        }
    }
    
    private PropertyProviderStack stack = new PropertyProviderStack();
    private FakePropertyProvider pp1 = new FakePropertyProvider(
            "bindingName1", new Property<String>("property1"));
    private FakePropertyProvider pp2 = new FakePropertyProvider(
            "bindingName1", new Property<String>("property2"));
    private FakePropertyProvider pp3 = new FakePropertyProvider(
            "bindingName2", new Property<String>("property3"));
    
    @Test
    public void testSingleProvider() {
        stack.addProvider(pp1);
        assertThat((String)stack.getProperty("bindingName1").get(), equalTo("property1"));
    }
    
}
