package pt2016.project4.bank;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class Person implements Observer, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;

	public Person(String name, int age) {
		// super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void update(Observable o, Object arg) { // o - acountul care se
													// modifica,
													// arg - valoarea pa care am
													// pasat-o in notify
													// observator
		// e chemata cand orice in accountv e notoficat
		System.out.println("Person has been notifyed by account: " + o + " with sum: " + arg);

	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
