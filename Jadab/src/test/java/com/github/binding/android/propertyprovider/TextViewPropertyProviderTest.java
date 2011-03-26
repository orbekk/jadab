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

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.github.binding.Property;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.TextView;

import com.xtremelabs.robolectric.RobolectricTestRunner;


@RunWith(RobolectricTestRunner.class)
public class TextViewPropertyProviderTest {
    TextViewPropertyProvider provider = new TextViewPropertyProvider();
    TextView textView = new TextView(null);
    
    @Test public void testUnknownBindingName() {
        assertThat(provider.getBoundProperty(textView, "UnknownBindingName"),
                is(nullValue()));
    }
    
    @Test public void testProperty() {
        Property<?> property = provider.getBoundProperty(textView, "TextFrom");
        @SuppressWarnings("unchecked")
        Property<String> stringProperty = (Property<String>) property;
        stringProperty.set("What's up?");
        assertThat(textView.getText(), equalTo((CharSequence)"What's up?"));
    }
}
