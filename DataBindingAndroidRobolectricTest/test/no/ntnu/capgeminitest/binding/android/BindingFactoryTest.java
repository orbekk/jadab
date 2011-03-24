package no.ntnu.capgeminitest.binding.android;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.HashMap;
import java.util.Map;

import no.ntnu.capgeminitest.binding.android.propertyprovider.PropertyProviderFactory;
import no.ntnu.capgeminitest.data.Property;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BindingFactoryTest {
    
    public class FakeViewFactory implements BindingFactory.ViewFactory {
        View view;
        
        public FakeViewFactory(View view) {
            this.view = view;
        }

        @Override
        public final View createView(String unusedName, String unusedPrefix,
                AttributeSet unusedAttr) {
            return view;
        }
    }
    
    public class TestBindingFactory extends BindingFactory {
        TestBindingFactory(PropertyProviderFactory propertyProviderFactory,
                ViewFactory viewFactory) {
            super(propertyProviderFactory, viewFactory);
        }
        
        @Override
        protected Map<String, String> getBindingAttrs(AttributeSet unused) {
            Map<String, String> bindingAttrs = new HashMap<String, String>();
            bindingAttrs.put("OnClickTo", "OnClickToTarget");
            return bindingAttrs;
        }
    }
    
    private View view;
    private FakeViewFactory viewFactory;
    private TestBindingFactory bindingFactory;
    
    @Before
    public void setUp() {
        view = new View(null);
        viewFactory = new FakeViewFactory(view);
        bindingFactory = new TestBindingFactory(PropertyProviderFactory.getDefaultFactory(),
                viewFactory);
    }
    
    @Test
    public void testOnClickProperty() {
        bindingFactory.onCreateView("View", null, null);
        Property<?> onClickProperty = bindingFactory.getBoundProperties()
                .get("OnClickToTarget");
        Object object1 = onClickProperty.get();
        view.performClick();
        assertThat(onClickProperty.get(), not(equalTo(object1)));
    }
}
