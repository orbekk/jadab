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

import com.github.binding.Property;

import android.view.View;

public interface PropertyProvider {
    /**
     * Return a property for the binding with name {@code bindingName}.
     * 
     * Example: For a bindingName such as "textTo" on a TextView, create a
     * property that will be updated when the text is changed.
     * 
     * The property will be bound to the view using.
     */
    Property<?> getBoundProperty(View view, String bindingName);
}
