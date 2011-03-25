/**
 * Copyright 2011 Kjetil Ørbekk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. See accompanying LICENSE file.
 */

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
