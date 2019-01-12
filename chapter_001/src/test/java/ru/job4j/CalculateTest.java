package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
* Test
*
* @author Aleksandr Fateev
* @version 1.1
* @since 1.0
*/
public class CalculateTest {

/**
* Test echo.
*/
	@Test
	public void whenTakenNameThenThreeEchoPlusName() {
		String input = "Aleksnadr Fateev";
		String expect = "Echo, echo, echo : Aleksnadr Fateev";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
	
}
