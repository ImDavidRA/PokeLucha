package juegoZombie;

public class ZombieSaltarin extends Zombie {
	// Constructor
	ZombieSaltarin() {
		this.daño=75;
		this.salud=150;
		this.nombre="Saltarin";
		this.velocidad=4;
	}	
	
	// Metodos
	public boolean evasion(int x) {
		int chance = (int)(Math.random()*10);
		
		if (chance==9) {
			this.salud+=x;
			return true;			
		}
		return false;
	}
}