package javafxbox.demo.raw;

import java.util.Arrays;

public class FindNeighbours {
	// simple test array

	int testGrid[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

	// takes an array and position of element
	public void getValidNeighbourElement(int[][] grid, int posX, int posY) {
		int originPosX = posX;
		int originPosY = posY;

		posX--;
		posY--;

		System.out.println(Arrays.toString(grid));
		System.out.println(grid[1]);
		System.out.println(grid[2]);
		System.out.println("I'm choosing: " + grid[originPosY][originPosX] + " which is at " + originPosY + " and " + originPosX);
		
		int row = posX;
		int col = posY;

		while (row >= posY && row <= originPosY + 1) {
			// make sure not out of bounds of box
			if (row >= 0 && row <= 2) {
				while (col >= posX && col <= originPosX + 1) {
					// make sure not out of bounds of box
					if (col >= 0 && col <= 2) {
						if (!(row == originPosY && col == originPosX)) {
							System.out.println("Row: " + row + " and col: " + col + " = " + grid[row][col]);
						}
					}
					col++;
				}
			}
			// start at initial value again in new row
			col = posX;
			row++;
		}
	}

	@Override
	public String toString() {
		return "FindNeighbours{" + "testGrid=" + Arrays.toString(testGrid) + '}';
	}
	

	public static void main(String[] args) {
		FindNeighbours getNeighbours = new FindNeighbours();
		int[][] testGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		// values here to test
		getNeighbours.getValidNeighbourElement(testGrid, 1, 1);
	}
}
