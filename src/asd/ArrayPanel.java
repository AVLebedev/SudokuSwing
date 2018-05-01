package asd;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

import asd.GamesLite.PainterPanel;

public class ArrayPanel extends PainterPanel {

	private int n, m;

	public ArrayPanel() {
		n = 9;
		m = 9;
		this.setLayout(new GridLayout(n, m, 5, 5));
	}

	@Override
	public void paint(Graphics g)  {
		super.paint(g);		
		drawArray(g, this.getWidth(), this.getHeight());
	}
	
	final private int FAT_LINE = 3;
	final private int SLIM_LINE = 1;
	private void drawArray(Graphics g, int width, int height) {
		int cellHeight =  height / n;
		int cellWidth =  width / m;
		for (int i = 0; i < n; i++) {			
			int top = i * cellHeight;
			for (int j = 0; j < m; j++) {
				int left = j * cellWidth;
				g.setColor(Color.black);
				Graphics2D g2d =(Graphics2D) g;
				if(i%3 == 0){
					g2d.setStroke(new BasicStroke(FAT_LINE));
					g.drawLine(left, top, left+cellWidth, top);
					g2d.setStroke(new BasicStroke(SLIM_LINE));
					g.drawLine(left, top, left, top+cellHeight);
				} 
				else {
					g2d.setStroke(new BasicStroke(SLIM_LINE));
					g.drawLine(left, top, left+cellWidth, top);
					g.drawLine(left, top, left, top+cellHeight);
				}
				if (j%3 == 0){
					g2d.setStroke(new BasicStroke(FAT_LINE));
					g.drawLine(left, top, left, top+cellHeight);
					g2d.setStroke(new BasicStroke(SLIM_LINE));
					g.drawLine(left, top, left+cellWidth, top);
				} else {
					g2d.setStroke(new BasicStroke(SLIM_LINE));
					g.drawLine(left, top, left+cellWidth, top);
					g.drawLine(left, top, left, top+cellHeight);
				}
			}
		}
	}
}
