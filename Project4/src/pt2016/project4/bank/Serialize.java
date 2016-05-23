package pt2016.project4.bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;

public class Serialize {


	@SuppressWarnings("unchecked")
	public Map<Person, Set<Account>> readAllData() {
		Map<Person, Set<Account>> data;
		try {
			FileInputStream fis = new FileInputStream("bankData.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			data = (Map<Person, Set<Account>>) ois.readObject();
			ois.close();
			return data;
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void reloadBank(Map<Person, Set<Account>> data) {
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("bankData.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
