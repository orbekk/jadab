package no.ntnu.capgeminitest.binding.android.propertyprovider;

import no.ntnu.capgeminitest.binding.Property;
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
