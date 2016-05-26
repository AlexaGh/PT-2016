package pt2016.project5.dictionary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Controller {

	private View frame;

	//private Dictionary dictionary;
	private ProxyDictionary dictionary;

	public Controller(View frame) {

		this.frame = frame;
		dictionary = new ProxyDictionary();
		JTextArea tarea = frame.getTarea();

		frame.setAddSynonymActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				String word = frame.getTfield1().getText();
				String synonyms = frame.getTfield2().getText();

				if (!word.equals("") && !synonyms.equals("")) {

					ArrayList<String> inp = new ArrayList<String>();

					String[] results = synonyms.split(",");
					inp.add(word);

					for (int i = 0; i < results.length; i++) {
						inp.add(results[i]);
					}
					dictionary.addDefinition(inp);
					tarea.setText("Synonym was added");

				} else {
					JOptionPane.showMessageDialog(null, "Please complete all fields");
				}

			}

		});

		frame.setRemoveSynonymActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String tfield1 = frame.getTfield1().getText();

				if (!tfield1.equals("")) {
					if (dictionary.removeDefinition(tfield1) == true)
						tarea.setText("Definition removed successfully!");
					else
						tarea.setText("Definition not found in dictionary!");
				}

			}
		});

		frame.setSearchSynonymActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String tfield1 = frame.getTfield1().getText();

				if (!tfield1.equals("")) {
					ArrayList<String> res = new ArrayList<String>();
					res = dictionary.searchDefinition(tfield1);

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
		});

		frame.setPopulateDictionaryActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dictionary.populate();
			}
		});

		frame.setSaveDictionaryActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dictionary.save();

			}
		});

	}

}
