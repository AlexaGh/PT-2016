package pt2016.project5.dictionary;

import java.util.ArrayList;
import java.util.HashMap;

public class ProxyDictionary implements DictionaryI{

	Dictionary dic = new Dictionary();
	
	@Override
	public void addSynonim(String word, String synonym) {
		dic.addSynonim(word, synonym);
		
	}

	@Override
	public boolean removeSynonym(String word, String synonym) {
		return dic.removeSynonym(word, synonym);
	}

	@Override
	public ArrayList<String> getSynonyms(String word) {
		return dic.getSynonyms(word);
	}

	@Override
	public boolean loadDefinitions(String filename) {
		return dic.loadDefinitions(filename);
	}

	@Override
	public boolean populate() {
		return dic.populate();
	}

	@Override
	public ArrayList<String> searchDefinition(String regex) {
		return dic.searchDefinition(regex);
	}

	@Override
	public boolean isConsistent() {
		return dic.isConsistent();
	}

	@Override
	public boolean removeDefinition(String word) {
		return dic.removeDefinition(word);
	}

	@Override
	public void addDefinition(ArrayList<String> entry) {
		 dic.addDefinition(entry);
		
	}

	@Override
	public void save() {
		dic.save();
		
	}

	@Override
	public HashMap<String, ArrayList<String>> viewAll() {
		return dic.viewAll();
	}

}
