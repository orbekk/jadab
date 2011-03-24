package no.ntnu.capgeminitest.dbacalculator;

import no.ntnu.capgeminitest.binding.Property;

public class DbaCalculatorLogic {
    Integer number = 0;
    public Property<String> text;
    
    public Property<Object> numberIncrementer = new Property<Object>(null) {
        @Override protected void onChange(Object unused) {
            incrementNumber();
        }
    };
    
    public DbaCalculatorLogic() {
        text = new Property<String>(""+number);        
    }
    
    public void incrementNumber() {
        number += 1;
        updateText();
    }
    
    public void updateText() {
        text.set(""+number);
    }
}
