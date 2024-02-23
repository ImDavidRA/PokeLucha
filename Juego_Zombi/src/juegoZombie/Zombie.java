package juegoZombie;

public class Zombie {
	
	// Atributos //
	public String nombre;
	public int salud;
	public int velocidad;
	public int daño;
		
	// Métodos //
	
	/**
	 * Método que calcula el ataque en base al daño de cada zombie
	 * @return - int Daño a infligir, puede ser critico
	 */
	public int atacar() {		
		return (int)(Math.random()*this.daño);
	}

	/**
	 * Método que reduce la salud del Zombie actuál en base al método atacar() de otro zombie
	 * @param z - Zombie parámetro
	 */
	public void recibirDanio(int x) {
		this.salud -= x;

	}
	
	@Override
	public String toString() {
		return this.nombre+" [salud = " + salud + ", velocidad = " + velocidad + ", daño = " + daño + "]";
	}

	/**
	 * @return - String nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return - int salud actual
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * @return - int velocidad del zombie
	 */
	public int getVelocidad() {
		return velocidad;
	}


	/**
	 * @return - int danio
	 */
	public int getDano() {
		return daño;
	}
	
	

}
