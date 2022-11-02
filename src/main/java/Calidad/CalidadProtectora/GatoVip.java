package Calidad.CalidadProtectora;

public class GatoVip extends Gato implements Constantes {

	private int carnetVip;
	
	public GatoVip (String nombre,TSexo sexo, int edad, boolean sociable, boolean apadrinado, boolean esterilizado, int carnetVip ) {
		super(nombre,sexo,edad,sociable,apadrinado,esterilizado);
		this.carnetVip = carnetVip;
	}

	public int getCarnetVip() {
		return carnetVip;
	}

	public void setCarnetVip(int carnetVip) {
		this.carnetVip = carnetVip;
	}
	public double costesVeterinarios() {
		double costes = 0;
		if(!esterilizado && sexo == TSexo.HEMBRA) {
			costes+=((NO_ESTERILIZADA*2)*12);
		}
		return costes;
	}
	public String toString() {
		return "[GATO_VIP: "+"Carnet VIP: " +carnetVip + " "+super.toString()+"]";
	}
	
}
