package Calidad.CalidadProtectora;

public class Protectora implements Constantes{
	private String nombreProtectora;
	private Animal [] animal=new Animal [MAX_ANIMALES];
	private double presupuesto;
	private int numAnimales=0;
	
	
	public Protectora(String nombreProtectora,double presupuesto) {
		this.nombreProtectora=nombreProtectora;
		this.presupuesto=presupuesto;
		numAnimales = 0;
	}

	public void anadirAnimal(Animal animal) {
		try {
		this.animal[numAnimales]=animal;
		numAnimales++;
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Superada la capicidad de la protectora");
		}
	}
	
	public Animal getAnimal(String nombreAnimal) {
		Animal animal2 = null;
		boolean enc = false;
		
		for(int i=0;(i<numAnimales) && !enc ;i++) {
			String nAnimal = animal[i].getNombre();
			if(nAnimal.equalsIgnoreCase(nombreAnimal)) {
				animal2 = animal[i];
				enc = true;
			}
		}
		return animal2;
	}
	
	public Animal[] getAnimales() {
		return animal;
	}
	
	public int getNumeroGatasNoEsterilizadas() {
		int contGatas = 0;
		for(int i=0;i<numAnimales;i++) {
			if((animal[i]) instanceof Gato && !((animal[i]) instanceof GatoVip)) {
				if (animal[i].getSexo() == TSexo.HEMBRA && !((Gato)animal[i]).isEsterilizado()) {
					contGatas++;
				}
			}
			
		}
		return contGatas;
	}
	public int getNumeroGatasVipNoEsterilizadas() {
		int contGatasVip = 0;
		for(int i=0;i<numAnimales;i++) {
			if((animal[i]) instanceof GatoVip) {
				if (animal[i].getSexo() == TSexo.HEMBRA && !((Gato)animal[i]).isEsterilizado()) { 
					contGatasVip++;
				}
			}
		}
		return contGatasVip;
	}
	public double getCostesVeterinarios() {
		double costes =0;
		for(int i=0;i<numAnimales;i++) {
			if(!animal[i].isApadrinado()) {
				costes += animal[i].costesVeterinarios();
			}
		}
		return costes;
	}
	
	public double cantidadPienso() {
		double comida = 0;
		for(int i=0;i<numAnimales;i++) {
			if(animal[i] instanceof Perro) {
				if(animal[i].getEdad() > MAX_EDAD) {
					comida+= (((Perro)animal[i]).cantidadComida()*7);
				}
			}
		}
		return comida;
	}

	public String getNombre() {
		return nombreProtectora;
	}
	public void setNombre(String nombreProtectora) {
		this.nombreProtectora = nombreProtectora;
	}
	public void setAnimales(Animal[] animal) { 
		this.animal = animal;
	}
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	public int getContador() {
		return numAnimales;
	}
	
	
}
