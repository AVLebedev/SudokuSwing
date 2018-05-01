package asd;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class NumButton extends JButton implements ActionListener {

	private ArrayField arrayField;
	private ArrayPanel arrayPanel;
	
	public NumButton(Integer num, ArrayField field, ArrayPanel panel){
		this.setHorizontalAlignment(CENTER);
		this.setVerticalAlignment(CENTER);
		this.addActionListener(this);
		this.setText(num.toString()); 
		this.setFont(new Font("Verdana", Font.PLAIN, 18));
		this.arrayField = field;
		this.arrayPanel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		arrayField.setCellValue(arrayPanel, this.getText());
	}

}

