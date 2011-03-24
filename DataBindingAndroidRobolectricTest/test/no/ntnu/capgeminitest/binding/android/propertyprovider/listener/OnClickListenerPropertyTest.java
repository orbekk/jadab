package no.ntnu.capgeminitest.binding.android.propertyprovider.listener;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import no.ntnu.capgeminitest.data.Property;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.view.View;

import com.xtremelabs.robolectric.RobolectricTestRunner;


@RunWith(RobolectricTestRunner.class)
public class OnClickListenerPropertyTest {
    OnClickListenerProperty onClickListenerProperty = new OnClickListenerProperty();
    
    @Test
    public void testOnClickListenerProperty() {
        assertThat(onClickListenerProperty.property.get(), is(nullValue()));
        onClickListenerProperty.onClick(null);
        assertThat(onClickListenerProperty.property.get(), is(notNullValue()));
        Object object1 = onClickListenerProperty.property.get();
        onClickListenerProperty.onClick(null);
        assertThat(onClickListenerProperty.property.get(), not(equalTo(object1)));
    }
}
