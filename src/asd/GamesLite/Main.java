package asd.GamesLite;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import asd.ArrayField;
import asd.ButtonsPanel;
import asd.SudokuCell;


public class Main {

	private JFrame frame;
	private ArrayField arrayField;
	private PainterPanel panel;
	private ButtonsPanel panel1;

	public static SudokuCell currentCell;
	

	/**
	 * Launch the application.
	 */
	public static void main(String args []) {
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
	    UIManager.put("OptionPane.yesButtonText", "Да"    );
	    UIManager.put("OptionPane.noButtonText", "Нет"   );
	    UIManager.put("OptionPane.cancelButtonText", "Отмена");
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 100, 589, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		panel = new PainterPanel();
		arrayField = new ArrayField(panel, frame);
		panel.setBorder(new LineBorder(Color.BLACK, 3));
		panel.setBounds(150, 50, 256, 256);		
		frame.getContentPane().add(panel);
		
		// Чтобы наша панель принимала нажатия клавиш
        // мыши или клавиатуры, следует установить фокус на нее
        panel.setFocusable(true);

        /* Ообработчики нажатия клавиш */
        // Нажатия клавиш клавиатуры
        panel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                //SudokuController.controlKey(e.getKeyCode(), arrayField, panel);
                panel.repaint();
            }
        });
		
		
		panel1 = new ButtonsPanel(arrayField, panel);
		panel1.setBounds(153, 310, 250, 200); 
		frame.getContentPane().add(panel1);
		
		
		JButton btnInit = new JButton("Начать");
		btnInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				arrayField.initStart(panel, 0);
			}
		});
		btnInit.setBounds(150, 11, 256, 28);
		frame.getContentPane().add(btnInit);
		
		JButton btnInit1 = new JButton("Назад");
		btnInit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				arrayField.initBack(panel);
			}
		});
		btnInit1.setBounds(50, 450, 80, 28);
		frame.getContentPane().add(btnInit1);
		
		JButton btnInit2 = new JButton("Вперёд");
		btnInit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				arrayField.initNext(panel);
			}
		});
		btnInit2.setBounds(420, 450, 80, 28);
		frame.getContentPane().add(btnInit2);

		
        /* Методы для запуска игры */
//        Controller.start();
	}
}
