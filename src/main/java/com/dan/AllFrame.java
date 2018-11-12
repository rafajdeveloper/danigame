package com.dan;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AllFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public AllFrame() {
		super();
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public AllFrame(JPanel northPanel, JPanel eastPanel, JPanel tankPanel, JPanel gridPanel) {
		this();
		add(northPanel,BorderLayout.NORTH);
		add(eastPanel,BorderLayout.EAST);
		JPanel center = new JPanel(new GridLayout(2,1));
		center.add(tankPanel);
		center.add(gridPanel);
		add(center,BorderLayout.CENTER);
	}

}
