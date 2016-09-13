package edu.elon.test;

import static org.junit.Assert.*;

import java.text.NumberFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATMTest {
	private static final double DELTA = 1e-15;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDeposit() {
		ATM atm = new ATM(100);
		atm.deposit(-200);
		atm.deposit(50);
		double actual = atm.getBalance();
		double expected = 150;
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void testGetBalance() {
		ATM atm = new ATM(100);
		double actual = atm.getBalance();
		double expected = 100;
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void testToString() {
		ATM atm = new ATM(100);
		String expected = "Amount balance is " + NumberFormat.getCurrencyInstance().format(100);
		assertEquals(expected, atm.toString());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testWithdraw() {
		ATM atm = new ATM(100);
		atm.withdraw(500);
		atm.withdraw(50);
		double actual = atm.getBalance();
		double expected = 50;
		assertEquals(expected, actual, DELTA);
	}

}
