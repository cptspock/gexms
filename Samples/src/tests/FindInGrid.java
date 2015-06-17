package tests;

import java.util.Scanner;

public class FindInGrid {

	public boolean findInGrid(char[][] grid, char[] word) {

		int i = 0, j = 0, k = 0, starti = 0, startj = 0;
		;
		boolean found = false;
		for (i = 0; i < grid.length && found == false; i++)
			for (j = 0; j < grid.length; j++) {
				if (grid[i][j] == word[0]) {
					found = true;
					starti = i;
					startj = j;
					break;
				}
			}

		for (i = starti; i < grid.length; i++)
			if (grid[i][startj] == word[k]) {
				k++;
			} else
				break;

		if (k == word.length)
			return true;
		k =0;

		for (j = startj; j < grid.length; j++) {
			if (grid[starti][j] == word[k]) {
				k++;

			} else
				break;

		}
		if (k == word.length)
			return true;
		else
			return false;

	}

	public static void main(String[] args) {

		System.out.println("Enter the number of characters in grid: ");
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		char[][] grid = new char[length][length];

		for (int i = 0; i < length; i++)
			for (int j = 0; j < length; j++)
				grid[i][j] = scanner.next().charAt(0);

		System.out.println(new FindInGrid().findInGrid(grid,
				"bast".toCharArray()));

	}

}
