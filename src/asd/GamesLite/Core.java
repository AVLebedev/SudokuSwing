package asd.GamesLite;

import java.util.*;

public class Core {
    private static Main app;
    private static boolean isPause = true;

    /* Высота и ширина игрового поля */
    public static int n = 5;
    public static int m = 5;

    /* Стандартные поля для создания игры */
    public static int[][] playingField;
    public static boolean startGame = false;

    /* TODO: Дополнительные поля для создания игры */

    /* Стандартные методы для создания игры */
    public static void startGame(Main main) {
    	app = main;
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

    /* TODO: Дополнительные методы обработки нажатых клавиш */
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
}