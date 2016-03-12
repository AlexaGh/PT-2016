package pt2016.project1.model.mathematics;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolyParse {

	// Create a Pattern object
	private static final Pattern pattern = Pattern.compile("([+-])?(\\d+)?x(?:\\^(\\d+))?");

	// method that takes the inputString given by the user and "transforms" the
	// string into a polynomial

	public static Polynomial makePolynomial(String inputString) {
		return new Polynomial(parseString(inputString));
	}

	private static List<Term> parseString(String inputString) {

		List<Term> list = new ArrayList<>();

		int index = 0;
		float freeTerm = 0;

		// Now create matcher object.
		Matcher m = pattern.matcher(inputString);

		while (m.find()) {

			/**
			 * m.group(2) holds the coefficient (\\d+);
			 * 
			 * m.group(3) holds the degree (\\d+);
			 * 
			 * m.group(1) holds the sign ([+-]). if it is a minus => multiply
			 * the coefficient with (-1)
			 * 
			 * add the both the coefficient with the corresponding degree to the
			 * list of terms
			 */
			float coefficient = (m.group(2) == null) ? 1 : Float.parseFloat(m.group(2));
			int degree = (m.group(3) == null) ? 1 : Integer.parseInt(m.group(3));
			if ("-".equals(m.group(1)))
				coefficient *= -1;

			list.add(new Term(coefficient, degree));

			index = m.end();
		}

		if (index < inputString.length()) {
			if (index != 0 && inputString.charAt(index - 1) == '-') {
				freeTerm = -1;
			} else {
				freeTerm = 1;
			}
			freeTerm *= Float.parseFloat(inputString.substring(index, inputString.length()));
			list.add(new Term(freeTerm, 0));
		}

		return list;
	}
}
