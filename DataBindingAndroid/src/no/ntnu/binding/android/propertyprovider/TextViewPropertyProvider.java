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

package no.ntnu.binding.android.propertyprovider;

import no.ntnu.binding.Property;
import android.view.View;
import android.widget.TextView;

public class TextViewPropertyProvider extends AbstractPropertyProvider {

    @Override
    public Class<?> providerForClass() {
        return android.widget.TextView.class;
    }

    @Override
    public Property<?> getBoundProperty(View view, String bindingName) {
        final TextView textView = (TextView)view;
        
        if (bindingName.equals("TextFrom")) {
            Property<String> property = new Property<String>(null) {
              @Override protected void onChange(String newText) {
                  textView.setText(newText);
              }
            };
            return property;
        } else {
            return null;
        }
    }

}
