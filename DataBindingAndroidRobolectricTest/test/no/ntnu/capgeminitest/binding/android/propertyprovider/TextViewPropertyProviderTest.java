package no.ntnu.capgeminitest.binding.android.propertyprovider;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import no.ntnu.capgeminitest.binding.Property;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.TextView;

import com.xtremelabs.robolectric.RobolectricTestRunner;


@RunWith(RobolectricTestRunner.class)
public class TextViewPropertyProviderTest {
    TextViewPropertyProvider provider = new TextViewPropertyProvider();
    TextView textView = new TextView(null);
    
    @Test public void testUnknownBindingName() {
        assertThat(provider.getBoundProperty(textView, "UnknownBindingName"),
                is(nullValue()));
    }
    
    @Test public void testProperty() {
        Property<?> property = provider.getBoundProperty(textView, "TextFrom");
        @SuppressWarnings("unchecked")
        Property<String> stringProperty = (Property<String>) property;
        stringProperty.set("What's up?");
        assertThat(textView.getText(), equalTo((CharSequence)"What's up?"));
    }
}
