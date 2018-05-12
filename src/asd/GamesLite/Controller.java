package asd.GamesLite;

import java.awt.event.*;

public class Controller {
	public static void start(Main main) {
		/* Стандартные методы запуска игры */
		Core.startGame(main);
	}

	public static void controlKey(int key) {
		/* Обработка нажатия клавиш клавиатуры */
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
			}
	}
}