package juegoZombie;

public class ZombieHijo3 extends Zombie {
	// Constructor
	ZombieHijo3() {
		this.daño=75;
		this.salud=150;
		this.nombre="Saltarin";
		this.velocidad=4;
	}
	
	// Metodos
	public boolean evasion() {
		if ((int)(Math.random()*5+1)==1) {
			return true;	
		}
		return false;
	}
	
}
