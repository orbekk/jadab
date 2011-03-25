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

package no.ntnu.capgeminitest.binding;

/**
 * Create (potentially unsafe) bindings between two properties.
 */
public class BindingBuilder<T> {
    Property<T> from;
    Property<T> to;
    boolean useConstantValue;
    T constantValue;
    
    public BindingBuilder<T> from(Property<T> from) {
        this.from = from;
        return this;
    }
    
    public BindingBuilder<T> to(Property<T> to) {
        this.to = to;
        return this;
    }
    
    public BindingBuilder<T> withConstantValue(T defaultValue) {
        useConstantValue = true;
        this.constantValue = defaultValue;
        return this;
    }
    
    public void build() {
        if (from == null || to == null) {
            throw new RuntimeException("Cannot create binding: " + from + " -> " + to 
                    + ": Null object.");
        } else if (useConstantValue) {
            Property<T> intermediate = new Property<T>(constantValue) {
                @Override protected void onChange(Object unused) {
                    to.set(constantValue);
                }
            };
            from.bind(intermediate);
        } else {
            from.bind(to);
        }
    }
        
}
