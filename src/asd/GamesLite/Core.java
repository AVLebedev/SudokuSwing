package asd.GamesLite;

import java.util.*;

public class Core {
    /* ��������� ��������� ����� (random) */
    private static Random random = new Random(System.currentTimeMillis());

    /* ������ � ������ �������� ���� */
    public static int n = 5;
    public static int m = 5;

    /* ����������� ���� ��� �������� ���� */
    public static int[][] playingField;
    public static boolean startGame;

    /* TODO: �������������� ���� ��� �������� ���� */

    /* ����������� ������ ��� �������� ���� */
    public static void startGame() {
        startGame = true;
        playingField = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                playingField[i][j] = 0;
            }
        }
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

}