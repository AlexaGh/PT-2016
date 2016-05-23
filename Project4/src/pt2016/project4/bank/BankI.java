package pt2016.project4.bank;

import java.util.List;
import java.util.Set;

public interface BankI {

	/**
	 * @precond person != null; account != null
	 * @postcond preSizeAccount +1 = postSizeAccounts;
	 * @param p
	 * @param accAsc
	 */
	public void addAccforPerson(Person p, Account accAsc);

	/**
	 * @precond person != null; accountId != null; sum > 0
	 * @postcond preSum > postSum
	 * @param sum
	 * @param accId
	 * @param p
	 */
	public void depositMoney(double sum, int accId, Person p);

	/**
	 * @precond person != null; accountId != null;
	 * @postcond hm
	 * @param sum
	 * @param accId
	 * @param p
	 */
	public void withdrawMoney(double sum, int accId, Person p);

	/**
	 * @precond person != null; accountId != 0
	 * @postcond preSizeAccount - 1 = postSizeAccounts;
	 * @param accId
	 * @param p
	 */
	public void deleteAccount(int accId, Person p);

	/**
	 * @precond p != null
	 * @postcond preNoPers < postNoPers
	 * @param p
	 */
	public void deletePerson(Person p);

	/**
	 * 
	 * @return
	 */
	public boolean isWellFormed();

	/**
	 * 
	 * @return
	 */
	public List<Person> displayAll();

	/**
	 * 
	 * @param p
	 * @return
	 */
	public Set<Account> displayAllACcounts(Person p);

}
