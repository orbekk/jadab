package no.ntnu.capgeminitest.binding.android.propertyprovider;

import no.ntnu.capgeminitest.data.Property;

public class ViewPropertyProvider extends AbstractPropertyProvider implements PropertyProvider {

    @Override
    public Property<?> getProperty(String bindingName) {
        return null;
    }

    @Override
    public Class<?> providerForClass() {
        return android.view.View.class;
    }

}
