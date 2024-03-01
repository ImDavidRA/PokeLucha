package prueba2;

public class Charmander extends Mew {
	
	Charmander() {
		this.daño=75;
		this.salud=350;
		this.nombre="Charmander";
		this.velocidad=7;
		this.maxsalud=350;
		this.ruta="C:\\Users\\david\\Desktop\\images\\Zombies\\charmander_i.gif";
	}
	
	public boolean doubleHit() {
		int x = (int)(Math.random()*20);
		
		if (x==0)
			return true;
		return false;
	}
	
}
