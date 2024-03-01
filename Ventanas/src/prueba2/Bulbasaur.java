package prueba2;

public class Bulbasaur extends Pokemon {
	
	Bulbasaur() {
		this.daño=50;
		this.salud=400;
		this.nombre="Bulbasaur";
		this.velocidad=5;
		this.maxsalud=400;
		this.ruta="C:\\Users\\david\\Desktop\\images\\Zombies\\bulbasaur_i.gif";
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
