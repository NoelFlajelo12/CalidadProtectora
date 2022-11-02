package protectora;



public abstract class Animal implements Constantes{		                           	
	protected String nombre;
	protected TSexo sexo;
	protected int edad;
	protected boolean sociable;
	protected boolean apadrinado;
	protected Solicitud [] solicitudes=new Solicitud [MAX_SOLICITUDES];
	protected int n_Solicitudes=0; //Nos
	
	
	public Animal(String nombre,TSexo sexo,int edad,boolean sociable,boolean apadrinado) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.sociable = sociable;
		this.apadrinado = apadrinado;
		this.n_Solicitudes = 0;
	}
	public void addSolicitud(Solicitud sol) {
		
		try {
			solicitudes[n_Solicitudes] = sol;
			n_Solicitudes++;
			//Crear excepcion
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Se ha rebasado la capacidad de solicitudes");
		}
	}
	
	public Solicitud[] getSolicitudes() { //devolver array e integer(objeto)
		return solicitudes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TSexo getSexo() {
		return sexo;
	}

	public void setSexo(TSexo sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isSociable() {
		return sociable;
	}

	public void setSociable(boolean sociable) {
		this.sociable = sociable;
	}

	public boolean isApadrinado() {
		return apadrinado;
	}

	public void setApadrinado(boolean apadrinado) {
		this.apadrinado = apadrinado;
	}

	public String mostrarSolicitudesAdopcion() {
		String adopciones = "Solicitudes: \n";
		for(int i=0;i<n_Solicitudes;i++) {
			if(solicitudes[i].getTipoSolicitud().equals(TSolicitud.ADOPCION)) {
				adopciones = adopciones+ " " + solicitudes[i].toString() +"\n";
			}
		}
		return adopciones;
	}
	public abstract double costesVeterinarios();

	public String toString() { 
		
		String c = "Solicitudes: \n";
		for(int i=0;i<n_Solicitudes;i++) {
			c = c+ " " + solicitudes[i].toString()+"\n";
		}
		return "[ANIMAL: Nombre: "+ nombre + " "+c+ " Sexo: "+sexo+" Edad: "+edad+" Sociable: "+sociable+" Apadrinado: "+apadrinado+"]";
	}
	
	
}
