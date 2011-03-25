package no.ntnu.capgeminitest.dbacalculator;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DbaCalculatorLogicTest {
	private DbaCalculatorLogic logic = new DbaCalculatorLogic();
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testInitialState() {
		assertThat(logic.text.get(), equalTo("0"));
	}
	
	@Test
	public void testIncrement() {
		increment(50);
		assertThat(logic.text.get(), equalTo("50"));
	}
	
	@Test
	public void testDecrement() {
		decrement(10);
		assertThat(logic.text.get(), equalTo("-10"));
	}
	
	@Test
	public void testIncrementDecrement() {
		increment(20);
		decrement(10);
		increment(9);
		decrement(9);
		assertThat(logic.text.get(), equalTo("10"));
	}
	
	public void increment(int number) {
		for (int i = 0; i < number; i++) {
			logic.numberIncrementer.set(new Object());
		}
	}
	
	public void decrement(int number) {
		for (int i = 0; i < number; i++) {
			logic.numberDecrementer.set(new Object());
		}
	}
}
