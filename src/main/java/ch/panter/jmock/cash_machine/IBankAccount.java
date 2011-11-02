package ch.panter.jmock.cash_machine;

/**
 * Account to deduct money, if you got enough.
 * @author oliver, patrice, rené, severin
 *
 */
public interface IBankAccount {

	/**
	 * Returns the Balance of the account.
	 * @return
	 */
	public int getBalance();

	/**
	 * Deducts the passed value from the account.
	 * @param value
	 */
	public void deduct(int value);
}
