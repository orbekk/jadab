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

package com.github.binding.android.propertyprovider.listener;

import com.github.binding.Property;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * Set a property on every click event.
 * 
 * Creates a new dummy object every time a click event is received.
 */
public class OnClickListenerProperty implements OnClickListener {
    public Property<Object> property = new Property<Object>(null);
    
    public void onClick(View v) {
        property.set(new Object());
    }
}
