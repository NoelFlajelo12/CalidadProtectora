package protectora;

public class Clinica_Veterinaria implements Constantes {
	private String nombre;
	private long telefono;
	private double precioEsterilizacion;
	
	public Clinica_Veterinaria(String nombre,long telefono,double precioEsterilizacion) {
		this.nombre=nombre;
		this.telefono=telefono;
		this.precioEsterilizacion=precioEsterilizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public double getPrecioEsterilizacion() {
		return precioEsterilizacion;
	}

	public void setPrecioEsterilizacion(int precio) {
		this.precioEsterilizacion = precio;
	}
	public double getPrecioEsterilizacionVip() {
		return precioEsterilizacion + PRECIO_VIP;
	}
}
