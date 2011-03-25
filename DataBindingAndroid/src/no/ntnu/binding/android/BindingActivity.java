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

package no.ntnu.binding.android;

import java.util.HashMap;
import java.util.Map;

import no.ntnu.binding.Property;
import no.ntnu.binding.android.propertyprovider.PropertyProviderFactory;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BindingActivity extends Activity {
    
    private Map<String, Property<?>> bindings = new HashMap<String, Property<?>>();
    
    public class BindingLayoutInflater {
        private LayoutInflater inflater;
        private BindingFactory bindingFactory;
        
        public BindingLayoutInflater(LayoutInflater inflater, BindingFactory bindingFactory) {
            this.inflater = inflater;
            this.bindingFactory = bindingFactory;
        }
        
        public View inflate(int resource, ViewGroup root) {
            return inflater.inflate(resource, root);
        }
        
        public Map<String, Property<?>> getBoundProperties() {
            return bindingFactory.getBoundProperties();
        }
    }
    
    private PropertyProviderFactory propertyProviderFactory =
            PropertyProviderFactory.getDefaultFactory();
    
    /**
     * Set content view from a layout resource.
     * 
     * This is the
     */
    public View createBoundView(int id) {
        BindingLayoutInflater inflater = getBindingLayoutInflater();
        View v = inflater.inflate(id, null);
        bindings.putAll(inflater.getBoundProperties());
        return v;
    }
    
    public void setBoundContentView(int id) {
        setContentView(createBoundView(id));
    }
    
    private BindingLayoutInflater getBindingLayoutInflater() {
        LayoutInflater inflater = getLayoutInflater().cloneInContext(this);
        BindingFactory factory = new BindingFactory(propertyProviderFactory, inflater);
        inflater.setFactory(factory);
        
        return new BindingLayoutInflater(inflater, factory);
    }
    
    @SuppressWarnings("unchecked")
    protected void bind(String propertyXmlName, Property property) {
        if (bindings.get(propertyXmlName) == null) {
            throw new RuntimeException("Could not bind " + propertyXmlName +
                    ": Binding not found.");
        }
        
        Property source = bindings.get(propertyXmlName);
        source.bind(property);
        property.bind(source);
    }
    
    @SuppressWarnings("unchecked")
    protected void bind(String propertyXmlName, Property property, Object constantValue) {
        if (bindings.get(propertyXmlName) == null) {
            throw new RuntimeException("Could not bind " + propertyXmlName +
                    ": Binding not found.");
        }
        
        Property source = bindings.get(propertyXmlName);
        source.bind().to(property).withConstantValue(constantValue).build();
        property.bind().to(source).withConstantValue(constantValue);
    }       
}
