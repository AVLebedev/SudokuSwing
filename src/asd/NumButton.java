package asd;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import asd.GamesLite.Controller;
import asd.GamesLite.Core;

public class NumButton extends JButton implements ActionListener {

	private ArrayField arrayField;
	
	public NumButton(Integer num, ArrayField field){
		this.setHorizontalAlignment(CENTER);
		this.setVerticalAlignment(CENTER);
		this.addActionListener(this);
		this.setText(num.toString());
		this.setFont(new Font("Verdana", Font.PLAIN, 18));
		this.arrayField = field;
		this.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				Controller.controlKey(e.getKeyCode());
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Core.setCellValue(this.getText());
	}
}

