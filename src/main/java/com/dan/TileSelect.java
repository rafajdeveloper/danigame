package com.dan;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javax.swing.JRadioButton;

public class TileSelect extends JRadioButton {

	private static final long serialVersionUID = 1L;

	private char c;

	public TileSelect(Oyendo oyendo, char c) {
		this.c = c;
		this.addActionListener((e) -> {
			if (isSelected()) {
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection("" + c), null);
			}
		});
	}
	
	public char getC() {
		return c;
	}
	

}
