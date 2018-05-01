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
        // Создаем окно
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Создаем панель для отрисовки */
        panel = new PainterPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        // Чтобы наша панель принимала нажатия клавиш
        // мыши или клавиатуры, следует установить фокус на нее
        panel.setFocusable(true);

        /* Ообработчики нажатия клавиш */
        // Нажатия клавиш клавиатуры
        panel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                Controller.controlKey(e.getKeyCode());
                panel.repaint();
            }
        });

        /* Методы для запуска игры */
        Controller.start();
    }
}