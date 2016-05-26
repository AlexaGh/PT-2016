package pt2016.project4.bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bank implements BankI, Serializable {
	private static final long serialVersionUID = -7542263365491824099L;
	
	private Map<Person, Set<Account>> map;
	private Serialize serializ;
	
	public Bank() {
		serializ = new Serialize();
		this.map = new HashMap<>();
		map = serializ.readAllData();
	}

	public Map<Person, Set<Account>> getMap() {
		return map;
	}

	public void setMap(Map<Person, Set<Account>> map) {
		this.map = map;
	}

	public void addAccforPerson(Person p, Account accAsc) {

		assert isWellFormed() : "Isn't well formed";
		assert p == null : "The person should't be null";
		assert accAsc != null : "The account shouldn't be null";

		int preSizeAccount = 0;
		int postSizeAccpunts = 0;

		if (map.containsKey(p)) {

			Set<Account> accounts = map.get(p);
			preSizeAccount = accounts.size();
			accounts.add(accAsc);

		} else {
			Set<Account> accounts = new HashSet<>();
			accounts.add(accAsc);
			map.put(p, accounts);
		}
		accAsc.addObserver(p);

		postSizeAccpunts = map.get(p).size();

		assert preSizeAccount + 1 == postSizeAccpunts : "Account was not added";
		//assert preSizeAccount <= postSizeAccpunts: "Account was not added";
		assert isWellFormed() : "Isn't well formed";
		serializ.reloadBank(map);
	}

	public void depositMoney(double sum, int accId, Person p) {

		assert isWellFormed() : "Isn't well formed";
		assert p != null : "The person should't be null";
		assert accId != 0 : "The account id shouldn't be 0";
		assert sum > 0 : "Money should be a positive sum";

		double preSum = 0;
		double postSum = 0;

		if (map.containsKey(p)) {
			Set<Account> accounts = map.get(p);
			for (Account a : accounts) {
				if (a.getAccountId() == accId) {
					preSum = a.getMoney();
					a.addMoney(sum);
					postSum = a.getMoney();
				}
			}
		}

		assert preSum + sum == postSum : "Money were not added";
		assert isWellFormed() : "Isn't well formed";
		serializ.reloadBank(map);
	}

	@Override
	public void withdrawMoney(double sum, int accId, Person p) {

		assert isWellFormed() : "Isn't well formed";
		assert p != null : "The person should't be null";
		assert accId != 0 : "The account id shouldn't be 0";
		assert sum > 0 : "Money should be a positive sum";

		double preSum = 0;
		double postSum = 0;

		if (map.containsKey(p)) {
			Set<Account> accounts = map.get(p);
			for (Account a : accounts) {
				if (a.getAccountId() == accId) {
					preSum = a.getMoney();
					a.withdrawMoney(sum);
					postSum = a.getMoney();
				}
			}
		}

		assert preSum > postSum : "Money were not added";
		assert isWellFormed() : "Isn't well formed";
		serializ.reloadBank(map);
	}

	// all accounts of a person
	@Override
	public void deleteAccount(int accId, Person p) {

		assert isWellFormed() : "Isn't well formed";
		assert p != null : "The person should't be null";
		assert accId != 0 : "The account shouldn't be null";

		int preSizeAccount = 0;
		int postSizeAccount = 0;

		if (map.containsKey(p)) {
			Set<Account> accounts = map.get(p);
			Iterator<Account> itr = accounts.iterator();
			Account a;
			while (itr.hasNext()) {

				a = itr.next();

				if (a.getAccountId() == accId) {

					System.out.println("all accounts1: " + map.get(p));

					preSizeAccount = accounts.size();
					System.out.println("preSize2: " + preSizeAccount);
					itr.remove();

					postSizeAccount = accounts.size();
					System.out.println("postSize2: " + postSizeAccount);
				}
			}
			if (accounts.size() == 0) {
				deletePerson(p);
			}

			for (Account a2 : accounts) {
				System.out.println("all accounts3: " + a2);
			}

		}

		// assert preSizeAccount > postSizeAccount : "Account was not deleted";
		assert preSizeAccount - 1 == postSizeAccount : "Account was not deleted";
		assert isWellFormed() : "Isn't well formed";
		serializ.reloadBank(map);

	}

	@Override
	public void deletePerson(Person p) {

		assert isWellFormed() : "Isn't well formed";
		assert p != null : "Person should be real";

		int prePersonSize = 0;
		int postPersonSize = 0;

		if (map.containsKey(p)) {
			// System.out.println("ENTERED HERE!! ");
			prePersonSize = map.size();
			System.out.println("preSize: " + prePersonSize);
			map.remove(p, map.get(p));
			postPersonSize = map.size();
			System.out.println("postSize: " + postPersonSize);
		}
		assert prePersonSize - 1 == postPersonSize;
		assert isWellFormed() : "Isn't well formed";
		serializ.reloadBank(map);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
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
		Bank other = (Bank) obj;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bank [map=" + map + "]";
	}

	@Override
	public boolean isWellFormed() {

		for (java.util.Map.Entry<Person, Set<Account>> entry : map.entrySet()) {
			if (entry.getValue() == null || entry.getValue().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Person> displayAll() {

		List<Person> pers = new ArrayList<Person>(map.keySet());
		return pers;
	}

	@Override
	public Set<Account> displayAllACcounts(Person p) {
		
		assert p != null : "Person caanot be found";
		if(map.containsKey(p)){
			Set<Account> accounts = map.get(p);
			return accounts;
		} else {
			System.out.println("That person cannot be found!");
			return null;
		}
	}
}
