package uk.ac.aber.cs221.aumgroup.gameLogic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Dictionary - A class that implements a dictionary of words that can be looked up
 * to determine if they are valid words in scrabble or not
 * <p>
 * It is used when the user plays a word and the word has to be checked
 * @author mai15
 * @version 1.0 initial development
 * @version 1.1 added binary search
 * @version 1.2 added methods for hints
 * @see GameMainClass
 */
public class Dictionary {

	// array that hold the words in the dictionary
	private String[] words = new String[69903];

	/**
	 * This is the default constructor for a dictionary
	 */
	public Dictionary() {
	}

	/**
	 * This method reads the dictionary file and adds the words to an array of words
	 * @throws FileNotFoundException 
	 */
	public void readFile() throws FileNotFoundException {
		int count = 0;

		Scanner infile = new Scanner(new FileReader("resources/wordlist.txt"));
		while (infile.hasNext()) {
			words[count] = infile.nextLine().toLowerCase();
			count++;
		}
	}

	/**
	 * This method performs a binary search for a word in the dictionary
	 * @param word this is the word being searched for
	 * @return whether the word searched for exists or not
	 */
	public boolean search(String word) {
		int index = Arrays.binarySearch(words,word);
		if (index > 0) {
			System.out.println("Word found: "+ word);
			System.out.println("Index: " + index);
			return true;
		} else {
			return false;
		}
	}

	// we can have hints, or more than one kind of hints, each one having a certain point requirement
	// so a better hint would be worth more points which the player gets one after each correct word
	// one of those hints could be hinting a word after a user selects at least 2 letters
	public void twoLettersNext(char firstLetter, char secondLetter) {
		ArrayList<String> oneLetterNextWords = new ArrayList<>();
		ArrayList<String> twoLetterNextWords = new ArrayList<>();

		for (int i = 0; i < words.length; i++) {
			if (words[i].toCharArray()[0] == firstLetter) {
				oneLetterNextWords.add(words[i]);
			}
		}

		for (int j = 0; j < oneLetterNextWords.size(); j++) {
			if (oneLetterNextWords.get(j).toCharArray()[1] == secondLetter) {
				twoLetterNextWords.add(oneLetterNextWords.get(j));
			}
		}

		System.out.println("These are the available words you have: ");
		for (String word : twoLetterNextWords) {
			System.out.println(word);
		}
	}
}
