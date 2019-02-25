package test.course.oop.tictactoe.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.course.oop.tictactoe.util.TwoDArray;

class TwoDArrayTest {

	TwoDArray testArr;
	
	@BeforeEach
	void setUp() throws Exception {
		testArr = new TwoDArray(2,2,-1);
		System.out.println("before each");
	}

	@Test
	void testInsertInt() {
		String retVal = testArr.insertInt(0, 1, 8);
		assertEquals(retVal, "Success! 8 was inserted.");
	}

	@Test
	void testGetInt() {
		testArr.insertInt(0, 1, 17);
		int retVal = testArr.getInt(0, 1);
		assertEquals(retVal, 17);
	}
}
