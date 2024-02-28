package juegoZombie;

public class ZombieSaltarin extends Zombie {
	// Constructor
	ZombieSaltarin() {
		this.daño=75;
		this.salud=350;
		this.nombre="ZombieSaltarin";
		this.velocidad=4;
	}	
	
	// Metodos
	public boolean evasion(int h) {
		int chance = (int)(Math.random()*4);
		
		if (chance==0) {
			this.salud+=h;
			return true;			
		}
		return false;
	}
}