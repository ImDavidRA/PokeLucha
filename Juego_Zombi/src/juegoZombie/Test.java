package juegoZombie;

import java.util.Scanner;

public class Test {

	/**
	 * Procedimiento que simula el ataque del zombi1
	 * @param z1 - Zombie parámetro
	 * @param z2 - Zombie parámetro
	 */
	private static void pelea1(Zombie z1, Zombie z2, String p1, String p2) {

		// Utiliza el método atacar() para generar un valor aleatorio para el ataque y guardarlo en X
		int x = z1.atacar();

		// La función crit() decide si tenemos suerte y sale crítico, imprimimos una cosa u otra en caso de
		if (crit()) {
			x *= 1.5;
			System.out.println("\n¡HA SIDO CRÍTICO!: "+x);
		}
		else {
			System.out.println("\nDaño realizado por "+p1+": "+x);
		}

		// Se actualiza la vida del zombie enemigo
		z2.recibirDanio(x);
		System.out.println("Salud "+p2+": "+z2.getSalud());




		// Notificamos sobre cual de los zombies ha ganado
		if(z2.getSalud()<=0) {
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
	 * Procedimiento que simula el ataque del zombi2
	 * @param z1 - Zombie parámetro
	 * @param z2 - Zombie parámetro
	 */
	private static void pelea2(Zombie z2, Zombie z1, String p1, String p2) {

		// Utiliza el método atacar() para generar un valor aleatorio para el ataque y guardarlo en Y
		int y = z2.atacar();

		// La función crit() decide si tenemos suerte y sale crítico, imprimimos una cosa u otra en caso de
		if (crit()) {
			y *= 1.5;
			System.out.println("\n¡HA SIDO CRÍTICO!: "+y);
		}
		else {
			System.out.println("\nDaño realizado por "+p2+": "+y);
		}

		// Se actualiza la vida del zombie enemigo
		z1.recibirDanio(y);
		System.out.println("Salud "+p1+": "+z1.getSalud());


		// Notificamos sobre cual de los zombies ha ganado
		if (z1.getSalud()<=0) {
			System.out.println();
			System.out.println("                 ______  __      _    _  _____  _   _  _____  _ \r\n"
					+ "                 | ___ \\/  |    | |  | ||_   _|| \\ | |/  ___|| |\r\n"
					+ "                 | |_/ /`| |    | |  | |  | |  |  \\| |\\ `--. | |\r\n"
					+ "                 |  __/  | |    | |/\\| |  | |  | . ` | `--. \\| |\r\n"
					+ "                 | |    _| |_   \\  /\\  / _| |_ | |\\  |/\\__/ /|_|\r\n"
					+ "                 \\_|    \\___/    \\/  \\/  \\___/ \\_| \\_/\\____/ (_)\r\n"
					+ "                                                                ");
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
		ZombieHijo2 z2 = new ZombieHijo2();
		ZombieHijo3 z3 = new ZombieHijo3();

		String p1 = "Player1";
		String p2 = "Player2";

		Scanner input = new Scanner(System.in);

		menu(z1,z2,z3, p1);
		int opcion = input.nextInt();

		Zombie c1 = null;
		int num2=0;
		switch (opcion) {
		case 1:
			num2=1;
			break;
		case 2:
			num2=2;
			break;
		case 3:
			num2=3;
			break;
		default:
			// Hay que poner control de errores
			break;
		}
		if (num2==1) {
			c1= new ZombieHijo();
		}else if(num2==2) {
			c1= new ZombieHijo2();
		}else {
			c1= new ZombieHijo3();
		}


		menu(z1,z2,z3,p2);
		opcion = input.nextInt();

		Zombie c2 = null;
		int num=0;
		switch (opcion) {
		case 1:
			num=1;
			break;
		case 2:
			num=2;
			break;
		case 3:
			num=3;
			break;
		default:
			// Hay que poner control de errores
			break;
		}
		if (num==1) {
			c2= new ZombieHijo();
		}else if(num==2) {
			c2= new ZombieHijo2();
		}else {
			c2= new ZombieHijo3();
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
			// En el caso de que ninguno de los zombis sea el saltarin
			// Se pueden ir añdiendo if para meter metodos a los diferentes zombis de la otra forma no se podia
			if(num!=3 && num2!=3) {
				pelea1(c1,c2,p1,p2);
				if(c2.getSalud()<=0) {
					break;
				}
				pelea2(c2,c1,p1,p2);
				if(c1.getSalud()<=0) {
					break;
				}
			}
			// En el caso de que los dos player hayan elegido el saltarin ahora mismo no he dividido la evasion para dos objetos y los dos evadirian
			if (num==3 && num2==3) {
				System.out.println("Daño del enemigo evadido");
				System.out.println("Daño del enemigo evadido");
				if(z3.evasion()==false) {
					pelea1(c1,c2,p1,p2);
					if(c2.getSalud()<=0) {
						break;
					}
					pelea2(c2,c1,p1,p2);
					if(c1.getSalud()<=0) {
						break;
					}
				}


			}
			// En el caso que el player 1 escoga al saltarin 
			if(num==3) {
				if(z3.evasion()) {
					System.out.println();
					System.out.println("Daño del enemigo evadido");
					pelea1(c1,c2,p1,p2);
					if(c2.getSalud()<=0) {
						break;
					}
				}else {
					pelea1(c1,c2,p1,p2);
					if(c2.getSalud()<=0) {
						break;
					}
					pelea2(c2,c1,p1,p2);
					if(c1.getSalud()<=0) {
						break;
					}
				}
				// En el caso de que el player dos escoga al saltarin
				if(num2==3) {
					if(z3.evasion()) {
						pelea2(c2,c1,p1,p2);
						System.out.println();
						System.out.println("Daño del enemigo evadido");
						if(c1.getSalud()<=0) {
							break;
						}
					}else {
						pelea1(c1,c2,p1,p2);
						if(c2.getSalud()<=0) {
							break;
						}
						pelea2(c2,c1,p1,p2);
						if(c1.getSalud()<=0) {
							break;
						}
					}
					
				}
			}

		}
		System.out.println();

		input.close();
		// Fin del escaner



	}

}
