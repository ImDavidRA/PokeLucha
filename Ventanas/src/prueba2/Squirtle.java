package prueba2;

public class Squirtle extends Pokemon {
	
	Squirtle() {
		this.daño=75;
		this.salud=375;
		this.nombre="Squirtle";
		this.velocidad=4;
		this.maxsalud=375;
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