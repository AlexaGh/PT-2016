package pt2016.project1.model.mathematics;

import java.util.List;

public class PolyOperations {

	public Polynomial addition(Polynomial p1, Polynomial p2) {

		List<Term> list2 = p2.getList();
		Polynomial result = new Polynomial(p1);

		for (Term t : list2) {
			result.add(t);
		}
		return result;
	}

	public Polynomial subtraction(Polynomial p1, Polynomial p2) {

		List<Term> list2 = p2.getList();
		Polynomial result = new Polynomial(p1);

		for (Term t : list2) {
			t.setCoeff(t.getCoeff() * (-1));
			result.add(t);
		}
		return result;
	}

	public Polynomial multiplication(Polynomial p1, Polynomial p2) {

		List<Term> list = p1.getList();
		List<Term> list2 = p2.getList();

		Polynomial result = new Polynomial();

		for (Term t : list) {

			float coeff = t.getCoeff();
			int deg = t.getDeg();

			for (Term t2 : list2) {

				float coeff2 = t2.getCoeff();
				int deg2 = t2.getDeg();

				result.add(new Term(coeff * coeff2, deg2 + deg));

			}

		}
		return result;
	}

	public Polynomial multiplicationByTerm(Polynomial p1, Term t1) {

		List<Term> list = p1.getList();
		// List<Term> list2 = p2.getList();

		Polynomial result = new Polynomial();

		float coeff1 = t1.getCoeff();
		int deg1 = t1.getDeg();

		for (Term t : list) {

			float coeff = t.getCoeff();
			int deg = t.getDeg();

			result.add(new Term(coeff * coeff1, deg1 + deg));

		}
		return result;
	}

	public Polynomial integration(Polynomial p1) {

		List<Term> list = p1.getList();

		for (Term t : list) {

			t.setCoeff(t.getCoeff() / (t.getDeg() + 1));
			t.setDeg(t.getDeg() + 1);

		}
		return p1;
	}

	public Polynomial differentiation(Polynomial p1) {

		List<Term> list = p1.getList();

		boolean freeTermExists = false;

		for (Term t : list) {
			if (t.getDeg() > 0) {
				t.setCoeff(t.getCoeff() * t.getDeg());
				t.setDeg(t.getDeg() - 1);
			}
			if (t.getDeg() == 0) {
				freeTermExists = true;
			}
		}
		list.sort(new TermComparator());
		if (freeTermExists) {
			list.remove(list.size() - 1);
		}
		return p1;
	}

	public Polynomial[] division(Polynomial p1, Polynomial p2) {

		Polynomial[] result = new Polynomial[2];

		result[0] = p1; // result[0] will hold the remainder
		result[1] = new Polynomial();

		Polynomial aux = new Polynomial();
		Term term; // this is the term that will always be multiplied with p2

		if (!p2.equals(0)) {
			while (result[0].getDegree(0) >= p2.getDegree(0)) { // leading term

				term = new Term(result[0].getCoeff(0) / p2.getCoeff(0), result[0].getDegree(0) - p2.getDegree(0));
				// the new term is the division between the two leading terms of
				// the polynomials
				// now this has to be multiplied with polynomial p2

				result[1].add(term); // asta o sa fie catul

				PolyOperations po = new PolyOperations();
				aux = po.multiplicationByTerm(p2, term);

				result[0] = po.subtraction(result[0], aux);
				if (result[0].getCoeff(0) == 0)
				result[0].getList().remove(0);

			}

		}
		return result;
	}
}
