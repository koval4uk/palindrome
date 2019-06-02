package com.epam.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.PalindromLookup;
import com.epam.Utils;

public class Test1 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		String text = Utils.loadFile("fixtures/input01.txt");
		String[] result = PalindromLookup.start(text);
		for(String s : result) {
			System.out.println(s);
		}
		// TODO: assert
		fail("Not yet implemented");
	}

}
