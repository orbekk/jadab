package no.ntnu.capgeminitest.binding.android.propertyprovider;

import android.view.View;
import no.ntnu.capgeminitest.binding.Property;
import no.ntnu.capgeminitest.binding.android.propertyprovider.listener.OnClickListenerProperty;

public class ViewPropertyProvider extends AbstractPropertyProvider {

    @Override
    public Property<?> getBoundProperty(View view, String bindingName) {
        if (bindingName.equals("OnClickTo")) {
            OnClickListenerProperty onClickListenerProperty = new OnClickListenerProperty();
            view.setOnClickListener(onClickListenerProperty);
            return onClickListenerProperty.property;
        } else if (bindingName.equals("OnClickFrom")) {
            final View view_ = view;
            Property<Object> property = new Property<Object>(null) {
              @Override protected void onChange(Object unused) {
                  view_.performClick();
              }
            };
            
            return property;
        } else {
            return null;
        }
    }

    @Override
    public Class<?> providerForClass() {
        return android.view.View.class;
    }

}
