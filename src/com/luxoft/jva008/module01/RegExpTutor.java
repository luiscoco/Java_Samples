package com.luxoft.jva008.module01;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RegExpTutor {

	public Email getEmail(String emailString) {
		return new Email();
	}

	/**
	 * Returns a list of strings according to the text representation of strings:
	 * Takes a string
	 * "List of animals: Cow, Goose, Cat, Dog, Elephant, Hare, Snake, Hen, Horse, Man."
	 * And returns an array of individual animals
	 */
	public String[] getAnimalsArray(String animalsString) {
		return new String[]{};
	}

	@Test
	public void testGetEmail() {
		Email email = getEmail("ivanov@mail.ru");
		assertEquals("ivanov", email.name);
		assertEquals("mail", email.domainName);
		assertEquals("ru", email.domainZone);

	}

	@Test
	public void testGetAnimalsArray() {
		String[] animals = {"Cow", "Goose", "Cat", "Dog", "Elephant", "Hare", "Snake", "Chicken", "Horse", "Man"};
		String animalsString = "List of animals: Cow, Goose, Cat, Dog, Elephant, Hare, Snake, Hen, Horse, Man.";
		assertArrayEquals(animals, getAnimalsArray(animalsString));
	}

	class Email {
		String name;
		String domainName;
		String domainZone;
	}

}
