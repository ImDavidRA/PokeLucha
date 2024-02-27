package prueba2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;

public class PantallaJuego extends JFrame {
	
	final static int TIEMPO = 2000;
	
	int xMouse, yMouse;
	private JFrame thisFrame;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JLabel P1_zombie = new JLabel("");
	private JLabel P2_zombie = new JLabel("");

	JLabel P2_hpText = new JLabel();
	JLabel P1_hpText = new JLabel();
	
	JProgressBar P2_hp = new JProgressBar();
	JProgressBar P1_hp = new JProgressBar();
	
	Thread thread = new Thread(new Thread());
	
	Login inicio = new Login();
	
	public PantallaJuego() {		
		setLocationByPlatform(true);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		thisFrame = this;

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel background = new JPanel();
		background.setBounds(0, 0, 850, 500);
		background.setBackground(new Color(255, 255, 255));
		contentPane.add(background);
		background.setLayout(null);

		JLabel img_Logo_txt_Logo = new JLabel("COMBATE");
		img_Logo_txt_Logo.setForeground(Color.WHITE);
		img_Logo_txt_Logo.setHorizontalAlignment(SwingConstants.CENTER);
		img_Logo_txt_Logo.setFont(new Font("Retro Gaming", Font.BOLD, 60));
		img_Logo_txt_Logo.setBounds(137, 34, 530, 85);
		background.add(img_Logo_txt_Logo);

		JLabel txt_P1 = new JLabel("PLAYER1");
		txt_P1.setBackground(Color.WHITE);
		txt_P1.setForeground(Color.BLACK);
		txt_P1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_P1.setFont(new Font("Retro Gaming", Font.BOLD, 30));
		txt_P1.setBounds(525, 406, 180, 25);
		background.add(txt_P1);

		JLabel txt_P2 = new JLabel("PLAYER2");
		txt_P2.setForeground(Color.BLACK);
		txt_P2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_P2.setFont(new Font("Retro Gaming", Font.BOLD, 30));
		txt_P2.setBounds(261, 155, 180, 25);
		background.add(txt_P2);

		JPanel barra = new JPanel();
		barra.setForeground(new Color(255,255,255,0));
		barra.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				PantallaJuego.this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
			}
		});
		barra.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse=e.getX();
				yMouse=e.getY();
			}
		});
		barra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		barra.setBackground(new Color(255, 255, 255, 0));
		barra.setBounds(45, 0, 759, 35);
		background.add(barra);
												
												
												P1_zombie.setHorizontalAlignment(SwingConstants.CENTER);
												P1_zombie.setBounds(53, 241, 300, 213);
												background.add(P1_zombie);
												
												P2_zombie.setHorizontalAlignment(SwingConstants.CENTER);
												P2_zombie.setBounds(424, 130, 300, 213);
												background.add(P2_zombie);
														
														
														P2_hp.setBorderPainted(false);
														P2_hp.setForeground(Color.GREEN);
														P2_hp.setBackground(Color.RED);
														P2_hp.setFont(new Font("Retro Gaming", Font.BOLD, 11));
														P2_hp.setBounds(247, 202, 146, 14);
														background.add(P2_hp);
														P2_hp.setValue(50);
																
																
																P2_hpText.setFont(new Font("Retro Gaming", Font.BOLD, 11));
																P2_hpText.setForeground(Color.WHITE);
																P2_hpText.setBounds(171, 202, 65, 14);
																background.add(P2_hpText);
																
																JLabel btn_X = new JLabel("X");
																btn_X.setForeground(Color.WHITE);
																btn_X.setBackground(new Color(255, 255, 255));
																btn_X.addMouseListener(new MouseAdapter() {
																	@Override
																	public void mouseClicked(MouseEvent e) {
																		System.exit(0);
																	}
																	@Override
																	public void mouseEntered(MouseEvent e) {
																		btn_X.setForeground(Color.red);
																	}
																	@Override
																	public void mouseExited(MouseEvent e) {
																		btn_X.setForeground(Color.WHITE);
																	}
																});
																btn_X.setBorder(null);
																btn_X.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																btn_X.setFont(new Font("Retro Gaming", Font.BOLD, 25));
																btn_X.setHorizontalAlignment(SwingConstants.CENTER);
																btn_X.setBounds(0, 0, 46, 35);
																background.add(btn_X);
																
																
																		JLabel img_Bg = new JLabel("");
																		img_Bg.setHorizontalTextPosition(SwingConstants.CENTER);
																		img_Bg.setHorizontalAlignment(SwingConstants.CENTER);
																		img_Bg.setIcon(new ImageIcon("C:\\Users\\david\\Desktop\\images\\FondoCombate.gif"));
																		img_Bg.setFont(new Font("Retro Gaming", Font.BOLD, 11));
																		img_Bg.setBounds(0, 0, 804, 500);
																		background.add(img_Bg);
	
																		
																		
																		
	}

	public void cambiarImagenP1_zombie(String rutaImagen) {
		P1_zombie.setIcon(new ImageIcon(rutaImagen));
	}
	
	public void cambiarImagenP2_zombie(String rutaImagen) {
		P2_zombie.setIcon(new ImageIcon(rutaImagen));
	}
}
