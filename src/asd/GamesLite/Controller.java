package asd.GamesLite;

import java.awt.event.*;

public class Controller {
    public static void start() {
        /* ����������� ������ ������� ���� */
        Core.startGame();

        /* TODO: �������������� ������ ������� ���� */

    }

    public static void controlKey(int key) {
        /* ����������� ��������� ������� ������ ���������� */
        if (KeyEvent.VK_UP == key) {
            Core.goUp();
        } else if (KeyEvent.VK_DOWN == key) {
            Core.goDown();
        } else if (KeyEvent.VK_LEFT == key) {
            Core.goLeft();
        } else if (KeyEvent.VK_RIGHT == key) {
            Core.goRight();
        }

        /* TODO: �������������� ��������� ������� ������ ���������� */

    }
}