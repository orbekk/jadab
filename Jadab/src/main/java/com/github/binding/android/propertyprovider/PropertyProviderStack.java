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

package com.github.binding.android.propertyprovider;

import java.util.ArrayList;
import java.util.List;

import com.github.binding.Property;

import android.view.View;


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
    public Property<?> getBoundProperty(View view, String bindingName) {
        for (PropertyProvider provider : providers) {
            Property<?> property = provider.getBoundProperty(view, bindingName);
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
