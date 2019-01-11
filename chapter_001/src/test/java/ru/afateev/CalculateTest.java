package ru.afateev;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculateTest {
	
	@Test
	public void whenSetStopThenReturnThreeStop() {
		Calculate calc = new Calculate();
		String result = calc.echo("stop");
		assertThat(result, is("stop stop stop"));
	}
	
}
