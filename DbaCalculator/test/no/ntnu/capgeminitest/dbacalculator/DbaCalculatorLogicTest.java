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

package no.ntnu.capgeminitest.dbacalculator;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DbaCalculatorLogicTest {
    private DbaCalculatorLogic logic = new DbaCalculatorLogic();
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testInitialState() {
        assertThat(logic.text.get(), equalTo("0"));
    }
    
    @Test
    public void testIncrement() {
        increment(50);
        assertThat(logic.text.get(), equalTo("50"));
    }
    
    @Test
    public void testDecrement() {
        decrement(10);
        assertThat(logic.text.get(), equalTo("-10"));
    }
    
    @Test
    public void testIncrementDecrement() {
        increment(20);
        decrement(10);
        increment(9);
        decrement(9);
        assertThat(logic.text.get(), equalTo("10"));
    }
    
    public void increment(int number) {
        for (int i = 0; i < number; i++) {
            logic.numberIncrementer.set(new Object());
        }
    }
    
    public void decrement(int number) {
        for (int i = 0; i < number; i++) {
            logic.numberDecrementer.set(new Object());
        }
    }
}
