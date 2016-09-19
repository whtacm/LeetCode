/**
 * 
 */
package c127.word.ladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * <p>
 * Only one letter can be changed at a time<br>
 * Each intermediate word must exist in the dictionary
 * <p>
 * For example,
 * 
 * <p>
 * Given:<br>
 * start = "hit"<br>
 * end = "cog"<br>
 * dict = ["hot","dot","dog","lot","log"]<br>
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",<br>
 * return its length 5.
 * <p>
 * Note:<br>
 * Return 0 if there is no such transformation sequence.<br>
 * All words have the same length.<br>
 * All words contain only lowercase alphabetic characters.
 * <p>
 * Hide Tags: Breadth-first Search
 * 
 * @author Jilvo
 * 
 */
public class Solution {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

		if (wordList.size() == 0)
			return 0;

		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

		wordQueue.add(beginWord);
		distanceQueue.add(1);

		String currWord = null;
		Integer currDistance = 0;
		char[] currCharArr = null;
		String newWord = null;
		
		System.out.println("-->>" + wordQueue + ", " + distanceQueue + ", " + wordList);
		
		while (!wordQueue.isEmpty()) {
			currWord = wordQueue.pop();
			currDistance = distanceQueue.pop();

			if (currWord.equalsIgnoreCase(endWord)) {
				return currDistance;
			}

			for (int i = 0; i < currWord.length(); i++) {
				currCharArr = currWord.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					currCharArr[i] = c;
					newWord = new String(currCharArr);
					if (wordList.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currDistance + 1);
						wordList.remove(newWord);

					}
				}
			}
			System.out.println("-->>" + wordQueue + ", " + distanceQueue + ", " + wordList);
		}

		System.err.println("-->>" + currWord + ", " + currDistance);

		int diff = 0;
		for (int i = 0; i < currWord.length(); i++) {
			if (currWord.charAt(i) != endWord.charAt(i)) {
				diff++;
			}
			if (diff > 1) {
				return 0;
			}
		}

		return currDistance + diff;
	}

	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		// "hot","dot","dog","lot","log"

		Solution sln = new Solution();

		System.err.println(sln.ladderLength(start, end, dict));

	}
}
