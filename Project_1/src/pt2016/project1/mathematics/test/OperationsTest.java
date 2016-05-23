package pt2016.project1.mathematics.test;

import static org.junit.Assert.*;

import pt2016.project1.model.mathematics.PolyOperations;
import pt2016.project1.model.mathematics.PolyParse;
import pt2016.project1.model.mathematics.Polynomial;

public class OperationsTest {

	@org.junit.Test
	public void additionTest() {

		String pol1 = "7x^6+5x^5+3x^2+2x+10";
		String pol2 = "6x^8+8x^6+10x^5+x+1";

		Polynomial p1 = PolyParse.makePolynomial(pol1);
		Polynomial p2 = PolyParse.makePolynomial(pol2);

		String expectedResult = "6.0x^8+15.0x^6+15.0x^5+3.0x^2+3.0x^1+11.0x^0";

		PolyOperations po = new PolyOperations();
		Polynomial result = po.addition(p1, p2);

		assertTrue(result.toString().equals(expectedResult));

	}

	@org.junit.Test
	public void subtractionTest() {

		String pol1 = "7x^6+5x^5+3x^2+2x+10";
		String pol2 = "6x^8+8x^6+10x^5+x+1";
 
		Polynomial p1 = PolyParse.makePolynomial(pol1);
		Polynomial p2 = PolyParse.makePolynomial(pol2);

		String expectedResult = "(-6.0)x^8+(-1.0)x^6+(-5.0)x^5+3.0x^2+1.0x^1+9.0x^0";

		PolyOperations po = new PolyOperations();
		Polynomial result = po.subtraction(p1, p2);

		assertTrue(result.toString().equals(expectedResult));
	}

	@org.junit.Test
	public void multiplicationTest() {

		String pol1 = "3x^2+x+1";
		String pol2 = "2x^3+2x+5";

		Polynomial p1 = PolyParse.makePolynomial(pol1);
		Polynomial p2 = PolyParse.makePolynomial(pol2);

		String expectedResult = "6.0x^5+2.0x^4+8.0x^3+17.0x^2+7.0x^1+5.0x^0";

		PolyOperations po = new PolyOperations();
		Polynomial result = po.multiplication(p1, p2);

		assertTrue(result.toString().equals(expectedResult));
	}

	@org.junit.Test
	public void differentiationTest() {

		String pol1 = "7x^6+5x^5+3x^2+2x+10";
		Polynomial p1 = PolyParse.makePolynomial(pol1);

		String expectedResult = "42.0x^5+25.0x^4+6.0x^1+2.0x^0";

		PolyOperations po = new PolyOperations();
		Polynomial result = po.differentiation(p1);

		assertTrue(result.toString().equals(expectedResult));

	}

	@org.junit.Test
	public void integrationTest() {

		String pol1 = "7x^6+5x^5+3x^2+2x+10";
		Polynomial p1 = PolyParse.makePolynomial(pol1);

		String expectedResult = "1.0x^7+0.8333333x^6+1.0x^3+1.0x^2+10.0x^1";

		PolyOperations po = new PolyOperations();
		Polynomial result = po.integration(p1);

		assertTrue(result.toString().equals(expectedResult));

	}

	@org.junit.Test
	public void divisiontest() {

		String pol1 = "x^3-2x^2-4";
		String pol2 = "x-3";

		Polynomial p1 = PolyParse.makePolynomial(pol1);
		Polynomial p2 = PolyParse.makePolynomial(pol2);

		String expectedResult1 = "1.0x^2+1.0x^1+3.0x^0";
		String expectedResult2 = "5.0x^0";

		PolyOperations po = new PolyOperations();
		Polynomial[] result = new Polynomial[2];
		result = po.division(p1, p2);

		assertTrue(result[1].toString().equals(expectedResult1));
		assertTrue(result[0].toString().equals(expectedResult2));
	}

}
