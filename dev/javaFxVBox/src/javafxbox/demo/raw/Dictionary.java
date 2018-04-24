package javafxbox.demo.raw;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

	String[] words = new String[70000];

	public void readFile(String fileName) throws FileNotFoundException {
		int count = 0;

		Scanner infile = new Scanner(new FileReader("wordlist.txt"));
		while (infile.hasNext()) {
			words[count] = infile.nextLine().toLowerCase();
			count++;
		}

		Scanner in = new Scanner(System.in);
		System.out.println("Enter search word: ");
		String a = in.nextLine().toLowerCase();

		search(a, words);

		System.out.println(count);
	}

	private static void search(String s, String[] w) {
		for (int i = 0; i < w.length; i++) {
			if (w[i].equals(s)) {
				System.out.println("Word found: " + w[i]);
				System.out.println(i);
				break;
			}
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
