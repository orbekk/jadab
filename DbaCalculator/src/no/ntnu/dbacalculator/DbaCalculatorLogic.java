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

package no.ntnu.dbacalculator;

import no.ntnu.binding.Property;

public class DbaCalculatorLogic {
    public Property<String> text;
    
    private Property<Integer> number = new Property<Integer>(0) {
        @Override protected void onChange(Integer newValue) {
            text.set(""+newValue);
        }
    };
    
    public Property<Object> numberIncrementer = new Property<Object>(null) {
        @Override protected void onChange(Object unused) {
            number.set(number.get() + 1);
        }
    };
    
    public Property<Object> numberDecrementer = new Property<Object>(null) {
        @Override protected void onChange(Object unused) {
            number.set(number.get() - 1);
        }
    };
    
    public DbaCalculatorLogic() {
        text = new Property<String>(""+number.get());        
    }
}
