package no.ntnu.capgeminitest.binding.android.propertyprovider;

import java.util.ArrayList;
import java.util.List;

import no.ntnu.capgeminitest.data.Property;

/**
 * Combines several {@code PropertyProvider}s to a single PropertyProvider.
 * 
 * Add your {@code PropertyProvider}s to the stack in the same order you want
 * the lookup.
 * 
 * Example:
 *
 * <pre>
 * {@code
 * PropertyProvider a, b;
 * PropertyProviderStack stack;
 * 
 * stack.addProvider(a);
 * stack.addProvider(b):
 * 
 * Property<?> property = stack.getProperty(x);
 *  
 * // Is roughly the same as: 
 * Property<?> property_ = a.getProperty(x);
 * if (property_ == null) {
 *     property_ = b.getProperty(x);
 * }
 * }
 * </pre>
 */
public class PropertyProviderStack implements PropertyProvider {

    private List<PropertyProvider> providers = new ArrayList<PropertyProvider>();
    
    @Override
    public Property<?> getProperty(String bindingName) {
        for (PropertyProvider provider : providers) {
            Property<?> property = provider.getProperty(bindingName);
            if (property != null) {
                return property;
            }
        }
        
        return null;
    }

    public void addProvider(PropertyProvider provider) {
        providers.add(provider);
    }
}
