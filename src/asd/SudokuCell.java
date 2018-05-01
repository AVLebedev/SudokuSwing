package asd;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import asd.GamesLite.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

class CellPosition {
	public int x;
	public int y;
	public CellPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean isEqual(CellPosition pos){
		return this.x == pos.x && this.y == pos.y;
	}
}

public class SudokuCell extends JLabel implements MouseListener, KeyListener {
	private CellPosition position;
	
	public SudokuCell(int x, int y){
		this.position = new CellPosition(x, y);
	 	this.setHorizontalAlignment(CENTER);
		this.setVerticalAlignment(CENTER);
		this.setFont(new Font("Verdana", Font.PLAIN, 14));
		this.setBackground(Color.WHITE);
 	    this.setOpaque(true);
		this.addKeyListener(this);
		this.addMouseListener(this);
	}


	public CellPosition getPosition(){
		return position;
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		this.setText(KeyEvent.getKeyText(e.getKeyCode()));
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
    public void keyTyped(KeyEvent e) {}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Main.currentCell = this;
		if(isEnabled()) {
			this.setBackground(Color.GREEN);
		} else {
			this.setBackground(Color.PINK);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
