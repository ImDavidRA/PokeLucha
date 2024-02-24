package prueba2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Login extends JFrame {

	int xMouse, yMouse;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoUser;
	private JPasswordField campoPass;

	public Login() {
		setLocationByPlatform(true);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel background = new JPanel();
		background.setBounds(0, 0, 850, 500);
		background.setBackground(new Color(255, 255, 255));
		contentPane.add(background);
		background.setLayout(null);

		JSeparator SEPARADOR2_1 = new JSeparator();
		SEPARADOR2_1.setBounds(55, 300, 295, 2);
		background.add(SEPARADOR2_1);

		JSeparator SEPARADOR2 = new JSeparator();
		SEPARADOR2.setBounds(55, 234, 295, 2);
		background.add(SEPARADOR2);

		campoPass = new JPasswordField();
		campoPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(campoPass.getPassword()).equals("*****************************")) {
					campoPass.setText("");
					campoPass.setForeground(Color.black);
				}
				if (campoUser.getText().isEmpty()) {
					campoUser.setText("Introduzca su nombre de usuario...");
					campoUser.setForeground(Color.gray);
				}
			}
		});
		campoPass.setHorizontalAlignment(SwingConstants.LEFT);
		campoPass.setText("*****************************");
		campoPass.setForeground(new Color(192, 192, 192));
		campoPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoPass.setToolTipText("");
		campoPass.setBorder(null);
		campoPass.setBounds(55, 283, 295, 14);
		background.add(campoPass);

		JLabel img_Logo_txt_Logo = new JLabel("ZombieLand");
		img_Logo_txt_Logo.setForeground(Color.RED);
		img_Logo_txt_Logo.setHorizontalAlignment(SwingConstants.CENTER);
		img_Logo_txt_Logo.setFont(new Font("Retro Gaming", Font.BOLD, 38));
		img_Logo_txt_Logo.setBounds(181, 45, 445, 61);
		background.add(img_Logo_txt_Logo);

		JLabel txt_Usuario = new JLabel("USUARIO");
		txt_Usuario.setHorizontalAlignment(SwingConstants.LEFT);
		txt_Usuario.setFont(new Font("Montserrat", Font.BOLD, 19));
		txt_Usuario.setBounds(55, 185, 196, 22);
		background.add(txt_Usuario);

		campoUser = new JTextField();
		campoUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (campoUser.getText().equals("Introduzca su nombre de usuario...")) {
					campoUser.setText("");
					campoUser.setForeground(Color.black);
				}
				if (String.valueOf(campoPass.getPassword()).isEmpty()) {
					campoPass.setText("*****************************");
					campoPass.setForeground(Color.gray);
				}

			}
		});
		campoUser.setHorizontalAlignment(SwingConstants.LEFT);
		campoUser.setBorder(null);
		campoUser.setForeground(new Color(192, 192, 192));
		campoUser.setBackground(new Color(255, 255, 255));
		campoUser.setFont(new Font("Montserrat", Font.BOLD, 16));
		campoUser.setText("Introduzca su nombre de usuario...");
		campoUser.setBounds(55, 209, 351, 22);
		background.add(campoUser);
		campoUser.setColumns(10);

		JLabel txt_Pass = new JLabel("CONTRASEÑA");
		txt_Pass.setHorizontalAlignment(SwingConstants.LEFT);
		txt_Pass.setFont(new Font("Montserrat", Font.BOLD, 19));
		txt_Pass.setBounds(55, 256, 196, 22);
		background.add(txt_Pass);

		JPanel Panel_Entrar = new JPanel();
		Panel_Entrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Panel_Entrar.setBackground(new Color(71,174,243));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_Entrar.setBackground(new Color(13,125,200));
			}
		});
		Panel_Entrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_Entrar.setBorder(null);
		Panel_Entrar.setBackground(new Color(13, 125, 200));
		Panel_Entrar.setBounds(255, 381, 104, 29);
		background.add(Panel_Entrar);

		JLabel txt_Entrar = new JLabel("ENTRAR");
		txt_Entrar.setForeground(new Color(255, 255, 255));
		txt_Entrar.setHorizontalTextPosition(SwingConstants.CENTER);
		Panel_Entrar.add(txt_Entrar);
		txt_Entrar.setFont(new Font("Montserrat", Font.BOLD, 15));
		txt_Entrar.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel Panel_Salir = new JPanel();
		Panel_Salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Panel_Salir.setBackground(new Color(71,174,243));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_Salir.setBackground(new Color(13,125,200));
			}
		});
		Panel_Salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_Salir.setBorder(null);
		Panel_Salir.setBackground(new Color(13, 125, 200));
		Panel_Salir.setBounds(500, 381, 104, 29);
		background.add(Panel_Salir);

		JLabel txt_Salir = new JLabel("SALIR");
		txt_Salir.setForeground(new Color(255, 255, 255));
		txt_Salir.setHorizontalTextPosition(SwingConstants.CENTER);
		txt_Salir.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Salir.setFont(new Font("Montserrat", Font.BOLD, 15));
		Panel_Salir.add(txt_Salir);

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
		btn_X.setFont(new Font("Montserrat", Font.BOLD, 25));
		btn_X.setHorizontalAlignment(SwingConstants.CENTER);
		btn_X.setBounds(0, 0, 46, 35);
		background.add(btn_X);
		
				JLabel img_Bg = new JLabel("");
				img_Bg.setHorizontalTextPosition(SwingConstants.CENTER);
				img_Bg.setHorizontalAlignment(SwingConstants.CENTER);
				img_Bg.setIcon(new ImageIcon("C:\\Users\\david\\Desktop\\images\\FondoInicio.gif"));
				img_Bg.setFont(new Font("Montserrat", Font.BOLD, 11));
				img_Bg.setBounds(0, 0, 804, 500);
				background.add(img_Bg);
	}
}
