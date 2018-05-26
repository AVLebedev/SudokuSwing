package asd.GamesLite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.*;

import javax.swing.JOptionPane;

import asd.ArrayField;

public class Core {

    /* ���� ��� �������� ���� */
    private static Main app;
    private static ArrayField playingField;
    public static boolean startGame = false;
    private static boolean isPause = true;
    private static String currentUser;

    /* ����������� ������ ��� �������� ���� */
    public static void startGame(Main main, ArrayField field, String user) {
    	app = main;
    	playingField = field;
        startGame = true;
        currentUser = user;
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
    	playingField.setCellValue(value, currentUser);
    }
    
    public static void saveGame(){
    	playingField.saveField(currentUser);
    	app.hideMenu();
    }
    
    public static void loadGame(String user){
    	if(playingField.restoreField(user)){
    		currentUser = user;
    		app.hideMenu();
    	} else {
    		JOptionPane.showMessageDialog(null, "���������� �� �������!", "", JOptionPane.INFORMATION_MESSAGE);
    	}
    }
}