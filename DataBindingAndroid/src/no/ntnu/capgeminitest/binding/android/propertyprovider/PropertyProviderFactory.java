package no.ntnu.capgeminitest.binding.android.propertyprovider;

import java.util.HashMap;
import java.util.Map;

import android.view.View;

public class PropertyProviderFactory {
    private Map<Class<?>, AbstractPropertyProvider> propertyProviders =
            new HashMap<Class<?>, AbstractPropertyProvider>(); 

    public PropertyProvider create(Class<?> viewClass) {
        PropertyProviderStack stack = new PropertyProviderStack();
        
        while (View.class.isAssignableFrom(viewClass)) {
            PropertyProvider provider = propertyProviders.get(viewClass);
            if (provider != null) {
                stack.addProvider(provider);
            }
            viewClass = viewClass.getSuperclass();
        }
        
        return stack;
    }
    
    public void addPropertyProvider(AbstractPropertyProvider provider) {
        propertyProviders.put(provider.providerForClass(), provider);
    }
    
    public static PropertyProviderFactory getDefaultFactory() {
        PropertyProviderFactory factory = new PropertyProviderFactory();
        factory.addPropertyProvider(new ViewPropertyProvider());
        factory.addPropertyProvider(new TextViewPropertyProvider());
        return factory;
    }
}
