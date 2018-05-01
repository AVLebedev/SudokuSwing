package asd;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel{
	
	public ButtonsPanel(ArrayField arrayField, ArrayPanel arrayPanel ) {
		for (int i = 1; i < 10; i++){
			NumButton btnInit = new NumButton(i, arrayField, arrayPanel); 
			this.add(btnInit);
		}		
		this.setLayout(new GridLayout(3, 3));
	}
	
	public void paint(Graphics g)  {
		super.paint(g);			
	}
}

