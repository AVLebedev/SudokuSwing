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
	private JButton btnInit;
	private JButton btnInit1;
	private JButton btnInit2;
	private JButton btnResume;
	private JButton btnSave;
	
//	private JTextField userField;

	public static SudokuCell currentCell;
	private static String currentUser = "";

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
		// ����������� ������
		UIManager.put("OptionPane.yesButtonText", "��");
		UIManager.put("OptionPane.noButtonText", "���");
		UIManager.put("OptionPane.cancelButtonText", "������");
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
		/* �������� ��������� ������� ������ ����������� */
		keyAdapter = new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				Controller.controlKey(e.getKeyCode());
			}
		};
		
		/* ������������� ��������� */
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
		arrayField = new ArrayField(frame, panel);
		panel.setBorder(new LineBorder(Color.BLACK, 3));
		panel.setBounds(150, 50, 256, 256);
		frame.getContentPane().add(panel);

		panel1 = new ButtonsPanel(arrayField, panel);
		panel1.setBounds(153, 310, 250, 200);
		frame.getContentPane().add(panel1);
		
		btnMenu = new JButton("����");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMenu();				
			}
		});
		btnMenu.addKeyListener(keyAdapter);
		btnMenu.setBounds(150, 11, 256, 28);
		frame.getContentPane().add(btnMenu);

		btnInit = new JButton("����� ����");
		btnResume = new JButton("����������");
		btnSave = new JButton("���������");
		JButton btnLoad = new JButton("��������� ����");
		JButton btnExit = new JButton("�����");

//		userField = new JTextField();
//		userField.setMaximumSize(new Dimension(200, btnInit.getMaximumSize().height));
//		menuPanel.add(userField);
		
		btnInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkUser("����� ����");	
				if(currentUser.isEmpty() == false){
					startGame();
					arrayField.initStart(currentUser);
					hideMenu();
				}
			}
		});
		btnInit.addKeyListener(keyAdapter);
		btnInit.setFont(new Font(btnInit.getFont().getFamily(), Font.PLAIN, 20));
		btnInit.setMaximumSize(new Dimension(200, btnInit.getMaximumSize().height));
		menuPanel.add(btnInit);

		btnResume.setEnabled(false);
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hideMenu();
			}
		});
		btnResume.addKeyListener(keyAdapter);
		btnResume.setFont(new Font(btnResume.getFont().getFamily(), Font.PLAIN, 20));
		btnResume.setMaximumSize(new Dimension(200, btnResume.getMaximumSize().height));
		menuPanel.add(btnResume);
		
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkUser("����������");
				Core.saveGame();			
			}
		});
		btnSave.addKeyListener(keyAdapter);
		btnSave.setFont(btnInit.getFont());
		btnSave.setMaximumSize(btnInit.getMaximumSize());
//		menuPanel.add(btnSave);
		
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentUser = "";
				checkUser("��������");
				if(currentUser.isEmpty() == false){
					startGame();
					Core.loadGame(currentUser);
				}
			}
		});
		btnLoad.addKeyListener(keyAdapter);
		btnLoad.setFont(btnInit.getFont());
		btnLoad.setMaximumSize(btnInit.getMaximumSize());
		menuPanel.add(btnLoad);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);				
			}
		});
		btnExit.addKeyListener(keyAdapter);
		btnExit.setFont(btnInit.getFont());
		btnExit.setMaximumSize(btnInit.getMaximumSize());
		menuPanel.add(btnExit);

		btnInit1 = new JButton("�����");
		btnInit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arrayField.initBack(currentUser);
			}
		});
		btnInit1.addKeyListener(keyAdapter);
		btnInit1.setBounds(50, 450, 80, 28);
		frame.getContentPane().add(btnInit1);

		btnInit2 = new JButton("�����");
		btnInit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arrayField.initNext(currentUser);
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
	
	private void startGame(){
		if (Core.startGame == false) {
			Controller.start(this, arrayField, currentUser);
			btnResume.setEnabled(true);
			btnSave.setEnabled(true);
		}
	}
	
	private void checkUser(String title){
		do{
			currentUser = JOptionPane.showInputDialog(null, "������� ��� ������������", title, JOptionPane.QUESTION_MESSAGE);
			if(currentUser == null){
				currentUser = "";
				return;
			}
		} while(currentUser.isEmpty());
	}
}
