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

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.testrunner.JadabTestRunner;

@RunWith(JadabTestRunner.class)
public class OnClickListenerPropertyTest {
    OnClickListenerProperty onClickListenerProperty = new OnClickListenerProperty();
    
    @Test
    public void testOnClickListenerProperty() {
        assertThat(onClickListenerProperty.property.get(), is(nullValue()));
        onClickListenerProperty.onClick(null);
        assertThat(onClickListenerProperty.property.get(), is(notNullValue()));
        Object object1 = onClickListenerProperty.property.get();
        onClickListenerProperty.onClick(null);
        assertThat(onClickListenerProperty.property.get(), not(equalTo(object1)));
    }
}
