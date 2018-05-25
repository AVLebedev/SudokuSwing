package asd.GamesLite;

import java.util.*;

import asd.ArrayField;

public class Core {

    /* Поля для создания игры */
    private static Main app;
    private static ArrayField playingField;
    public static boolean startGame = false;
    private static boolean isPause = true;

    /* Стандартные методы для создания игры */
    public static void startGame(Main main, ArrayField field) {
    	app = main;
    	playingField = field;
        startGame = true;
    }

    /* TODO: Дополнительные методы для создания игры */

    /* Стандартные методы обработки нажатых клавиш */
    public static void goUp() {
        // Обработка нажатой клавиши вверх
    }
    public static void goDown() {
        // Обработка нажатой клавиши вниз
    }
    public static void goLeft() {
        // Обработка нажатой клавиши влево
    }
    public static void goRight() {
        // Обработка нажатой клавиши вправо
    }

    /* Дополнительные методы обработки нажатых клавиш */
    public static void switchMenu(){
    	if(isPause == false){
    		app.hideMenu();
    		isPause = true;
    	}
    	else{
    		app.showMenu();
    		isPause = false;
    	}
    }    
    public static void setCellValue(String value){
    	playingField.setCellValue(value);
    }
    
    public static void saveGame(){
    	/* ToDo: реализовать запись в файл 
    	String savedArray = playingField.toString();
    	*/
    	playingField.saveField();
    	app.hideMenu();
    }
    
    public static void loadGame(){
    	/* ToDo: реализовать чтение из файла */
    	playingField.restoreField();
    	app.hideMenu();
    }
}