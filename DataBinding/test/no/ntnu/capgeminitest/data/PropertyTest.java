package no.ntnu.capgeminitest.data;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;


public class PropertyTest {
	@Test public void testSetGet() {
		Property<Integer> property= new Property<Integer>(5);
		assertThat(property.get(), equalTo(5));
		property.set(10);
		assertThat(property.get(), equalTo(10));
	}
}
