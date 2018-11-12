package com.dan;

import javax.swing.JRadioButton;

public class TileSelect extends JRadioButton {

	private static final long serialVersionUID = 1L;

	private char c;

	public TileSelect(Oyendo oyendo, char c) {
		this.c = c;
		this.addActionListener(oyendo);
	}
	
	public char getC() {
		return c;
	}
	

}
