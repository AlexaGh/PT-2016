package pt2016.project5.dictionary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class SynonymMain extends JFrame {

	private JButton add = new JButton("Add");
	private JButton rem = new JButton("Remove");
	private JButton search = new JButton("Search");
	private JButton populate = new JButton("Populate");
	private JButton save = new JButton("Save");
	private JTextArea tarea = new JTextArea(30, 15);
	private JTextField tfield1 = new JTextField(10);
	private JTextField tfield2 = new JTextField(10);
	private JPanel dic = new JPanel();
	private JPanel dic1 = new JPanel();
	private JPanel dic2 = new JPanel();
	private JPanel dic3 = new JPanel();
	private Dictionary dictionary = new Dictionary();

	/**
	 * Constructs a new dictionary with a GUI.
	 */
	public SynonymMain() {

		super("Dictionary");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setLocationRelativeTo(null);
		setSize(new Dimension(420, 550));

		dic.setBackground(Color.WHITE);
		FlowLayout flow = new FlowLayout();
		dic.setLayout(flow);
		this.add(dic);
		dic.add(dic1);
		dic1.add(add);
		dic1.add(rem);
		dic1.add(search);
		dic1.add(populate);
		dic1.add(save);
		dic2.add(tfield1);
		dic2.add(tfield2);
		dic3.add(tarea);
		dic.add(dic2);
		dic.add(dic3);
		tarea.setEditable(false);

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				try {
					if (event.getSource() == add) {
						if (!tfield1.getText().equals("") && !tfield2.getText().equals("")) {
							
							ArrayList<String> inp = new ArrayList<String>();
							
							String word = tfield1.getText();
							String synonyms = tfield2.getText();

							String[] results = synonyms.split(",");
							inp.add(word);
							
							for (int i = 0; i < results.length; i++) {
								inp.add(results[i]);
							}
							dictionary.addDefinition(inp);
							// tarea.setText("Dictionary is consinstent: " +
							// dictionary.isConsistent());
							tarea.setText("Synonym was added!");
						} else {
							JOptionPane.showMessageDialog(null, "Please complete all fields");
						}

					}
				} catch (Exception e) {

				}

			}
		}

		);

		rem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				try {
					if (event.getSource() == rem) {
						if (!tfield1.getText().equals("")) {
							if (dictionary.removeDefinition(tfield1.getText()) == true)
								tarea.setText("Definition removed successfully!");
							else
								tarea.setText("Definition not found in dictionary!");
						}
					}
				} catch (Exception e) {

				}

			}
		}

		);

		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				try {
					if (event.getSource() == search) {
						if (!tfield1.getText().equals("")) {
							ArrayList<String> res = new ArrayList<String>();
							res = dictionary.searchDefinition(tfield1.getText());

							if (res.size() == 0)
								tarea.setText("Word not found!");
							else {
								// tarea.setText(res.get(0)+": "+
								// dictionary.getSynonyms(res.get(0))+"\n");
								for (int i = 0; i < res.size(); i++) {
									tarea.setText(res.get(i) + ": " + dictionary.getSynonyms(res.get(i)) + "\n");
									// tarea.append(res.get(i)+": "+
									// dictionary.getSynonyms(res.get(i))+"\n");
								}

							}
						}
					}
				} catch (Exception e) {

				}

			}
		}

		);

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				try {
					if (event.getSource() == save) {
						dictionary.save();
					}

				} catch (Exception e) {

				}

			}
		}

		);

		populate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				try {
					if (event.getSource() == populate) {
						dictionary.populate();
					}

				} catch (Exception e) {

				}

			}
		}

		);

	}

	public static void main(String[] args) {
		ArrayList<String> rez = new ArrayList<String>();
		Dictionary d = new Dictionary();
		// d.populate();
		d.addSynonim("word", "word");
		d.addSynonim("mother", "mon");
		rez = d.searchDefinition("moth*");
		for (int i = 0; i < rez.size(); i++) {
			System.out.println(rez.get(i));
		}
		// d.save();
		SynonymMain sm = new SynonymMain();

	}
}
