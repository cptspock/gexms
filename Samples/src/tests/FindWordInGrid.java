package tests;

import java.util.Scanner;

public class FindWordInGrid {
	private int[][] DIR = { { 1, 0 }, { 1, -1 }, { 1, 1 }, { 0, -1 }, { 0, 1 }, { -1, 0 }, { -1, -1 }, { -1, 1 } };
	// for toal array size
	int m, n;

	// method for finding word presence in the array in a specific direction
	public boolean match(char CharMat[][], char word[], int i, int j, int dir_index) {
		int k = 0;
		for (; i < m && j < n && i >= 0 && j >= 0
				&& word[k] != 0; i = i + DIR[dir_index][0], j = j + DIR[dir_index][1], k++)
			if (Character.toUpperCase(word[k]) != Character.toUpperCase(CharMat[i][j]))
				return false;

		if (word[k] == 0)
			return true;

		return false;
	}

	public void find_presence(char CharMat[][], char word[]) {
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (Character.toUpperCase(CharMat[i][j]) == Character.toUpperCase(word[0]))
					for (int k = 0; k < 8; k++)
						if (match(CharMat, word, i, j, k)) {
							System.out.print(i + 1 + " " + j + 1 + "%n");
							return;
						}
		System.out.println("'" + word.toString() + "' was not found in the grid%n");
	}

	public static void main(String[] args) {
		char CharMat[][] = new char[50][50];
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();

		for (int i = 0; i < m; i++)
			CharMat[i] = scanner.next().toCharArray();

		int num_words;
		char word[] = new char[n];
		// cin >> num_words;
		// for (int j=0; j<num_words; j++)
		// {
		// cin >> word;
		word = scanner.next().toCharArray();
		new FindWordInGrid().find_presence(CharMat, word);

	}
}
