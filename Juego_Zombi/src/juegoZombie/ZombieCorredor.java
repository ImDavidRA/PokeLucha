package juegoZombie;

public class ZombieCorredor extends Zombie {
	
	ZombieCorredor() {
		this.daño=75;
		this.salud=350;
		this.nombre="ZombiCorredor";
		this.velocidad=7;
	}
	
	public boolean doubleHit() {
		int x = (int)(Math.random()*20);
		
		if (x==0)
			return true;
		return false;
	}
	
}
