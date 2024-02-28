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

public class Login extends JFrame {
	
	int xMouse, yMouse;
	private JFrame thisFrame;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private ButtonGroup buttonG = new ButtonGroup();
	private ButtonGroup buttonG2 = new ButtonGroup();
	
	public Login() {		
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

		JLabel img_Logo_txt_Logo = new JLabel("ZombieLand");
		img_Logo_txt_Logo.setForeground(Color.WHITE);
		img_Logo_txt_Logo.setHorizontalAlignment(SwingConstants.CENTER);
		img_Logo_txt_Logo.setFont(new Font("Retro Gaming", Font.BOLD, 60));
		img_Logo_txt_Logo.setBounds(137, 34, 530, 85);
		background.add(img_Logo_txt_Logo);

		JLabel txt_P1 = new JLabel("PLAYER1");
		txt_P1.setBackground(Color.WHITE);
		txt_P1.setForeground(Color.WHITE);
		txt_P1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_P1.setFont(new Font("Retro Gaming", Font.BOLD, 30));
		txt_P1.setBounds(120, 260, 180, 25);
		background.add(txt_P1);

		JLabel txt_P2 = new JLabel("PLAYER2");
		txt_P2.setForeground(Color.WHITE);
		txt_P2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_P2.setFont(new Font("Retro Gaming", Font.BOLD, 30));
		txt_P2.setBounds(526, 260, 180, 25);
		background.add(txt_P2);

		JPanel barra = new JPanel();
		barra.setForeground(new Color(255,255,255,0));
		barra.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Login.this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
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
								
								JRadioButton P1_radio1 = new JRadioButton("Zombie Caminante");
								P1_radio1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								P1_radio1.setOpaque(false);
								P1_radio1.setBorder(null);
								P1_radio1.setForeground(Color.WHITE);
								P1_radio1.setSelected(true);
								P1_radio1.setToolTipText("STATS (100 DAÑO, 300 SALUD, 5 VELOCIDAD)");
								P1_radio1.setFont(new Font("Retro Gaming", Font.BOLD, 15));
								P1_radio1.setBounds(104, 310, 224, 25);
								background.add(P1_radio1);
										
										JRadioButton P1_radio2 = new JRadioButton("Zombie Corredor");
										P1_radio2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
										P1_radio2.setOpaque(false);
										P1_radio2.setForeground(Color.WHITE);
										P1_radio2.setBorder(null);
										P1_radio2.setToolTipText("STATS (75 DAÑO, 325 SALUD, 7 VELOCIDAD)");
										P1_radio2.setFont(new Font("Retro Gaming", Font.BOLD, 15));
										P1_radio2.setBounds(104, 335, 224, 25);
										background.add(P1_radio2);
										
											JRadioButton P1_radio3 = new JRadioButton("Zombie Saltarín");
											P1_radio3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
											P1_radio3.setOpaque(false);
											P1_radio3.setForeground(Color.WHITE);
											P1_radio3.setBorder(null);
											P1_radio3.setToolTipText("STATS (150 DAÑO, 250 SALUD, 6 VELOCIDAD)");
											P1_radio3.setFont(new Font("Retro Gaming", Font.BOLD, 15));
											P1_radio3.setBounds(104, 360, 224, 25);
											background.add(P1_radio3);			
												
		buttonG.add(P1_radio1);
		buttonG.add(P1_radio2);
		buttonG.add(P1_radio3);		
								
								JRadioButton P2_radio1 = new JRadioButton("Zombie Caminante");
								P2_radio1.setToolTipText("STATS (100 DAÑO, 300 SALUD, 5 VELOCIDAD)");
								P2_radio1.setSelected(true);
								P2_radio1.setOpaque(false);
								P2_radio1.setForeground(Color.WHITE);
								P2_radio1.setFont(new Font("Retro Gaming", Font.BOLD, 15));
								P2_radio1.setBorder(null);
								P2_radio1.setBounds(505, 310, 224, 25);
								background.add(P2_radio1);
								
								JRadioButton P2_radio2 = new JRadioButton("Zombie Corredor");
								P2_radio2.setToolTipText("STATS (75 DAÑO, 325 SALUD, 7 VELOCIDAD)");
								P2_radio2.setOpaque(false);
								P2_radio2.setForeground(Color.WHITE);
								P2_radio2.setFont(new Font("Retro Gaming", Font.BOLD, 15));
								P2_radio2.setBorder(null);
								P2_radio2.setBounds(505, 335, 224, 25);
								background.add(P2_radio2);
								
								JRadioButton P2_radio3 = new JRadioButton("Zombie Saltarín");
								P2_radio3.setToolTipText("STATS (150 DAÑO, 250 SALUD, 6 VELOCIDAD)");
								P2_radio3.setOpaque(false);
								P2_radio3.setForeground(Color.WHITE);
								P2_radio3.setFont(new Font("Retro Gaming", Font.BOLD, 15));
								P2_radio3.setBorder(null);
								P2_radio3.setBounds(505, 360, 224, 25);
								background.add(P2_radio3);
								
		buttonG2.add(P2_radio1);
		buttonG2.add(P2_radio2);
		buttonG2.add(P2_radio3);
		
		String Ruta_ZombieCaminante_i = "C:\\Users\\david\\Desktop\\images\\Zombies\\bulbasaur_i.gif";
		String Ruta_ZombieCorredor_i = "C:\\Users\\david\\Desktop\\images\\Zombies\\charmander_i.gif";
		String Ruta_ZombieSaltarin_i = "C:\\Users\\david\\Desktop\\images\\Zombies\\squirtle_i.gif";
		
		String Ruta_ZombieCaminante_d = "C:\\Users\\david\\Desktop\\images\\Zombies\\bulbasaur_d.gif";
		String Ruta_ZombieCorredor_d = "C:\\Users\\david\\Desktop\\images\\Zombies\\charmander_d.gif";
		String Ruta_ZombieSaltarin_d = "C:\\Users\\david\\Desktop\\images\\Zombies\\squirtle_d.gif";
		
		
		JLabel txt_Entrar = new JLabel("COMENZAR");
		
		JPanel Panel_Entrar = new JPanel();
		Panel_Entrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Panel_Entrar.setBackground(Color.white);
				txt_Entrar.setForeground(Color.black);
				Panel_Entrar.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_Entrar.setBackground(new Color(13,125,200,0));				
				txt_Entrar.setForeground(Color.white);
				Panel_Entrar.setOpaque(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PantallaJuego post;				
				
				int opcion = 0;
				
				// Condicional imagen zombie P1
				if (P1_radio1.isSelected()) {
					opcion = 1;
				} 
				else if (P1_radio2.isSelected()) {
					opcion = 2;
				}
				else if (P1_radio3.isSelected()) {
					opcion = 3;
				}
				
				int opcion2 = 0;
				
				// Condicional imagen zombie P2
				if (P2_radio1.isSelected()) {
					opcion2 = 1;
				} 
				else if (P2_radio2.isSelected()) {
					opcion2 = 2;
				}
				else if (P2_radio3.isSelected()) {
					opcion2 = 3;
				}				
				
				Zombie c1 = null;
				
				switch (opcion) {
				case 1:
					c1 = new ZombieCaminante();
					break;
				case 2:
					c1 = new ZombieCorredor();
					break;
				case 3:
					c1 = new ZombieSaltarin();
					break;
				default:
					// Hay que poner control de errores
					break;
				}				
				
				Zombie c2 = null;
				
				switch (opcion2) {
				case 1:
					c2 = new ZombieCaminante();
					break;
				case 2:
					c2 = new ZombieCorredor();
					break;
				case 3:
					c2 = new ZombieSaltarin();
					break;
				default:
					// Hay que poner control de errores
					break;
				}
				
				post = new PantallaJuego(c1,c2, opcion, opcion2);
				
				if (P1_radio1.isSelected()) {
					post.cambiarImagenP1_zombie(Ruta_ZombieCaminante_d);
				} 
				else if (P1_radio2.isSelected()) {
					post.cambiarImagenP1_zombie(Ruta_ZombieCorredor_d);
				}
				else if (P1_radio3.isSelected()) {
					post.cambiarImagenP1_zombie(Ruta_ZombieSaltarin_d);
				}
				
				// Condicional imagen zombie P2
				if (P2_radio1.isSelected()) {
					post.cambiarImagenP2_zombie(Ruta_ZombieCaminante_i);
				} 
				else if (P2_radio2.isSelected()) {
					post.cambiarImagenP2_zombie(Ruta_ZombieCorredor_i);
				}
				else if (P2_radio3.isSelected()) {
					post.cambiarImagenP2_zombie(Ruta_ZombieSaltarin_i);
				}		
				
				post.setVisible(true);
				thisFrame.dispose();				
				
				
			}
		});
		Panel_Entrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_Entrar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Panel_Entrar.setBackground(new Color(13, 125, 200,0));
		
		Panel_Entrar.setBounds(337, 409, 130, 30);
		background.add(Panel_Entrar);

		txt_Entrar.setForeground(new Color(255, 255, 255));
		txt_Entrar.setHorizontalTextPosition(SwingConstants.CENTER);
		Panel_Entrar.add(txt_Entrar);
		txt_Entrar.setFont(new Font("Retro Gaming", Font.BOLD, 15));
		txt_Entrar.setHorizontalAlignment(SwingConstants.CENTER);
		
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
												img_Bg.setIcon(new ImageIcon("C:\\Users\\david\\Desktop\\images\\fondoInicio.gif"));
												img_Bg.setFont(new Font("Montserrat", Font.BOLD, 11));
												img_Bg.setBounds(0, 0, 804, 500);
												background.add(img_Bg);
	}
}
