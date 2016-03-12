package pt2016.project1.controller;

import pt2016.project1.model.mathematics.PolyOperations;
import pt2016.project1.model.mathematics.PolyParse;
import pt2016.project1.model.mathematics.Polynomial;

public class MainController {

	public static void main(String[] args) {

		// String pol1 = "7x^6+5x^5+3x^2+2x+10";
		// String pol2 = "6x^8+8x^6+10x^5+x+1";

		String pol1 = "x^3-2x^2-4";
		String pol2 = "x-3";

		Polynomial p1 = PolyParse.makePolynomial(pol1);
		Polynomial p2 = PolyParse.makePolynomial(pol2);

		// String expectedResult1 = "1.0x^2+1.0x^1+3.0x^0";
		// String expectedResult2 = "5";

		PolyOperations po = new PolyOperations();

		System.out.println(p1.toString());
		System.out.println(p2.toString());

		Polynomial[] result = new Polynomial[2];
		result = po.division(p1, p2);

		System.out.println(result[0].toString());
		System.out.println(result[1].toString());

	}

}
