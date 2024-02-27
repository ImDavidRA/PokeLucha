package juegoZombie;

public class ZombieCorredor extends Zombie {
	
	ZombieCorredor() {
		this.daño=170;
		this.salud=180;
		this.nombre="Zombi2";
		this.velocidad=7;
	}
	
	public boolean doubleHit() {
		int x = (int)(Math.random()*20);
		
		if (x==0)
			return true;
		return false;
	}
	
}
