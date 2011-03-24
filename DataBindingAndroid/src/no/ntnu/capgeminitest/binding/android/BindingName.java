package no.ntnu.capgeminitest.binding.android;

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
