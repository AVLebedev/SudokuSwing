package asd.GamesLite;

import java.util.*;

public class Core {
    private static Main app;
    private static boolean isPause = true;

    /* ������ � ������ �������� ���� */
    public static int n = 5;
    public static int m = 5;

    /* ����������� ���� ��� �������� ���� */
    public static int[][] playingField;
    public static boolean startGame = false;

    /* TODO: �������������� ���� ��� �������� ���� */

    /* ����������� ������ ��� �������� ���� */
    public static void startGame(Main main) {
    	app = main;
        startGame = true;
    }

    /* TODO: �������������� ������ ��� �������� ���� */

    /* ����������� ������ ��������� ������� ������ */
    public static void goUp() {
        // ��������� ������� ������� �����
    }

    public static void goDown() {
        // ��������� ������� ������� ����
    }

    public static void goLeft() {
        // ��������� ������� ������� �����
    }

    public static void goRight() {
        // ��������� ������� ������� ������
    }

    /* TODO: �������������� ������ ��������� ������� ������ */
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