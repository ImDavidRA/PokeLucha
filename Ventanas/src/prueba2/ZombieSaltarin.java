package prueba2;

public class ZombieSaltarin extends Zombie {
	
	ZombieSaltarin() {
		this.daño=75;
		this.salud=350;
		this.nombre="ZombieSaltarin";
		this.velocidad=4;
		this.maxsalud=350;
		this.ruta="C:\\Users\\david\\Desktop\\images\\Zombies\\squirtle_i.gif";
	}	
	
	// Metodos
	public boolean evasion(int h) {
		int chance = (int)(Math.random()*10);
		
		if (chance==0) {
			this.salud+=h;
			return true;			
		}
		return false;
	}
}