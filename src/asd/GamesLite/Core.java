package asd.GamesLite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
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

    /* �������������� ������ ��������� ������� ������ */
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
    	playingField.saveField();
    	app.hideMenu();
    }
    
    public static void loadGame(){
    	playingField.restoreField();
    	app.hideMenu();
    }
}