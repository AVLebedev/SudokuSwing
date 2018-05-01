package asd.GamesLite;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Main {
    private static JFrame frame;
    private static JPanel panel;

    public Main() {
        initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initialize() {
        // ������� ����
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* ������� ������ ��� ��������� */
        panel = new PainterPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        // ����� ���� ������ ��������� ������� ������
        // ���� ��� ����������, ������� ���������� ����� �� ���
        panel.setFocusable(true);

        /* ������������ ������� ������ */
        // ������� ������ ����������
        panel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                Controller.controlKey(e.getKeyCode());
                panel.repaint();
            }
        });

        /* ������ ��� ������� ���� */
        Controller.start();
    }
}