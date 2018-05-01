package asd;

import java.awt.event.KeyEvent;

import asd.GamesLite.Controller;

public class SudokuController extends Controller {
	
	public static void controlKey(int key, ArrayField field, ArrayPanel panel) {
		/* —тандартна€ обработка нажати€ клавиш клавиатуры */
		Controller.controlKey(key);
        
        /* TODO: ƒополнительна€ обработка нажати€ клавиш клавиатуры */
		switch(key){
		
			case KeyEvent.VK_0:
				field.setCellValue(panel, "0");
				break;
			case KeyEvent.VK_1:
				field.setCellValue(panel, "1");
				break;
			case KeyEvent.VK_2:
				field.setCellValue(panel, "2");
				break;
			case KeyEvent.VK_3:
				field.setCellValue(panel, "3");
				break;
			case KeyEvent.VK_4:
				field.setCellValue(panel, "4");
				break;
			case KeyEvent.VK_5:
				field.setCellValue(panel, "5");
				break;
			case KeyEvent.VK_6:
				field.setCellValue(panel, "6");
				break;
			case KeyEvent.VK_7:
				field.setCellValue(panel, "7");
				break;
			case KeyEvent.VK_8:
				field.setCellValue(panel, "8");
				break;
			case KeyEvent.VK_9:
				field.setCellValue(panel, "9");
				break;
		}
    }
}
