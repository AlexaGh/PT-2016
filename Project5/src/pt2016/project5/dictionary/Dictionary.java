package pt2016.project5.dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Dictionary implements DictionaryI, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8840136245548341162L;

	private HashMap<String, ArrayList<String>> dictionary;

	private IteratorPaternRepo rep;

	private final String DEFINITIONS = "C:\\Users\\Alexa\\Desktop\\GIT Repositories\\PT-2016\\Project5\\src\\synonyms.txt";

	public Dictionary() {
		dictionary = new HashMap<String, ArrayList<String>>();
		rep = new IteratorPaternRepo();
	}

	@Override
	public void addSynonim(String word, String synonym) {

		assert isConsistent() : "Dictionary is not consistent!";

		ArrayList<String> values = dictionary.get(word);

		if (values == null) {
			values = new ArrayList<String>();
		}
		if (!values.contains(synonym)) {
			values.add(synonym);
			dictionary.put(word, values);
		}

		assert isConsistent() : "Dictionary is not consistent";
	}

	@Override
	public ArrayList<String> getSynonyms(String word) {
		return dictionary.get(word);
	}

	@Override
	public boolean removeSynonym(String word, String synonym) {

		assert isConsistent() : "Dictionary is not consistent!";
		assert dictionary != null && dictionary.get(word) != null : "Word does not exist in dictionary";
		int preSize = dictionary.size();
		// if ((dictionary != null) && (dictionary.get(word) != null)) {

		if (dictionary.containsKey(word)) {

			dictionary.entrySet().forEach(e -> e.getValue().forEach(s -> dictionary.get(s).remove(e.getKey())));
			// dictionary.remove(word);

			int postSize = dictionary.size();
			assert preSize > postSize : "word was deleted";

			assert isConsistent() : "Dictionary is not consistent";

			return true;
		} else
			return false;

	}

	@Override
	public boolean loadDefinitions(String filename) {
		assert (filename != null);
		try {
			FileInputStream fileStream = new FileInputStream(filename);
			DataInputStream in = new DataInputStream(fileStream);
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			String strLine;
			while ((strLine = br.readLine()) != null) {
				// read a set of synonyms
				if (strLine.indexOf(":") != -1) {
					String word = strLine.substring(0, strLine.indexOf(":"));
					String[] synonyms = strLine.substring(strLine.indexOf(":") + 1).split(",");
					for (String syn : synonyms) {
						addSynonim(word, syn);
					}
				} else {
					throw new Exception();
				}
			}
			br.close();
			inr.close();
			in.close();
			fileStream.close();
			assert (isConsistent());
			return true;
		} catch (Exception e) {
			System.out.println("Error reading from file");

			return false;
		}
	}

	@Override
	public boolean populate() {
		return loadDefinitions(DEFINITIONS);
	}

	@Override
	public ArrayList<String> searchDefinition(String word) {

		assert dictionary != null : "dictonary should contain words";

		ArrayList<String> results = new ArrayList<String>();

		int[] v = new int[100];
		for (int i = 0; i < v.length; i++) {
			v[i] = 0;
		}

		for (int i = 0; i < word.length(); i++) {
			if (((word.charAt(i) == '?') || (word.charAt(i) == '*')) && i == 0) {
				word.replace(word.charAt(i), '+');
				word = '.' + word;
			} else if (word.charAt(i) == '?') {
				word = word.substring(0, i) + "." + word.substring(i + 1, word.length());
			}

			else if (word.charAt(i) == '*') {
				word = word.substring(0, i) + "." + word.substring(i + 1, word.length());
				v[i]++;
			}

			System.out.println("transf word is: " + word);
		}
		try {
			for (int i = 0; i < v.length; i++) {
				if (v[i] != 0) {
					word = word.substring(0, i + 1) + "*" + word.substring(i + 2, word.length());
				}
			}
		} catch (Exception e) {

		}
		try {
			Pattern p = Pattern.compile(word);
			for (String candidate : dictionary.keySet()) {
				Matcher m = p.matcher(candidate);
				if (m.find()) {
					results.add(candidate);

				}
			}
		} catch (PatternSyntaxException e) {
			System.out.println("Incorrect pattern syntax: " + word);
		}

		return results;

	}

	@Override
	public boolean isConsistent() {

		/* boolean state = true;

		 state = dictionary.entrySet().stream().allMatch(e ->
		 e.getValue().stream().allMatch(s ->
		 dictionary.get(s).contains(e.getKey())));
		 return state;
*/
		for (String word : dictionary.keySet()) {
			for (String syn : dictionary.get(word)) {
				try {
					if (!dictionary.get(syn).contains(word))
						return false;
				} catch (Exception e) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean removeDefinition(String word) {
		assert ((dictionary != null) && (dictionary.get(word) != null));

		if ((dictionary != null) && (dictionary.get(word) != null)) {
			dictionary.remove(word);
			return true;
		}

		else
			return false;
	}

	@Override
	public void addDefinition(ArrayList<String> entry) {

		System.out.println("size: " + entry.size());
		// System.out.println("it: " + rep.getIterator());
		System.out.println("");

		// DESIGN PATTERN 1:

		for (Iterator iter = rep.getIterator(entry); iter.hasNext();) {
			String strings = (String) iter.next();
			addSynonim(entry.get(0), strings);
			addSynonim(strings, entry.get(0));
		}
/*
		for (int i = 1; i < entry.size(); i++) {
			addSynonim(entry.get(0), entry.get(i));
			addSynonim(entry.get(i), entry.get(0));
		}
*/
		assert isConsistent();
	}

	@Override
	public void save() {
		assert isConsistent();
		try {
			FileWriter fw = new FileWriter(DEFINITIONS);
			BufferedWriter out = new BufferedWriter(fw);
			for (String word : dictionary.keySet()) {
				String output = word + ":";
				for (String syn : dictionary.get(word)) {
					output += syn + ",";
				}
				out.write(output.substring(0, output.length() - 1) + "\r\n");
			}
			out.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Error writing to file");
			e.printStackTrace();
		}
	}

	@Override
	public HashMap<String, ArrayList<String>> viewAll() {
		return dictionary;
	}
}
