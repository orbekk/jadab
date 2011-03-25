package no.ntnu.capgeminitest.dbacalculator;

import no.ntnu.capgeminitest.binding.Property;

public class DbaCalculatorLogic {
	public Property<String> text;
	
	private Property<Integer> number = new Property<Integer>(0) {
		@Override protected void onChange(Integer newValue) {
			text.set(""+newValue);
		}
	};
    
    public Property<Object> numberIncrementer = new Property<Object>(null) {
        @Override protected void onChange(Object unused) {
        	number.set(number.get() + 1);
        }
    };
    
    public Property<Object> numberDecrementer = new Property<Object>(null) {
    	@Override protected void onChange(Object unused) {
    		number.set(number.get() - 1);
    	}
    };
    
    public DbaCalculatorLogic() {
        text = new Property<String>(""+number.get());        
    }
}
