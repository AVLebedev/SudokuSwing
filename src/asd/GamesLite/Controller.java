package asd.GamesLite;

import java.awt.event.*;

public class Controller {
    public static void start() {
        /* —тандартные методы запуска игры */
        Core.startGame();

        /* TODO: ƒополнительные методы запуска игры */

    }

    public static void controlKey(int key) {
        /* —тандартна€ обработка нажати€ клавиш клавиатуры */
        if (KeyEvent.VK_UP == key) {
            Core.goUp();
        } else if (KeyEvent.VK_DOWN == key) {
            Core.goDown();
        } else if (KeyEvent.VK_LEFT == key) {
            Core.goLeft();
        } else if (KeyEvent.VK_RIGHT == key) {
            Core.goRight();
        }

        /* TODO: ƒополнительна€ обработка нажати€ клавиш клавиатуры */

    }
}