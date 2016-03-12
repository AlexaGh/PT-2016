package pt2016.project1.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import pt2016.project1.model.mathematics.PolyOperations;
import pt2016.project1.model.mathematics.PolyParse;
import pt2016.project1.model.mathematics.Polynomial;

public class PolynomialFrame extends JFrame implements ActionListener {

	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();

	private JPanel inputPanel = new JPanel();
	private JPanel outputPanel = new JPanel();
	private JPanel controlPanel = new JPanel();

	private JLabel insertPolyMessage1;
	private JLabel insertPolyMessage2;
	private JLabel validatePolynomial1;
	private JLabel validatePolynomial2;
	private JPanel panelForButton1 = new JPanel();
	private JPanel panelForButton2 = new JPanel();
	private JTextField introducePoly1 = new JTextField(35);
	private JTextField introducePoly2 = new JTextField(35);
	private JButton insertBtn1 = new JButton("OK");
	private JButton insertBtn2 = new JButton("OK");

	private JLabel pol1IsText = new JLabel("The first polynomial is: ");
	private JLabel pol2IsText = new JLabel("The second polynomial is: ");
	private JLabel valueIsText = new JLabel("The value is: ");
	private JLabel resultedPolIsText = new JLabel("The resulted polynomial is: ");

	private JButton additionBtn = new JButton("Addition");
	private JButton subtractionBtn = new JButton("Subtraction");
	private JButton multiplicationBtn = new JButton("Multiplication");
	private JButton divisionBtn = new JButton("Division");
	private JButton integrateBtn = new JButton("Integrate");
	private JButton derivativeBtn = new JButton("Derivation");
	private JButton multiplyByScalarBtn = new JButton("Multiply by scalar");
	private JButton valueAtPoint = new JButton("Value at point");
	private JButton findRootBtn = new JButton("FindRoot");

	public PolynomialFrame() {

		super("Polynomials");
		setLayout(new GridLayout(1, 2));

		setPreferredSize(new Dimension(950, 600));
		setSize(new Dimension(950, 600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// divide the frame into two parts: the left one (which will contain the
		// Input and Output panels)
		// and the right one which will contain buttons for the polynomial
		// operations

		add(leftPanel);
		add(rightPanel);

		// the left panel contains the inputPanel in the upper part
		// where the user should introduce the two polynomials he/she wants to
		// operate with
		// and the lower part which contains the output messages (if the
		// polynomials aren't introduces in theor correct (mathematical)
		// form it will signal so, it will output the resulted polynomial etc)

		leftPanel.setLayout(new GridLayout(2, 1));

		inputPanel.setLayout(new GridLayout(4, 4));
		inputPanel.setBorder(new LineBorder(Color.BLACK));

		insertPolyMessage1 = new JLabel("Introduce the first polynomial: ");
		inputPanel.add(insertPolyMessage1);

		validatePolynomial1 = new JLabel("Validate polynomial1: ");
		inputPanel.add(validatePolynomial1);

		introducePoly1.setPreferredSize(new Dimension(450, 15));
		inputPanel.add(introducePoly1);

		// set the button in a panel in order to resize it
		// in gridLayout you cannot resize components using
		// setSize/setPrefferedSize w/e

		panelForButton1.setLayout(new FlowLayout());
		panelForButton1.add(insertBtn1);
		Dimension maxSize = new Dimension(50, 50);
		insertBtn1.setMaximumSize(maxSize);

		//panelForButton1.add(insertBtn1);

		inputPanel.add(panelForButton1);

		insertPolyMessage2 = new JLabel("Introduce the second polynomial: ");
		inputPanel.add(insertPolyMessage2);

		validatePolynomial2 = new JLabel("Validate polynomial2: ");
		inputPanel.add(validatePolynomial2);

		introducePoly2.setPreferredSize(new Dimension(450, 15));
		inputPanel.add(introducePoly2);

		panelForButton2.setLayout(new FlowLayout());
		panelForButton2.add(insertBtn2);
		insertBtn2.setMaximumSize(maxSize);

		//panelForButton2.add(insertBtn2);

		inputPanel.add(panelForButton2);

		outputPanel.setLayout(new GridLayout(4, 1));
		outputPanel.setBorder(new LineBorder(Color.BLACK));
		outputPanel.add(pol1IsText);
		outputPanel.add(pol2IsText);
		outputPanel.add(valueIsText);
		outputPanel.add(resultedPolIsText);

		leftPanel.add(inputPanel);
		leftPanel.add(outputPanel);

		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(controlPanel, BorderLayout.CENTER);

		controlPanel.setLayout(new GridLayout(3, 3));

		controlPanel.add(additionBtn);
		controlPanel.add(subtractionBtn);
		controlPanel.add(multiplicationBtn);
		controlPanel.add(divisionBtn);
		controlPanel.add(integrateBtn);
		controlPanel.add(derivativeBtn);
		controlPanel.add(multiplyByScalarBtn);
		controlPanel.add(valueAtPoint);
		controlPanel.add(findRootBtn);

		rightPanel.add(controlPanel);

		insertBtn1.addActionListener(this);
		setFocusable(true);
		pack();
	}

	public static void main(String[] args) {

		PolynomialFrame pf = new PolynomialFrame();
		pf.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial result = new Polynomial();

		PolyOperations po = new PolyOperations();
		// result = po.division(p1, p2);
		/*if (e.getSource() == insertBtn1) {
			try {
				p1 = PolyParse.makePolynomial(introducePoly1.getText());
				// pol1IsText.setText(introducePoly1.getText());
				pol1IsText.setText(p1.toString());
			} catch (Exception exp) {
				System.err.println("Trying buttons");
				pol1IsText.setText("What you introduced is invalid");

			}
		} else*/ if (e.getSource() == insertBtn2) {
			try {
				p2 = PolyParse.makePolynomial(introducePoly2.getText());
				pol2IsText.setText(p2.toString());
				// pol2IsText.setText(introducePoly2.getText());
			} catch (Exception exp) {
				System.err.println("Trying buttons");
				pol2IsText.setText("What you introduced is invalid");

			}

		}
		if (e.getSource() == additionBtn) {
			try {
				result = po.addition(p1, p2);
				resultedPolIsText.setText(result.toString());
			} catch (Exception exp) {

				System.err.println("Trying buttons");
				pol1IsText.setText("What you introduced is invalid");

			}
		}
	}

}
