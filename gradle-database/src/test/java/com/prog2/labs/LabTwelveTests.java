package com.prog2.labs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * DO NOT MODIFY ANYTHING IN THIS FILE.
 */
class LabTwelveTests {

	@Test
	void numberOfBoomerangsTest1() {
		int[][] input = {{0, 0}, {1, 0}, {2, 0}};

		assertEquals(2, LabTwelve.numberOfBoomerangs(input));
	}
	
	@Test
	void numberOfBoomerangsTest2() {
		int[][] input = {{1, 1}, {2, 2}, {3, 3}};

		assertEquals(2, LabTwelve.numberOfBoomerangs(input));
	}
	
	@Test
	void numberOfBoomerangsTest3() {
		int[][] input = {{1, 1}};

		assertEquals(0, LabTwelve.numberOfBoomerangs(input));
	}
	
	@Test
	void numberOfBoomerangsTest4() {
		int[][] input = {{2, 3}, {4, 4}, {3, 5}};

		assertEquals(2, LabTwelve.numberOfBoomerangs(input));
	}
	
	
}	