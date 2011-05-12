package com.github.binding.android.propertyprovider.listener;

import com.github.binding.Property;

import android.text.Editable;
import android.text.TextWatcher;

public class TextWatcherProperty implements TextWatcher {
    public Property<String> property = new Property<String>(null);
    
    @Override
    public void afterTextChanged(Editable editable) {
        property.set(editable.toString());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
            int after) {
        // Empty definition.
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int count,
            int after) {
        // Empty definition. AfterTextChanged() is less restrictive.
    }

}
