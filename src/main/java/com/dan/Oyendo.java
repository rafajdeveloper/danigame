package com.dan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Oyendo implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource().getClass().getName());
		
	}
}
