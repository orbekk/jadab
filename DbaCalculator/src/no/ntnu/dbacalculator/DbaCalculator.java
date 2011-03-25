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

import no.ntnu.binding.android.BindingActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class DbaCalculator extends BindingActivity {
    public static final String TAG = "DbaCalculator";
    public static final String dbaNamespace = "http://org.ntnu.no/groups/capgeminitest/data-binding/";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        
        DbaCalculatorLogic logic = new DbaCalculatorLogic();
        setBoundContentView(R.layout.main);
        
        bind("DisplayText", logic.text);
        bind("IntrementButtonOnClick", logic.numberIncrementer);
        bind("DecrementButtonOnClick", logic.numberDecrementer);
    }
    
    public View calcOnCreateView(String name, Context context, AttributeSet attrs) {
        Log.d(TAG, "Creating view with name " + name + " and attributes: ");
        printAttributes(attrs);
        return null;
    }
    
    private void printAttributes(AttributeSet attrs) {
        int count = attrs.getAttributeCount();
        for (int i = 0; i < count; i++) {
            String attrName = attrs.getAttributeName(i);
            String attrValue = attrs.getAttributeValue(i);
            Log.d(TAG, "\t" + attrName + ": " + attrValue);
        }
    }
}