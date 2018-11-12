package com.dan;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class CapacitySpinner extends JSpinner{
	
	private static final long serialVersionUID = 1L;
	
	public CapacitySpinner() {
		super(new SpinnerNumberModel(1,1,10,1));
	}

}
