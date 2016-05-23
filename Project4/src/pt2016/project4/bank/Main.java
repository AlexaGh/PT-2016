package pt2016.project4.bank;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		new Controller(new View());
		
		
		/*Bank bank = new Bank();
		Account acc = new SavingAccount(5, 52.5, "saving");
		Account acc2 = new SpendingAccounts(6, 185, "spending");
		Person p = new Person("Name1", 45);
		Person p2 = new Person("Name2", 50);
		
		bank.addAccforPerson(p, acc);
		bank.addAccforPerson(p, acc2);
		System.out.println(bank);
		
		bank.depositMoney(15, 5, p);
		bank.depositMoney(688, 6, p);
		
		bank.withdrawMoney(1, 6, p);
		bank.deleteAccount(5, p);
		bank.deletePerson(p);*/
		
	}
	
	public List<Field> getFields(Class<?> entity) {
		List<Field> result = new LinkedList<>();
		for(Class<?> c = entity; c != null; c = c.getSuperclass()) {
			result.addAll(Arrays.asList(c.getDeclaredFields()));
		}
		return result;
	}
	
	public String[] getFieldNames(Class<?> entity) {
		List<Field> fields = getFields(entity);
		String[] result = new String[fields.size()];
		int it = 0;
		for (Field field : fields) {
			result[it++] = field.getName();
		}
		return result;
	}
	
}
