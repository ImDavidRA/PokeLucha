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

public class Final extends JFrame {
	
	int xMouse, yMouse;
	private JFrame thisFrame;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public Final(String playerGanador, Zombie zGanador) {		
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
		
		JLabel Imagen_Winner = new JLabel();
		Imagen_Winner.setHorizontalAlignment(SwingConstants.CENTER);
		Imagen_Winner.setIcon(new ImageIcon(zGanador.getRuta()));
		Imagen_Winner.setBounds(204, 200, 403, 215);
		background.add(Imagen_Winner);
		
		JLabel Winner_gif = new JLabel("");
		Winner_gif.setHorizontalAlignment(SwingConstants.CENTER);
		Winner_gif.setIcon(new ImageIcon("C:\\Users\\david\\Desktop\\images\\Zombies\\winner.gif"));
		Winner_gif.setBounds(147, 83, 547, 182);
		background.add(Winner_gif);

		JLabel Texto_Player_Winner = new JLabel(playerGanador);
		Texto_Player_Winner.setForeground(Color.WHITE);
		Texto_Player_Winner.setHorizontalAlignment(SwingConstants.CENTER);
		Texto_Player_Winner.setFont(new Font("Retro Gaming", Font.BOLD, 60));
		Texto_Player_Winner.setBounds(137, 34, 530, 85);
		background.add(Texto_Player_Winner);

		JPanel barra = new JPanel();
		barra.setForeground(new Color(255,255,255,0));
		barra.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Final.this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
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
		
		JLabel txt_Entrar = new JLabel("REINICIAR");
		
		JPanel Panel_Reinicio = new JPanel();
		Panel_Reinicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Panel_Reinicio.setBackground(Color.white);
				txt_Entrar.setForeground(Color.black);
				Panel_Reinicio.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_Reinicio.setBackground(new Color(13,125,200,0));				
				txt_Entrar.setForeground(Color.white);
				Panel_Reinicio.setOpaque(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Login inicio = new Login();			
				
				inicio.setVisible(true);
				thisFrame.dispose();				
				
				
			}
		});
		Panel_Reinicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_Reinicio.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Panel_Reinicio.setBackground(new Color(13, 125, 200,0));
		
		Panel_Reinicio.setBounds(337, 409, 130, 30);
		background.add(Panel_Reinicio);

		txt_Entrar.setForeground(new Color(255, 255, 255));
		txt_Entrar.setHorizontalTextPosition(SwingConstants.CENTER);
		Panel_Reinicio.add(txt_Entrar);
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
												img_Bg.setIcon(new ImageIcon("D:\\Descargas\\karina-formanova-rainforest-animation-ezgif.com-resize.gif"));
												img_Bg.setFont(new Font("Montserrat", Font.BOLD, 11));
												img_Bg.setBounds(0, 0, 804, 500);
												background.add(img_Bg);
	}
}
