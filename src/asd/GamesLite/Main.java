package asd.GamesLite;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import asd.ArrayField;
import asd.ButtonsPanel;
import asd.SudokuCell;

public class Main {
	private KeyAdapter keyAdapter;

	private JFrame frame;
	private ArrayField arrayField;
	private PainterPanel panel;
	private ButtonsPanel panel1;
	private JPanel menuPanel; 
	
	private JButton btnMenu;
	private JButton btnInit1;
	private JButton btnInit2;

	public static SudokuCell currentCell;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
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
		// Локализация кнопок
		UIManager.put("OptionPane.yesButtonText", "Да");
		UIManager.put("OptionPane.noButtonText", "Нет");
		UIManager.put("OptionPane.cancelButtonText", "Отмена");
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		showMenu();
	}

	/*
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		/* Передача обработки нажатия клавиш контроллеру */
		keyAdapter = new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				Controller.controlKey(e.getKeyCode());
			}
		};
		
		/* Инициализация элементов */
		frame = new JFrame();
		frame.setBounds(300, 100, 600, 550);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		menuPanel.setBackground(Color.pink);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.add(Box.createRigidArea(new Dimension(170, 180)));
		frame.getContentPane().add(menuPanel);

		panel = new PainterPanel();
		arrayField = new ArrayField(panel, frame);
		panel.setBorder(new LineBorder(Color.BLACK, 3));
		panel.setBounds(150, 50, 256, 256);
		frame.getContentPane().add(panel);

		panel1 = new ButtonsPanel(arrayField, panel);
		panel1.setBounds(153, 310, 250, 200);
		frame.getContentPane().add(panel1);

		btnMenu = new JButton("Меню");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMenu();				
			}
		});
		btnMenu.addKeyListener(keyAdapter);
		btnMenu.setBounds(150, 11, 256, 28);
		frame.getContentPane().add(btnMenu);

		Main self = this;
		JButton btnInit = new JButton("Новая игра");
		btnInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Core.startGame == false) {
					Controller.start(self);
					arrayField.initStart(panel, 0);
					btnInit.setText("Продолжить");
				}
				hideMenu();
			}
		});
		btnInit.addKeyListener(keyAdapter);
		btnInit.setFont(new Font(btnInit.getFont().getFamily(), Font.PLAIN, 20));
		btnInit.setMaximumSize(new Dimension(200, btnInit.getMaximumSize().height));
		menuPanel.add(btnInit);
		
		JButton btnSave = new JButton("Сохранить");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ToDo: реализовать сохранение игры				
			}
		});
		btnSave.addKeyListener(keyAdapter);
		btnSave.setFont(btnInit.getFont());
		btnSave.setMaximumSize(btnInit.getMaximumSize());
		menuPanel.add(btnSave);
		
		JButton btnResume = new JButton("Загрузить игру");
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Core.startGame = true;
				arrayField.initStart(panel, 0);
				btnInit.setText("Продолжить");
				hideMenu();
			}
		});
		btnResume.addKeyListener(keyAdapter);
		btnResume.setFont(btnInit.getFont());
		btnResume.setMaximumSize(btnInit.getMaximumSize());
		menuPanel.add(btnResume);
		
		JButton btnExit = new JButton("Выход");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);				
			}
		});
		btnExit.addKeyListener(keyAdapter);
		btnExit.setFont(btnInit.getFont());
		btnExit.setMaximumSize(btnInit.getMaximumSize());
		menuPanel.add(btnExit);

		btnInit1 = new JButton("Назад");
		btnInit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arrayField.initBack(panel);
			}
		});
		btnInit1.addKeyListener(keyAdapter);
		btnInit1.setBounds(50, 450, 80, 28);
		frame.getContentPane().add(btnInit1);

		btnInit2 = new JButton("Вперёд");
		btnInit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arrayField.initNext(panel);
			}
		});
		btnInit2.addKeyListener(keyAdapter);
		btnInit2.setBounds(420, 450, 80, 28);
		frame.getContentPane().add(btnInit2);
	}

	public void showMenu() {
		btnMenu.setVisible(false);
		panel.setVisible(false);
		panel1.setVisible(false);
		btnInit1.setVisible(false);
		btnInit2.setVisible(false);
		menuPanel.setVisible(true);
	}

	public void hideMenu() {
		btnMenu.setVisible(true);
		panel.setVisible(true);
		panel1.setVisible(true);
		btnInit1.setVisible(true);
		btnInit2.setVisible(true);
		menuPanel.setVisible(false);
	}
}
