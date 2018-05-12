package asd.GamesLite;

import java.awt.event.*;
import java.util.Arrays;

import asd.ArrayField;

public class Controller {
	public static void start(Main main, ArrayField field) {
		/* —тандартные методы запуска игры */
		Core.startGame(main, field);
	}
	
	//—писок клавиш дл€ простановки значени€ клетки
	final static int[] cellValues = { 
			KeyEvent.VK_1, 
			KeyEvent.VK_2, 
			KeyEvent.VK_3, 
			KeyEvent.VK_4, 
			KeyEvent.VK_5, 
			KeyEvent.VK_6, 
			KeyEvent.VK_7, 
			KeyEvent.VK_8, 
			KeyEvent.VK_9
		};

	public static void controlKey(int key) {
		/* ќбработка нажати€ клавиш клавиатуры */
		if(Core.startGame == false)
			return;
		switch (key) {
			case (KeyEvent.VK_ESCAPE):
				Core.switchMenu();
			case (KeyEvent.VK_UP):
				Core.goUp();
				break;
			case (KeyEvent.VK_DOWN):
				Core.goDown();
				break;
			case (KeyEvent.VK_LEFT):
				Core.goLeft();
				break;
			case (KeyEvent.VK_RIGHT):
				Core.goRight();
				break;
			default:
				if(Arrays.stream(cellValues).anyMatch(v -> v == key))
					Core.setCellValue(KeyEvent.getKeyText(key));
		}
	}
}