package juegoZombie;

import java.util.Scanner;

public class Test {

	Thread thread = new Thread(new Thread());
	
	final static int TIEMPO = 1300;
	
	/**
	 * Procedimiento que simula la pelea entre ambos Zombie
	 * @param z1 - Zombie parámetro
	 * @param z2 - Zombie parámetro
	 */
	private static void pelea(Zombie z1, Zombie z2, String p1, String p2) {
		// Bucle, mientras que la salud de 1 de los 2 zombies sea mayor que 0, seguirá
		while (z1.getSalud()>0 && z2.getSalud()>0) {
			
			// Utiliza el método atacar() para generar un valor aleatorio para el ataque y guardarlo en X
			int x = z1.atacar();
			
			// La función crit() decide si tenemos suerte y sale crítico, imprimimos una cosa u otra en caso de
			if (crit()) {
				x *= 1.5;
				System.out.println("\n¡CRÍTICO DEL PLAYER 1!: "+x);
			}
			else {
				System.out.println("\nDaño realizado por "+p1+": "+x);
			}
						
			// Se actualiza la vida del zombie enemigo
			z2.recibirDanio(x);
			System.out.println("Salud "+p2+": "+z2.getSalud());
			
			// Temporizador con TIEMPO segundos de espera
			try {
				Thread.sleep(TIEMPO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Sale del búcle en caso que el z2 baje por debajo de 0 de salud
			if (z2.getSalud()<0)
				break;
			
			// Utiliza el método atacar() para generar un valor aleatorio para el ataque y guardarlo en Y
			int y = z2.atacar();
			
			// La función crit() decide si tenemos suerte y sale crítico, imprimimos una cosa u otra en caso de
			if (crit()) {
				y *= 1.5;
				System.out.println("\n¡CRÍTICO DEL PLAYER 2!: "+y);
			}
			else {
				System.out.println("\nDaño realizado por "+p2+": "+y);
			}
			
			// Se actualiza la vida del zombie enemigo
			z1.recibirDanio(y);
			System.out.println("Salud "+p1+": "+z1.getSalud());
			
			// Temporizador con TIEMPO segundos de espera
			try {
				Thread.sleep(TIEMPO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// Notificamos sobre cual de los zombies ha ganado
		if (z1.getSalud()>0) {
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
	}
	
	/**
	 * If true then daño * 1.5
	 * @return - true si sale 0, false si sale cualquier otro
	 */
	private static boolean crit() {
		int x = (int)(Math.random()*9);
		
		if (x == 0)
			return true;
		return false;
	}
	
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
		ZombieHijo z1 = new ZombieHijo();
		ZombieCorredor z2 = new ZombieCorredor();
		ZombieHijo3 z3 = new ZombieHijo3();
		
		String p1 = "Player1";
		String p2 = "Player2";
		
		Scanner input = new Scanner(System.in);
		
		menu(z1,z2,z3, p1);
		int opcion = input.nextInt();
		
		Zombie c1 = null;
		
		switch (opcion) {
		case 1:
			c1 = new ZombieHijo();
			break;
		case 2:
			c1 = new ZombieCorredor();
			break;
		case 3:
			c1 = new ZombieHijo3();
			break;
		default:
			// Hay que poner control de errores
			break;
		}
		
		menu(z1,z2,z3,p2);
		opcion = input.nextInt();
		
		Zombie c2 = null;
		
		switch (opcion) {
		case 1:
			c2 = new ZombieHijo();
			break;
		case 2:
			c2 = new ZombieCorredor();
			break;
		case 3:
			c2 = new ZombieHijo3();
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
		
		pelea(c1,c2,p1,p2);
		
		System.out.println();
		
		input.close();
		// Fin del escaner		
	}

}
