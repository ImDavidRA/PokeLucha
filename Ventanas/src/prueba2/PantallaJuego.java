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

	final static int TIEMPO = 800;
	
	final static int T_DAÑOS = 700;

	int xMouse, yMouse;
	private JFrame thisFrame;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JLabel P1_zombie = new JLabel("");
	private JLabel P2_zombie = new JLabel("");

	JProgressBar P1_hp = new JProgressBar();
	JProgressBar P2_hp = new JProgressBar();
	
	JLabel P1_hpText = new JLabel();
	JLabel P2_hpText = new JLabel();
	
	JLabel Daño_a_P1 = new JLabel("");
	JLabel Daño_a_P2 = new JLabel("");

	Thread thread = new Thread(new Thread());
	Thread daños = new Thread(new Thread());

	Inicio inicio = new Inicio();
	private final JLabel Daño_a_P2_doble1 = new JLabel("");
	private final JLabel Daño_a_P2_doble2 = new JLabel("");
	private final JLabel Daño_a_P1_doble1 = new JLabel("");
	private final JLabel Daño_a_P1_doble2 = new JLabel("");

	public PantallaJuego(Zombie Zombie_de_P1, Zombie Zombie_de_P2, int tipoz1, int tipoz2) {		
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
		Daño_a_P1_doble2.setHorizontalAlignment(SwingConstants.CENTER);
		Daño_a_P1_doble2.setForeground(Color.WHITE);
		Daño_a_P1_doble2.setFont(new Font("Retro Gaming", Font.BOLD, 20));
		Daño_a_P1_doble2.setBounds(345, 320, 95, 15);
		
		background.add(Daño_a_P1_doble2);
		Daño_a_P1_doble1.setHorizontalAlignment(SwingConstants.CENTER);
		Daño_a_P1_doble1.setForeground(Color.WHITE);
		Daño_a_P1_doble1.setFont(new Font("Retro Gaming", Font.BOLD, 20));
		Daño_a_P1_doble1.setBounds(250, 320, 95, 15);
		
		background.add(Daño_a_P1_doble1);
		Daño_a_P2_doble2.setHorizontalAlignment(SwingConstants.CENTER);
		Daño_a_P2_doble2.setForeground(Color.WHITE);
		Daño_a_P2_doble2.setFont(new Font("Retro Gaming", Font.BOLD, 20));
		Daño_a_P2_doble2.setBounds(470, 280, 95, 15);
		
		background.add(Daño_a_P2_doble2);
		Daño_a_P2_doble1.setHorizontalAlignment(SwingConstants.CENTER);
		Daño_a_P2_doble1.setForeground(Color.WHITE);
		Daño_a_P2_doble1.setFont(new Font("Retro Gaming", Font.BOLD, 20));
		Daño_a_P2_doble1.setBounds(375, 280, 95, 15);
		
		background.add(Daño_a_P2_doble1);
		Daño_a_P2.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		Daño_a_P2.setForeground(Color.WHITE);
		Daño_a_P2.setFont(new Font("Retro Gaming", Font.BOLD, 20));
		Daño_a_P2.setBounds(375, 250, 190, 15);
		background.add(Daño_a_P2);
		Daño_a_P1.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		Daño_a_P1.setForeground(Color.WHITE);
		Daño_a_P1.setFont(new Font("Retro Gaming", Font.BOLD, 20));
		Daño_a_P1.setBounds(250, 350, 190, 15);
		background.add(Daño_a_P1);

		JLabel img_Logo_txt_Logo = new JLabel("COMBATE");
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
		txt_P1.setBounds(520, 405, 180, 25);
		background.add(txt_P1);

		JLabel txt_P2 = new JLabel("PLAYER2");
		txt_P2.setForeground(Color.WHITE);
		txt_P2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_P2.setFont(new Font("Retro Gaming", Font.BOLD, 30));
		txt_P2.setBounds(230, 165, 180, 25);
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
		P1_zombie.setBounds(109, 277, 180, 169);
		background.add(P1_zombie);

		P2_zombie.setHorizontalAlignment(SwingConstants.CENTER);
		P2_zombie.setBounds(503, 130, 221, 169);
		background.add(P2_zombie);

		P2_hp.setValue(100);
		P2_hp.setBorderPainted(false);
		P2_hp.setForeground(Color.GREEN);
		P2_hp.setBackground(new Color(161, 2, 2));
		P2_hp.setFont(new Font("Retro Gaming", Font.BOLD, 11));
		P2_hp.setBounds(247, 200, 145, 15);
		background.add(P2_hp);
		
		P1_hp.setValue(100);
		P1_hp.setForeground(Color.GREEN);
		P1_hp.setFont(new Font("Retro Gaming", Font.BOLD, 11));
		P1_hp.setBorderPainted(false);
		P1_hp.setBackground(new Color(161, 2, 2));
		P1_hp.setBounds(537, 380, 145, 15);
		background.add(P1_hp);

		P2_hpText.setText(Zombie_de_P2.getMaxsalud()+" / "+Zombie_de_P2.getMaxsalud());
		P2_hpText.setHorizontalAlignment(SwingConstants.CENTER);
		P2_hpText.setFont(new Font("Retro Gaming", Font.BOLD, 15));
		P2_hpText.setForeground(Color.WHITE);
		P2_hpText.setBounds(140, 197, 105, 25);
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
		
		P1_hpText.setText(Zombie_de_P1.getMaxsalud()+" / "+Zombie_de_P1.getMaxsalud());
		P1_hpText.setHorizontalAlignment(SwingConstants.CENTER);
		P1_hpText.setForeground(Color.WHITE);
		P1_hpText.setFont(new Font("Retro Gaming", Font.BOLD, 15));
		P1_hpText.setBounds(432, 375, 105, 25);
		background.add(P1_hpText);
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
		
		iniciarCombate(Zombie_de_P1, Zombie_de_P2, tipoz1, tipoz2);
	}
	
    public void iniciarCombate(Zombie c1, Zombie c2, int opcion, int opcion2) {
        // Crear un hilo para el combate
        Thread combateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Llamar al método pelea dentro del hilo
                pelea(c1, c2, opcion, opcion2);
            }
        });
        // Iniciar el hilo
        combateThread.start();
    }

	// Método de pelea
	public void pelea(Zombie c1, Zombie c2, int opcion, int opcion2) {
		while (c1.getSalud()>0 && c2.getSalud()>0) {
			
			int conta = 0;
			
			if (conta==0) {
				try {
					Thread.sleep(TIEMPO);				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conta++;
			}

			// Utiliza el método atacar() para generar un valor aleatorio para el ataque y guardarlo en X
			int x = c1.atacar();
			int x2 = 0; 				// Variable para almacenar el segundo ataque en caso de doble golpe

			// Llamamiento a los métodos en función del tipo de zombie del P1
			boolean critico = false;
			if (opcion == 1) {
				critico = ((ZombieCaminante) c1).crit();
				if (critico) {
					x *= 1.5;
					Daño_a_P2.setText("CRITICO -"+x);
				}
			}

			boolean velocidad = false;
			if (opcion == 2) {
				velocidad = ((ZombieCorredor) c1).doubleHit();
				if (velocidad) {
					Daño_a_P2.setText("DOUBLE HIT");
					Daño_a_P2_doble1.setText("-"+x);
					x2 = c1.atacar();
					Daño_a_P2_doble2.setText("-"+x2);

					x += x2;
				}
			}

			boolean esquiva = false;
			if (opcion == 3) {
				esquiva = ((ZombieSaltarin) c2).evasion(x);
				if (esquiva) {
					Daño_a_P2.setText("FALLO");
				}
			}
			
			// Si no hubo esquiva, se muestra el daño realizado
			if (!esquiva && !critico && !velocidad) {
				Daño_a_P2.setText("-"+x);
			}
			
			// Se actualiza la vida del zombie enemigo
			c2.recibirDanio(x);			
			
			// Modificamos la vida del zombie texto (Si baja de 0, pondremos solo 0)
			if (c2.getSalud()>0) {
				P2_hpText.setText(c2.getSalud()+" / "+c2.getMaxsalud());
			} else
				P2_hpText.setText(0+" / "+c2.getMaxsalud());
			
			// Modificamos el % de la barra de vida según la que le quede
			P2_hp.setValue((int)(((double)c2.getSalud() / c2.getMaxsalud()) * 100));
			
			// Temporizador para mostrar el texto de los daños
			try {
				Thread.sleep(T_DAÑOS);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Acaba el temporizador y quitamos el texto de los daños
			Daño_a_P2.setText("");
			Daño_a_P2_doble1.setText("");
			Daño_a_P2_doble2.setText("");
			
			// Temporizador con TIEMPO segundos de espera
			// Pausa para simular turno del p1
			try {
				Thread.sleep(TIEMPO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Terminamos pausa

			// Sale del búcle en caso que el c2 baje por debajo de 0 de salud, acabando la pelea
			if (c2.getSalud()<0)
				break;

			// Utiliza el método atacar() para generar un valor aleatorio para el ataque y guardarlo en Y
			int y = c2.atacar();
			int y2 = 0; 				// Variable para almacenar el segundo ataque en caso de doble golpe

			// Llamamiento a los métodos en función del tipo de zombie del P1
			critico = false;
			if (opcion2 == 1) {
				critico = ((ZombieCaminante) c2).crit();
				if (critico) {
					y *= 1.5;
					Daño_a_P1.setText("CRITICO -"+y);
				}
			}

			velocidad = false;
			if (opcion2 == 2) {
				velocidad = ((ZombieCorredor) c2).doubleHit();
				if (velocidad) {
					Daño_a_P1.setText("DOUBLE HIT");
					Daño_a_P1_doble1.setText("-"+y);
					y2 = c1.atacar();
					Daño_a_P1_doble2.setText("-"+y2);

					y += y2;
				}
			}
			
			esquiva = false;
			if (opcion2 == 3) {
				esquiva = ((ZombieSaltarin) c1).evasion(y);
				if (esquiva) {
					Daño_a_P1.setText("FALLO");
				}
			}
			
			// Si no hubo esquiva, se muestra el daño realizado
			if (!esquiva && !critico && !velocidad) {
				Daño_a_P1.setText("-"+y);
			}
			
			// Se actualiza la vida del zombie enemigo
			c1.recibirDanio(y);	

			if (c1.getSalud()>0)
				P1_hpText.setText(c1.getSalud()+" / "+c1.getMaxsalud());
			else
				P1_hpText.setText(0+" / "+c1.getMaxsalud());
			
			P1_hp.setValue((int)(((double)c1.getSalud() / c1.getMaxsalud()) * 100));
			
			// Temporizador para mostrar el texto de los daños
			try {
				Thread.sleep(T_DAÑOS);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			// Acaba el temporizador y quitamos el texto de los daños
			Daño_a_P1.setText("");
			Daño_a_P1_doble1.setText("");
			Daño_a_P1_doble2.setText("");
			
			try {
				Thread.sleep(TIEMPO);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Final Pfinal;
		
		if (c1.getSalud()>c2.getSalud()) 
			Pfinal = new Final("Player1", c1);
		else
			Pfinal = new Final("Player2", c2);		
		
		Pfinal.setVisible(true);	
		thisFrame.dispose();
		
	}

	public void cambiarImagenP1_zombie(String rutaImagen) {
		P1_zombie.setIcon(new ImageIcon(rutaImagen));
	}

	public void cambiarImagenP2_zombie(String rutaImagen) {
		P2_zombie.setIcon(new ImageIcon(rutaImagen));
	}
}
