package juegoZombie;

public class Test {

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
	
	public static void main(String[] args) {
		ZombieHijo z1 = new ZombieHijo();
		ZombieHijo z2 = new ZombieHijo();
		
		System.out.println(z1);
		
		while (z1.getSalud()>0 && z2.getSalud()>0) {
			
			int x = z1.atacar();
			
			if (crit()) {
				x *= 1.5;
				System.out.println("\n¡HA SIDO CRÍTICO!: "+x);
			}
			else {
				System.out.println("\nDaño realizado por Z1: "+x);
			}						
			
			z2.recibirDanio(z1);
			System.out.println("Salud Zombie2: "+z2.getSalud());
			
			int y = z2.atacar();
			
			if (crit()) {
				y *= 1.5;
				System.out.println("\n¡HA SIDO CRÍTICO!: "+y);
			}
			else {
				System.out.println("\nDaño realizado por Z2: "+y);
			}
			
			z1.recibirDanio(z2);
			System.out.println("Salud Zombie1: "+z1.getSalud());		
			
		}		
		
		System.out.println();
		
		if (z1.getSalud()>0)
			System.out.println("Gana el Zombie 1");
		else
			System.out.println("Gana el Zombie 2");
		
	}

}
