package com.dan;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PipeTile extends Tile {

	private static final long serialVersionUID = 1L;

	public static final char LEFT_DOWN = '\u2554';
	public static final char RIGHT_DOWN = '\u2556';
	public static final char DOWN = '\u2552';
	public static final char HORIZONTAL = '\u2550';
	public static final char DOWN_RIGHT = '\u255A';
	public static final char DOWN_LEFT = '\u255D';
	public static final char EMPTY = '\u0000';

	private char c;
	private int col;
	private int row;
	private boolean isFlowing;

	public static final Map<Character, Set<Character>> FLOWS_RIGHT = new HashMap<Character, Set<Character>>() {
		private static final long serialVersionUID = 1L;
		{
			put(LEFT_DOWN, Collections.emptySet());
			put(RIGHT_DOWN, Collections.emptySet());
			put(DOWN, Collections.emptySet());
			put(HORIZONTAL, new HashSet<Character>(Arrays.asList(RIGHT_DOWN, HORIZONTAL)));
			put(DOWN_RIGHT, new HashSet<Character>(Arrays.asList(HORIZONTAL, RIGHT_DOWN)));
			put(DOWN_LEFT, Collections.emptySet());
		}
	};

	public static final Map<Character, Set<Character>> FLOWS_LEFT = new HashMap<Character, Set<Character>>() {
		private static final long serialVersionUID = 1L;
		{
			put(LEFT_DOWN, Collections.emptySet());
			put(RIGHT_DOWN, Collections.emptySet());
			put(DOWN, Collections.emptySet());
			put(HORIZONTAL, new HashSet<Character>(Arrays.asList(LEFT_DOWN, HORIZONTAL)));
			put(DOWN_RIGHT, Collections.emptySet());
			put(DOWN_LEFT, new HashSet<Character>(Arrays.asList(HORIZONTAL, LEFT_DOWN)));
		}
	};

	public static final Map<Character, Set<Character>> FLOWS_DOWN = new HashMap<Character, Set<Character>>() {
		private static final long serialVersionUID = 1L;
		{
			put(LEFT_DOWN, new HashSet<Character>(Arrays.asList(DOWN, DOWN_RIGHT, DOWN_LEFT)));
			put(RIGHT_DOWN, new HashSet<Character>(Arrays.asList(DOWN, DOWN_RIGHT, DOWN_LEFT)));
			put(DOWN, new HashSet<Character>(Arrays.asList(DOWN, DOWN_RIGHT, DOWN_LEFT)));
			put(HORIZONTAL, Collections.emptySet());
			put(DOWN_RIGHT, Collections.emptySet());
			put(DOWN_LEFT, Collections.emptySet());
		}
	};

	public static PipeTile buildEmptyTile(int row, int col) {
		return new PipeTile(EMPTY, row, col);
	}

	public static PipeTile buildLeftDownTile(int row, int col) {
		return new PipeTile(LEFT_DOWN, row, col);
	}

	public static PipeTile buildRightDownTile(int row, int col) {
		return new PipeTile(RIGHT_DOWN, row, col);
	}

	public static PipeTile buildDownTile(int row, int col) {
		return new PipeTile(DOWN, row, col);
	}

	public static PipeTile buildHorizontalTile(int row, int col) {
		return new PipeTile(HORIZONTAL, row, col);
	}

	public static PipeTile buildDownRightTile(int row, int col) {
		return new PipeTile(DOWN_RIGHT, row, col);
	}

	public static PipeTile buildDownLeftTile(int row, int col) {
		return new PipeTile(DOWN_LEFT, row, col);
	}

	public PipeTile() {
		this(' ', -1, -1);
	}

	public PipeTile(char c) {
		this(c, -1, -1);
	}

	public PipeTile(char c, int row, int col) {
		super("" + c);
		this.c = c;
		this.row = row;
		this.col = col;
	}

	public PipeTile(char c, int row, int col,ActionListener l) {
		super("" + c);
		this.c = c;
		this.row = row;
		this.col = col;
		addActionListener(l);
	}

	public boolean flowsDown(PipeTile other) {
		return isUnderMe(other) && FLOWS_DOWN.get(c).contains(other.c);
	}

	public boolean flowsLeft(PipeTile other) {
		return isOnMyLeft(other) && FLOWS_LEFT.get(c).contains(other.c);
	}

	public boolean flowsRight(PipeTile other) {
		return isOnMyRight(other) && FLOWS_RIGHT.get(c).contains(other.c);
	}

	public boolean isOnMyRight(PipeTile other) {
		return row == other.row && other.col - col == 1;
	}

	public boolean isOnMyLeft(PipeTile other) {
		return row == other.row && col - other.col == 1;
	}

	public boolean isUnderMe(PipeTile other) {
		return col == other.col && other.row - row == 1;
	}

	public char getC() {
		return c;
	}

	public boolean isFlowing() {
		return isFlowing;
	}

	public void setFlowing(boolean isFlowing) {
		setFont(getFont().deriveFont(isFlowing ? Font.BOLD : Font.PLAIN));
		setSelected(isFlowing);
		// setBackground(isFlowing?Color.BLUE:Color.WHITE);
		this.isFlowing = isFlowing;
	}

}
