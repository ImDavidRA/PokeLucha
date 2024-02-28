package juegoZombie;

import java.util.Scanner;

public class Test {

	Thread thread = new Thread(new Thread());
	
	final static int TIEMPO = 200;
	
	/**
	 * Menú a imprimir con las opciones de zombie a escoger
	 */
	private static void menu(Zombie z1, Zombie z2, Zombie z3, String p) {
		System.out.println("\n-------------------------- "+p+" Elige tu Zombie --------------------------");
		System.out.println("1) Zombie Caminante -> \t"+z1.toString());
		System.out.println("2) Zombie Corredor  -> \t"+z2.toString());
		System.out.println("3) Zombie Saltarin  -> \t"+z3.toString());
		System.out.print("\nElige una opción: ");
	}
	
	public static void main(String[] args) {
		// Título
		System.out.println(" ______                   _      _        _                        _     ___ \r\n"
				+ "|___  /                  | |    (_)      | |                      | |   /   |\r\n"
				+ "   / /   ___   _ __ ___  | |__   _   ___ | |      __ _  _ __    __| |  / /| |\r\n"
				+ "  / /   / _ \\ | '_ ` _ \\ | '_ \\ | | / _ \\| |     / _` || '_ \\  / _` | / /_| |\r\n"
				+ " / /___| (_) || | | | | || |_) || ||  __/| |____| (_| || | | || (_| | \\___  |\r\n"
				+ "\\_____/ \\___/ |_| |_| |_||_.__/ |_| \\___|\\_____/ \\__,_||_| |_| \\__,_|     |_/");
		
		// FIN Título
		
		// Creamos 3 instancias de ejemplo de zombies
		ZombieCaminante z1 = new ZombieCaminante();
		ZombieCorredor z2 = new ZombieCorredor();
		ZombieSaltarin z3 = new ZombieSaltarin();
		
		String p1 = "PLAYER1";
		String p2 = "PLAYER2";
		
		Scanner input = new Scanner(System.in);
		
		menu(z1,z2,z3, p1);
		int opcion = input.nextInt();
		
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
		
		menu(z1,z2,z3,p2);
		int opcion2 = input.nextInt();
		
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
		
		System.out.println();
		System.out.println("                     ______  _____  _____  _   _  _____  _ \r\n"
				+ "                     |  ___||_   _||  __ \\| | | ||_   _|| |\r\n"
				+ "                     | |_     | |  | |  \\/| |_| |  | |  | |\r\n"
				+ "                     |  _|    | |  | | __ |  _  |  | |  | |\r\n"
				+ "                     | |     _| |_ | |_\\ \\| | | |  | |  |_|\r\n"
				+ "                     \\_|     \\___/  \\____/\\_| |_/  \\_/  (_)\r\n"
				+ "                                                           ");
		System.out.println();
		
		// Bucle, mientras que la salud de 1 de los 2 zombies sea mayor que 0, seguirá
		while (c1.getSalud()>0 && c2.getSalud()>0) {
			
			// Utiliza el método atacar() para generar un valor aleatorio para el ataque y guardarlo en X
			int x = c1.atacar();
			int x2 = 0; // Variable para almacenar el segundo ataque en caso de doble golpe

			// Llamamiento a los métodos en función del tipo de zombie del P1
			boolean critico = false;
			if (opcion == 1) {
			    critico = ((ZombieCaminante) c1).crit();
			    if (critico) {
			        x *= 1.5;
			        System.out.println("\nCRITICO!!!: " + x);
			    }
			}

			boolean velocidad = false;
			if (opcion == 2) {
			    velocidad = ((ZombieCorredor) c1).doubleHit();
			    if (velocidad) {
			        System.out.println("\nDOBLE GOLPE!!!");
			        System.out.println("Primer hit: " + x);
			        x2 = c1.atacar();
			        System.out.println("Segundo hit: " + x2);

			        x += x2;
			    }
			}

			boolean esquiva = false;
			if (opcion == 3) {
			    esquiva = ((ZombieSaltarin) c2).evasion(x);
			    if (esquiva) {
			        System.out.println("\n"+p1+" falla el ataque...");
			    }
			}

			// Si no hubo esquiva, se muestra el daño realizado
			if (!esquiva && !critico && !velocidad) {
			    System.out.println("\nDaño realizado por "+p1+": " + x);
			}

			// Se actualiza la vida del zombie enemigo
			
			c2.recibirDanio(x);
			System.out.println("Salud "+p2+": "+c2.getSalud());

			
			// Temporizador con TIEMPO segundos de espera
			try {
				Thread.sleep(TIEMPO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Sale del búcle en caso que el c2 baje por debajo de 0 de salud
			if (c2.getSalud()<0)
				break;
			
			// Utiliza el método atacar() para generar un valor aleatorio para el ataque y guardarlo en Y
			int y = c2.atacar();
			int y2 = 0; // Variable para almacenar el segundo ataque en caso de doble golpe

			// Llamamiento a los métodos en función del tipo de zombie del P1
			critico = false;
			if (opcion2 == 1) {
			    critico = ((ZombieCaminante) c2).crit();
			    if (critico) {
			        y *= 1.5;
			        System.out.println("\nCRITICO!!!: " + y);
			    }
			}

			velocidad = false;
			if (opcion2 == 2) {
			    velocidad = ((ZombieCorredor) c2).doubleHit();
			    if (velocidad) {
			        System.out.println("\nDOBLE GOLPE!!!");
			        System.out.println("Primer hit: " + y);
			        y2 = c2.atacar();
			        System.out.println("Segundo hit: " + y2);

			        y += y2;
			    }
			}

			esquiva = false;
			if (opcion2 == 3) {
			    esquiva = ((ZombieSaltarin) c1).evasion(y);
			    if (esquiva) {
			        System.out.println("\n"+p2+" falla el ataque...");
			    }
			}

			// Si no hubo esquiva, se muestra el daño realizado
			if (!esquiva && !critico && !velocidad) {
			    System.out.println("\nDaño realizado por "+p2+": " + y);
			}

			// Se actualiza la vida del zombie enemigo
			
			c1.recibirDanio(y);
			System.out.println("Salud "+p1+": "+c1.getSalud());
			
			// Temporizador con TIEMPO segundos de espera
			try {
				Thread.sleep(TIEMPO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// Notificamos sobre cual de los zombies ha ganado
		if (c1.getSalud()>0) {
			System.out.println();
			System.out.println("                 ______  __      _    _  _____  _   _  _____  _ \r\n"
					+ "                 | ___ \\/  |    | |  | ||_   _|| \\ | |/  ___|| |\r\n"
					+ "                 | |_/ /`| |    | |  | |  | |  |  \\| |\\ `--. | |\r\n"
					+ "                 |  __/  | |    | |/\\| |  | |  | . ` | `--. \\| |\r\n"
					+ "                 | |    _| |_   \\  /\\  / _| |_ | |\\  |/\\__/ /|_|\r\n"
					+ "                 \\_|    \\___/    \\/  \\/  \\___/ \\_| \\_/\\____/ (_)\r\n"
					+ "                                                                ");
		}
		else {
			System.out.println();
			System.out.println("                 ______  _____     _    _  _____  _   _  _____  _ \r\n"
					+ "                 | ___ \\/ __  \\   | |  | ||_   _|| \\ | |/  ___|| |\r\n"
					+ "                 | |_/ /`' / /'   | |  | |  | |  |  \\| |\\ `--. | |\r\n"
					+ "                 |  __/   / /     | |/\\| |  | |  | . ` | `--. \\| |\r\n"
					+ "                 | |    ./ /___   \\  /\\  / _| |_ | |\\  |/\\__/ /|_|\r\n"
					+ "                 \\_|    \\_____/    \\/  \\/  \\___/ \\_| \\_/\\____/ (_)\r\n"
					+ "                                                                  ");
		}
	
		
		System.out.println();
		
		input.close();
		// Fin del escaner		
	}

}
