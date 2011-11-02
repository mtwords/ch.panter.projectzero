package ch.panter.jmock.cash_machine;

/**
 * 
 * @author oliver, patrice, rené, severin
 */
public class Withdrawal {

	private IBankAccount account;
	private int amount;
	private boolean executed;

	public void executeDeduction() {
		if (account.getBalance() < amount) {
			throw new RuntimeException("not enough money");
		}

		account.deduct(amount);
		executed = true;
	}

	public IBankAccount getAccount() {
		return account;
	}
	public void setAccount(IBankAccount account) {
		this.account = account;
	}

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isExecuted() {
		return executed;
	}

}
