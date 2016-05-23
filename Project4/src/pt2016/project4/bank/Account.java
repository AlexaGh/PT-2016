package pt2016.project4.bank;

import java.io.Serializable;
import java.util.Observable;

// va fi abstracta, la fel ca metoda de add money

public abstract class Account extends Observable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int accountId;
	protected double money;
	protected String type;

	public Account(int id, double money, String type) {
		this.accountId = id;
		this.money = money;
		this.type = type;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		// long temp;
		// temp = Double.doubleToLongBits(money);
		// result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (Double.doubleToLongBits(money) != Double.doubleToLongBits(other.money))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", money=" + money + "]";
	}

	public abstract void addMoney(double sum);

	public abstract void withdrawMoney(double sum);
}
