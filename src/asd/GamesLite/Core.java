package asd.GamesLite;

import java.util.*;

public class Core {
    /* Генератол случайных чисел (random) */
    private static Random random = new Random(System.currentTimeMillis());

    /* Высота и ширина игрового поля */
    public static int n = 5;
    public static int m = 5;

    /* Стандартные поля для создания игры */
    public static int[][] playingField;
    public static boolean startGame;

    /* TODO: Дополнительные поля для создания игры */

    /* Стандартные методы для создания игры */
    public static void startGame() {
        startGame = true;
        playingField = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                playingField[i][j] = 0;
            }
        }
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

}