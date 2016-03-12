package pt2016.project1.model.mathematics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Alexa
 *
 */
public class Polynomial {

	private List<Term> list = new ArrayList<Term>();

	public Polynomial() {

	}

	public Polynomial(List<Term> list) {
		this.list = list;
		Collections.sort(list, new TermComparator());
	}

	/**
	 * Copy constructor
	 * 
	 * @param poly
	 */

	public Polynomial(Polynomial poly) {
		list = new ArrayList<>(poly.getList());
	}

	public List<Term> getList() {
		return list;
	}

	public void setList(List<Term> list) {
		this.list = list;
	}

	private int getSize() {
		return list.size();
	}

	public int getDegree(int i) {
		return list.get(i).getDeg();
	}

	public float getCoeff(int i) {
		return list.get(i).getCoeff();
	}

	private Term getTerm(int i) {
		return list.get(i);
	}


	public void add(Term t) {

		boolean exists = false;
		// Iterator<Term> it = list.iterator();

		for (Term t2 : list) {
			if (t2.getDeg() == t.getDeg()) {
				float coeff = t2.getCoeff();
				t2.setCoeff(coeff + t.getCoeff());
				exists = true;
			}
		}
		if (!exists)
			list.add(new Term(t.getCoeff(), t.getDeg()));
		list.sort(new TermComparator());
	}

	// Override la equals, aici si in Term

	public String toString() {
		String s = "";
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getCoeff() < 0)
				s += "(" + list.get(i).getCoeff() + ")" + "x^" + list.get(i).getDeg() + "+";
			else
				s += list.get(i).getCoeff() + "x^" + list.get(i).getDeg() + "+";
		}
		if (list.get(list.size() - 1).getCoeff() < 0)
			s += "(" + list.get(list.size() - 1).getCoeff() + ")" + "x^" + list.get(list.size() - 1).getDeg();
		else
			s += list.get(list.size() - 1).getCoeff() + "x^" + list.get(list.size() - 1).getDeg();
		return s;
	}

}
