package Calidad.CalidadProtectora;

public class Ayuntamiento implements Constantes{
	private double cantidad_variable;
	private long telContacto;   
	
	public Ayuntamiento (long telContacto,double cantidad_variable) {
		this.cantidad_variable=cantidad_variable;
		this.telContacto = telContacto;
	}
	public double calcularSubvencion(Protectora protect) {
		double subvencion=protect.getContador()*cantidad_variable;
		subvencion=subvencion+CANTIDAD_FIJA;
		return subvencion;
	}
	public double getCantidad_variable() {
		return cantidad_variable;
	}

	public void setCantidad_variable(double cantidad_variable) {
		this.cantidad_variable = cantidad_variable;
	}

	public long getTelefono() {
		return telContacto;
	}

	public void setTelefono(long telefono) {
		this.telContacto = telefono;
	}
	
}
