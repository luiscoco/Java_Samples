package com.luxoft.jva008.module01;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static com.luxoft.jva008.Logger.log;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class OverflowTutor {

	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();

	/**
	 * Multiply 2 numbers, excite ArithmeticException in case of overflow
	 */
	public Integer multiply(int a, int b) {
		//TODO your code goes here
		return 0;
	}

	@Test
	public void testOverflow() {
		int i1 = 34524235;
		int i2 = 23423423;
		int overflowed = i1 * i2;
		log("i1*i2=" + overflowed);
		catchException(this).multiply(i1, i2);
		errorCollector.checkThat(caughtException(), instanceOf(ArithmeticException.class));
	}

	@Test
	public void testSum() {
		Double d = Double.POSITIVE_INFINITY * 10;
		log("doubleMultiply=" + d);
	}

}
