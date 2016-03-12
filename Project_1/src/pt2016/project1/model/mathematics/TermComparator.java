package pt2016.project1.model.mathematics;

import java.util.Comparator;

public class TermComparator implements Comparator<Term> {


	@Override
	public int compare(Term o1, Term o2) {
		if(o1.getDeg() == o2.getDeg()) return 0;
		else if (o1.getDeg() > o2.getDeg()) return -1;
		else return 1;
	}

}
