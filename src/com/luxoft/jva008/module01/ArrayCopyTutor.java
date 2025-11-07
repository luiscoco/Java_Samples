package com.luxoft.jva008.module01;

import org.junit.Assert;
import org.junit.Test;

import static com.luxoft.jva008.Logger.log;

/**
 * This class does the same as the standard ArrayList does:
 * Increases the size of the array when the array is full.
 * <p>
 * Implement the deleteAnimal (int position)
 */
public class ArrayCopyTutor {
	int animals_capacity = 5;
	int animals_expand_by = 5;
	int animals_size = 0;
	String[] animals = new String[animals_capacity];

	public void addAnimal(String animal) {
		// TODO write your implementation here
	}

	private void expandAnimalsArray() {
		// TODO write your implementation here
	}

	public void insertAnimal(int position, String animal) {
		// TODO write your implementation here
	}

	public void deleteAnimal(int position) {
		// TODO write your implementation here
	}

	public void showAnimals() {
		for (int i = 0; i < animals_size; i++) {
			log(i + ") " + animals[i]);
		}
	}

	@Test
	public void testAnimals() {
		addAnimal("Horse");
		addAnimal("Rhino");
		addAnimal("Dog");
		addAnimal("Snake");
		addAnimal("Monkey");
		addAnimal("Turkey");
		addAnimal("Roe");
		addAnimal("Lion");
		addAnimal("Tiger");
		addAnimal("Cat");
		addAnimal("Turtle");
		insertAnimal(1, "Human");
		deleteAnimal(2);
		showAnimals();
		Assert.assertArrayEquals(new String[]{
				"Horse",
				"Human",
				"Dog",
				"Snake",
				"Monkey",
				"Turkey",
				"Roe",
				"Lion",
				"Tiger",
				"Cat",
				"Turtle",
				null, null, null, null // we need that nulls because array grows by 5
		}, animals);
	}

}
