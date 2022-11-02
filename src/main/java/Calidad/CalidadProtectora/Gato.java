package Calidad.CalidadProtectora;

public class Gato extends Animal {     

	protected boolean esterilizado;
	
	public Gato (String nombre,TSexo sexo, int edad, boolean sociable, boolean apadrinado, boolean esterilizado ) {
	
		super(nombre,sexo,edad,sociable,apadrinado);
		this.esterilizado = esterilizado;
	}
	
	public boolean isEsterilizado() {
		return esterilizado;
	}

	public void setEsterilizado(boolean esterilizado) {
		this.esterilizado = esterilizado;
	}
	public double costesVeterinarios() {
		double costes = 0;
		if(!esterilizado && sexo == TSexo.HEMBRA) {
			costes+=(NO_ESTERILIZADA*12);
		}
		return costes;
	}
	
	public String toString() {
		return "[GATO: "+super.toString()+ " Esterilizado: " +esterilizado+"] ";
	}
	
}
