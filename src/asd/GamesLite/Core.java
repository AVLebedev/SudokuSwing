package asd.GamesLite;

import java.util.*;

import asd.ArrayField;

public class Core {

    /* ���� ��� �������� ���� */
    private static Main app;
    private static ArrayField playingField;
    public static boolean startGame = false;
    private static boolean isPause = true;

    /* ����������� ������ ��� �������� ���� */
    public static void startGame(Main main, ArrayField field) {
    	app = main;
    	playingField = field;
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