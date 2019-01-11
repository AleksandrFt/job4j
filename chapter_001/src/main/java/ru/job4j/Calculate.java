package ru.job4j;

/**
* Class that repeats string 3 times.
* @author afateev
* @since 11.01.2019
* @version 1.0
*/
public class Calculate {

/**
* Method echo.
* @param value string
* @return Repeat your string 3 times.
*/
	public String echo(String value) {
		return String.format("%s %s %s", value, value, value);
	}
	
/**
* Method main.
* @param args args
*/
	public static void main (String[] args) {
		Calculate calc = new Calculate();
		System.out.println(calc.echo("ahh"));
	}
}
