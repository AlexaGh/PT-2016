package pt2016.project5.dictionary;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public interface DictionaryI {

	/**
	 * Adds a synonym to a word If the word does not exist, it creates it and
	 * adds it to the dictionary
	 * 
	 * @precond synonym != null
	 * @postcond dictionary iConsistent && preSize < postSize
	 * 
	 * @param word
	 * @param synonym
	 */
	public void addSynonim(String word, String synonym);

	/**
	 * Removes a synonym from the dictionary (together with the word).
	 * 
	 * @precond synonym != null
	 * @postcond dictionary isConsistent &&  preSize > postSize
	 * @param word
	 * @param synonym
	 * @return
	 */
	public boolean removeSynonym(String word, String synonym);

	/**
	 * 
	 * @param word
	 * @return
	 */
	public ArrayList<String> getSynonyms(String word);

	/**
	 * 
	 * @param filename
	 * @return
	 */

	public abstract boolean loadDefinitions(String filename);

	/**
	 * 
	 * @return
	 */
	public boolean populate();

	/**
	 * 
	 * @param regex
	 * @return
	 */
	public ArrayList<String> searchDefinition(String regex);

	/**
	 * 
	 * @return
	 */
	public boolean isConsistent();

	/**
	 * 
	 * @param word
	 * @return
	 */
	public boolean removeDefinition(String word);

	/**
	 * 
	 * @param entry
	 */
	public void addDefinition(ArrayList<String> entry);

	/**
	 * 
	 */
	public abstract void save();
	
	/**
	 * 
	 * @return
	 */
	public HashMap<String, ArrayList<String>> viewAll();
}
