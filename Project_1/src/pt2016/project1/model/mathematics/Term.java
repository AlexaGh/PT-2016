package pt2016.project1.model.mathematics;

/**
 * Object class which models a term of a polynomial
 * 
 * @author Alexa
 *
 */
public class Term {

	// attributes of a term of a polynomial, namely the degree and the coefficients
	private float coeff;
	private int deg;

	public Term(float coeff, int deg) {
		this.coeff = coeff;
		this.deg = deg;
	}

	public float getCoeff() {
		return coeff;
	}

	public void setCoeff(float coeff) {
		this.coeff = coeff;
	}

	public int getDeg() {
		return deg;
	}

	public void setDeg(int deg) {
		this.deg = deg;
	}

	@Override
	public String toString() {
		if (getCoeff() >= 0)
			return getCoeff() + "x^" + getDeg();
		else
			return "(" + getCoeff() + ")" + "x^" + getDeg();
	}

}
