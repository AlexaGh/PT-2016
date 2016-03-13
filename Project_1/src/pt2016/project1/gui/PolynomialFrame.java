package pt2016.project1.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import pt2016.project1.model.mathematics.PolyOperations;
import pt2016.project1.model.mathematics.PolyParse;
import pt2016.project1.model.mathematics.Polynomial;

public class PolynomialFrame extends JFrame implements ActionListener {

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Tips");
	
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
	private JLabel pol1Is = new JLabel("");
	private JLabel pol2IsText = new JLabel("The second polynomial is: ");
	private JLabel pol2Is = new JLabel("");
	private JLabel resultedPolIsText = new JLabel("The resulted polynomial is: ");
	private JLabel resultedPolIs = new JLabel("");
	private JLabel resultPolIs2 = new JLabel("");

	private JPanel auxPanel = new JPanel();

	private JButton additionBtn = new JButton("Addition");
	private JButton subtractionBtn = new JButton("Subtraction");
	private JButton multiplicationBtn = new JButton("Multiplication");
	private JButton divisionBtn = new JButton("Division");
	private JButton integrateBtn = new JButton("Integration");
	private JButton derivativeBtn = new JButton("Derivation");

	Polynomial p1 = new Polynomial();
	Polynomial p2 = new Polynomial();
	Polynomial[] result = new Polynomial[2];
	PolyOperations po = new PolyOperations();

	public PolynomialFrame() {

		super("Polynomials");
		setLayout(new GridLayout(1, 2));

		setPreferredSize(new Dimension(950, 600));
		setSize(new Dimension(950, 600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("Where will this be?");
		menuBar.add(menu);
		add(menuBar);*/
		
		leftPanel.setLayout(new GridLayout(2, 1));

		add(leftPanel);
		add(rightPanel);

		inputPanel.setLayout(new GridLayout(4, 4));
		inputPanel.setBorder(new LineBorder(Color.BLACK));

		insertPolyMessage1 = new JLabel("Introduce the first polynomial: ");
		inputPanel.add(insertPolyMessage1);

		validatePolynomial1 = new JLabel("Validate polynomial1: ");
		inputPanel.add(validatePolynomial1);

		introducePoly1.setPreferredSize(new Dimension(450, 15));
		inputPanel.add(introducePoly1);

		panelForButton1.setLayout(new FlowLayout());
		panelForButton1.add(insertBtn1);
		Dimension maxSize = new Dimension(50, 50);
		insertBtn1.setMaximumSize(maxSize);
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
		inputPanel.add(panelForButton2);

		auxPanel.setLayout(new BorderLayout());

		controlPanel.setLayout(new GridLayout(2, 3));

		controlPanel.add(additionBtn);
		controlPanel.add(subtractionBtn);
		controlPanel.add(multiplicationBtn);
		controlPanel.add(divisionBtn);
		controlPanel.add(integrateBtn);
		controlPanel.add(derivativeBtn);

		auxPanel.add(controlPanel, BorderLayout.CENTER);

		leftPanel.add(inputPanel);
		leftPanel.add(auxPanel);

		outputPanel.setLayout(new GridLayout(7, 1));
		pol1IsText.setFont(new Font("Courier New", Font.PLAIN, 25));
		outputPanel.add(pol1IsText);

		pol1Is.setFont(new Font("Serif", Font.PLAIN, 15));
		outputPanel.add(pol1Is);

		pol2IsText.setFont(new Font("Courier New", Font.PLAIN, 25));
		outputPanel.add(pol2IsText);

		pol2Is.setFont(new Font("Serif", Font.PLAIN, 15));
		outputPanel.add(pol2Is);

		resultedPolIsText.setFont(new Font("Courier New", Font.PLAIN, 25));
		outputPanel.add(resultedPolIsText);

		resultedPolIs.setFont(new Font("Serif", Font.PLAIN, 15));
		outputPanel.add(resultedPolIs);

		resultPolIs2.setFont(new Font("Serif", Font.PLAIN, 15));
		outputPanel.add(resultPolIs2);

		rightPanel.add(outputPanel);

		insertBtn1.addActionListener(this);
		insertBtn2.addActionListener(this);

		additionBtn.addActionListener(this);
		subtractionBtn.addActionListener(this);
		divisionBtn.addActionListener(this);
		multiplicationBtn.addActionListener(this);
		derivativeBtn.addActionListener(this);
		integrateBtn.addActionListener(this);

	}

	public static void main(String[] args) {

		PolynomialFrame pf = new PolynomialFrame();
		pf.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == insertBtn1) {
			try {
				p1 = PolyParse.makePolynomial(introducePoly1.getText());
				pol1Is.setText(p1.toString());
			} catch (Exception exp) {
				System.err.println("Trying buttons");
				pol1Is.setText("What you introduced is invalid");

			}
		} else if (e.getSource() == insertBtn2) {
			try {
				p2 = PolyParse.makePolynomial(introducePoly2.getText());
				pol2Is.setText(p2.toString());
				// pol2IsText.setText(introducePoly2.getText());
			} catch (Exception exp) {
				System.err.println("Trying buttons");
				pol2Is.setText("What you introduced is invalid");
			}
		}
		if (e.getSource() == additionBtn) {
			try {
				result[0] = po.addition(p1, p2);
				resultedPolIs.setText(result[0].toString());
			} catch (Exception exp) {
				System.err.println("Trying buttons");
				resultedPolIs.setText("Couldn't perform addition");

			}
		} else if (e.getSource() == subtractionBtn) {
			try {
				result[0] = po.subtraction(p1, p2);
				resultedPolIs.setText(result[0].toString());
			} catch (Exception exp) {
				System.err.println("Trying buttons");
				resultedPolIs.setText("Couldn't perform subtraction");

			}
		}

		else if (e.getSource() == multiplicationBtn) {
			try {
				result[0] = po.multiplication(p1, p2);
				resultedPolIs.setText(result[0].toString());
			} catch (Exception exp) {
				System.err.println("Trying buttons");
				resultedPolIs.setText("Couldn't perform multiplication");

			}
		} else if (e.getSource() == integrateBtn) {
			try {
				result[0] = po.integration(p1);
				resultedPolIs.setText(result[0].toString());
			} catch (Exception exp) {
				System.err.println("Trying buttons");
				resultedPolIs.setText("Couldn't perform integration");
			}
		} else if (e.getSource() == derivativeBtn) {
			try {
				result[0] = po.differentiation(p1);
				resultedPolIs.setText(result[0].toString());
			} catch (Exception exp) {
				System.err.println("Trying buttons");
				resultedPolIs.setText("Couldn't perform differentiation");
			}
		} else if (e.getSource() == divisionBtn) {
			try {
				result = po.division(p1, p2);
				resultedPolIs.setText(result[1].toString());
				resultPolIs2.setText(result[0].toString());
			} catch (Exception exp) {
				System.err.println("Trying buttons");
				resultedPolIs.setText("Couldn't perform division");
			}
		}
	}

}
