package com.luxoft.jva008.module01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringBuilderTutor {

	String[] animals = {"Cow", "Goose", "Cat", "Dog", "Elephant", "Hare", "Snake", "Chicken", "Horse", "Man"};

	/**
	 * The method should return a string:
	 * "List of animals: Cow, Goose, ..., Man."
	 * For implementation, use StringBuilder
	 */
	public String getAnimalsString() {
		return null;
	}

	@Test
	public void testGetAnimalsString() {
		String animalsString = getAnimalsString();
		assertEquals("List of animals: Cow, Goose, Cat, Dog, Elephant, Hare, Snake, Chicken, Horse, Man.", animalsString);
	}

}
