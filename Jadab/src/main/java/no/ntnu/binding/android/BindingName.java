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

/**
 * TODO(orbekk): We should start using something like this instead of getting
 * one million bugs in the PropertyProviders due to stupid string constants!
 */
public enum BindingName {
    ON_CLICK_TO("OnClickTo");
    
    private String bindingName;
    
    private BindingName(String bindingName) {
        this.bindingName = bindingName;
    }
    
    public String getBindingName() {
        return bindingName;
    }
}
