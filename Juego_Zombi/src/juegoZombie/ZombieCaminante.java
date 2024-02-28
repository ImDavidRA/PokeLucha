package juegoZombie;

public class ZombieCaminante extends Zombie {
	
	ZombieCaminante() {
		this.daño=50;
		this.salud=400;
		this.nombre="ZombiCaminante";
		this.velocidad=5;
	}
	
	/**
	 * Si es TRUE, daño * 1.5
	 * @return - true si sale 0, false si sale cualquier otro
	 */
	public boolean crit() {
		int x = (int)(Math.random()*9);
		
		if (x == 0)
			return true;
		return false;
	}
}
