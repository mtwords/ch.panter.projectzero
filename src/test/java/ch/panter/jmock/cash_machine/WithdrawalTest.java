package ch.panter.jmock.cash_machine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class WithdrawalTest {

	Mockery context;
	// class unter test
	Withdrawal withdrawal;
	// mock object
	IBankAccount account;

	@Before
	public void initialize() {
		context = new JUnit4Mockery();
		withdrawal = new Withdrawal();
		withdrawal.setAmount(1500);
		account = context.mock(IBankAccount.class);
		withdrawal.setAccount(account);
	}

	@Test
	public void failExecutionIfBalanceInadequate() {
		context.checking(new Expectations() {
			{
				one(account).getBalance();
				will(returnValue(1000));
			}
		});

		boolean exceptionThrown = false;

		try {
			withdrawal.executeDeduction();
		} catch (RuntimeException e) {
			// success
			exceptionThrown = true;
		}
		assertTrue("Should have thrown: " + RuntimeException.class,
				exceptionThrown);
	}

	@Test
	public void executeWithdrawChangesBalanceAndSetsExecuted() {
		context.checking(new Expectations() {
			{
				ignoring(account).getBalance();
				will(returnValue(2500));
				one(account).deduct(with(equal(1500)));
			}
		});

		withdrawal.executeDeduction();

		assertEquals(true, withdrawal.isExecuted());
	}

	@Test
	public void methodThatWeExpectWillThrowAnException() {
		boolean expectedThrown = false;

		try {
			throw new RuntimeException();
		} catch (RuntimeException e) {
			expectedThrown = true;
		}

		assertTrue(expectedThrown);
	}
}
