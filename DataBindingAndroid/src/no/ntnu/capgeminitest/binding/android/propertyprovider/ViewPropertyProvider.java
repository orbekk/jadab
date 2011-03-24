package no.ntnu.capgeminitest.binding.android.propertyprovider;

import static no.ntnu.capgeminitest.binding.android.BindingName.*;

import android.view.View;
import no.ntnu.capgeminitest.binding.android.propertyprovider.listener.OnClickListenerProperty;
import no.ntnu.capgeminitest.data.Property;

public class ViewPropertyProvider extends AbstractPropertyProvider implements PropertyProvider {

    @Override
    public Property<?> getBoundProperty(View view, String bindingName) {
        if (bindingName.equals("OnClickTo")) {
            OnClickListenerProperty onClickListenerProperty = new OnClickListenerProperty();
            view.setOnClickListener(onClickListenerProperty);
            return onClickListenerProperty.property;
        } else {
            return null;
        }
    }

    @Override
    public Class<?> providerForClass() {
        return android.view.View.class;
    }

}
