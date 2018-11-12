package com.dan;

public class TileGrid {

	public static final int ROWS = 10;
	public static final int COLS = 10;

	private PipeTile[][] grid;

	public TileGrid() {
		grid = new PipeTile[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				grid[ROWS][COLS] = PipeTile.buildEmptyTile(i, j);
			}
		}
	}

	public Tile[][] getGrid() {
		return grid;
	}

}
