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
	public void evasion(int x) {
		if ((int)(Math.random()*10+1)==1) {
			salud=salud+x;
			
		}
	}
	
}
