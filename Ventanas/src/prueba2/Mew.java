package prueba2;

public class Mew {
	
	// Atributos //
	public String nombre;
	public int salud;
	public int velocidad;
	public int daño;
	public int maxsalud;
	public String ruta;
		
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
	public void recibirDaño(int x) {
		this.salud -= x;
	}
	
	@Override
	public String toString() {
		return this.nombre+" [salud = " + salud + ", velocidad = " + velocidad + ", daño = " + daño + "]";
	}

	/**
	 * Método que devuelve la ruta de la imagen del zombie
	 * @return - String ruta
	 */
	public String getRuta() {
		return this.ruta;
	}
	
	/**
	 * @return - String nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @return - int salud maxima
	 */
	public int getMaxsalud() {
		return maxsalud;
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