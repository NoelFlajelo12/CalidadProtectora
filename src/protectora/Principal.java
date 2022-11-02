package protectora;

import java.util.*;
                                                             
public class Principal {

	final static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcion = 0;
		Protectora protect=new Protectora("x",1000);
		leerFichero leer=new leerFichero();
		leer.leerAnimales(".\\Animales.txt",protect);
		leer.leerSolicitudes(".\\Solicitudes.txt", protect);
		Animal [] animales = null;
		String nombre;
		
		
		do {
			//Menú de opciones del programa
			System.out.println("Elija una opcion: \n"+
			"	1. Mostrar animales\n"+
			"	2. Realizar solicitud de adopcion o acogida\n"+
			"	3. Consultar listado de solicitudes de un Animal\n"+
			"	4. Calcular coste de los gastos veterinarios\n" +
			"	5. Calcular coste Esterilización\n"+
			"	6. Calcular cantidad de pienso de perro adulto\n"+
			"	7. Calcular subvencion\n"+
			"	8. Añadir nuevo animal\n"+
			"	9. Buscar un animal\n"+
			"	10. Cerrar el programa.");
			opcion = teclado.nextInt();
		
			switch(opcion) {
		
				case 1: 
					animales = protect.getAnimales();
					for(int i=0;i<protect.getContador();i++) {
						System.out.println(animales[i].toString());
					}
					break;
				case 2:
					System.out.println("Elija el animal al que añadir una solicitud");
					nombre = teclado.next();
					try {
						Solicitud nuevaSolicitud= nuevaSolicitud(nombre);
						protect.getAnimal(nombre).addSolicitud(nuevaSolicitud);
						System.out.println("La solicitud se ha completado con exito");
					}catch(NullPointerException e) {
						System.out.println("El animal no existe");
					}
					
					break;
				case 3: 
					System.out.println("Introduzca el nombre del animal del que se quiere obtener los datos sobre solicitudes de adopcion");
					nombre = teclado.next();
					if(protect.getAnimal(nombre) == null) {
						System.out.println("No existe un animal con ese identificador");
					}else {
						System.out.println(protect.getAnimal(nombre).mostrarSolicitudesAdopcion());
					}
					break;
				case 4: 
					System.out.println("Los costes veterinarios anuales de la protectora son: "+protect.getCostesVeterinarios()+" Euros");
					break;
				case 5: 
					Clinica_Veterinaria veterinaria = nuevaVeterinaria(); //Poner en GAto
					double costeEsterilizacion = (protect.getNumeroGatasNoEsterilizadas() * veterinaria.getPrecioEsterilizacion()) + 
							(protect.getNumeroGatasVipNoEsterilizadas()*veterinaria.getPrecioEsterilizacionVip());
					System.out.println("El coste de la esterilizacion de todas las gatas no esterilizadas seria de : " +costeEsterilizacion+" Euros");
					break;
				case 6:
					System.out.printf("%nLa cantidad de pienso estimada para una semana es: %.2f Kg %n", protect.cantidadPienso());
					break;
				case 7:
					
					Ayuntamiento ayuntamiento = nuevoAyuntamiento();
                    double subvencion = ayuntamiento.calcularSubvencion(protect);
                    System.out.println("La subvencion que concede el ayuntamiento por los animales que hay en la protectora es de: "+ subvencion+"€");
                    break;
					
				case 8:
						nuevoAnimal(protect);
					break;
				case 9:
					System.out.println("Introduzca el nombre del animal del que se quiere obtener los datos");
					nombre = teclado.next();
					
					if(protect.getAnimal(nombre) == null) {
						System.out.println("No existe un animal con ese identificador");
					}else {
						System.out.println(protect.getAnimal(nombre).toString());
					}
					break;
				case 10:
					break;
				default: System.out.println("Opcion incorrecta");
			}
		}while(opcion != 10);
		
		System.out.println("Fin");
		
		
		
		
	}
	public static Solicitud nuevaSolicitud(String nombre) {
		escribirFichero wFichero =new escribirFichero();
		
		TSolicitud tipoSolicitud = null;
		System.out.println("Que clase de solicitud quiere hacer:[ADOPCION/ACOGIDA]");
		String tSolicitud = teclado.next();
		if(tSolicitud.equalsIgnoreCase("Adopcion")) {
			tipoSolicitud = TSolicitud.ADOPCION;
		}if(tSolicitud.equalsIgnoreCase("Acogida")) {
			tipoSolicitud = TSolicitud.ACOGIDA;
		}	
		
		System.out.println("Introduzca el numero de contacto");
		long telContacto = teclado.nextLong();
		Solicitud solicitudNueva = new Solicitud(tipoSolicitud,telContacto);
		
		String lineaSolicitud = nombre+" "+ tSolicitud +" "+telContacto;
		
		wFichero.escribirAnimal(".\\Solicitudes.txt", lineaSolicitud);
		return solicitudNueva;
	}
	public static void nuevoAnimal(Protectora protect) {
		escribirFichero wFichero =new escribirFichero();
		String lineaAnimal;
		Animal animal = null;
		char caracterEspecie = ' ';
		int edad = 0;
		TSexo sexo= null;
		boolean sociable= false,apadrinado=false, peligroso = false,leishmania = false,esterilizado= false,gatoVip = false, repetido = true;
		
		System.out.println("Introduzca los datos del animal");
		
		while(caracterEspecie == ' ') {
			System.out.println("Quiere introducir los datos de un Perro o un Gato [Perro/Gato]");
			String especie =teclado.next();
			if(especie.equalsIgnoreCase("Perro")) {
				caracterEspecie = 'p';
			}if(especie.equalsIgnoreCase("Gato")) {
				caracterEspecie = 'g';
			}else {
				System.out.println("Error al introducir el tipo de animal");
			}
		}
		while(repetido) {
			System.out.println("Introduzca el nombre del animal");
			String nNuevoAnimal = teclado.next();
			if(protect.getAnimal(nNuevoAnimal) == null) {
				repetido = false;
				String sexoLinea= "";
				while(sexo == null) {
					System.out.println("Introduzca el sexo[Macho = M/ Hembra = H]: ");
					sexoLinea = teclado.next();
					try {
						if(sexoLinea.equalsIgnoreCase("m")) {
							sexo=TSexo.MACHO;
							throw new SexoException();
						}
						if (sexoLinea.equalsIgnoreCase("h")) {
							sexo=TSexo.HEMBRA;
							throw new SexoException();
						}
					}catch(SexoException SE) {
					
					}
				}
				//Edad del animal
				System.out.println("Introduzca la edad del animal[Recuerde que la edad se debe apuntar en años]: ");
				edad = teclado.nextInt();
				//Si es sociable o no
				System.out.println("Introduzca si es sociable el animal [Si/No]");
				sociable = incognitaTeclado(sociable);
				//si es apadrinado o no
				System.out.println("Introduzca si está apadrinado el animal [Si/No]");
				apadrinado = incognitaTeclado(apadrinado);
				
				
				switch (caracterEspecie){
				
				case 'p':
					System.out.println("Introduzca la raza del perro");
					String raza = teclado.next();
					System.out.println("Introduzca el peso del perro");
					int peso = teclado.nextInt();
					System.out.println("Introduzca si es peligroso el perro[Si/No]");
					peligroso = incognitaTeclado(peligroso);
					System.out.println("Introduzca si tiene leishmania el perro[Si/No]");
					leishmania = incognitaTeclado(leishmania);
					
					animal = new Perro(nNuevoAnimal,sexo,edad,sociable,apadrinado,raza,peso,peligroso,leishmania);
					//Creamos un perro, o un gato en principio pero no nos dejaba usar break
					lineaAnimal = caracterEspecie + " "+ nNuevoAnimal + " "+ sexo +" "+ edad + " "+ sociable +" "+ apadrinado +" " +raza+" "+peso+" "+peligroso+" "+ leishmania;
					wFichero.escribirAnimal(".\\Animales.txt", lineaAnimal);
					break;
				case 'g':
					System.out.println("Introduzca si esta esterilizado el gato[Si/No]");
					esterilizado = incognitaTeclado(esterilizado);
					
					System.out.println("Es una gato Vip [Si/No]");
					gatoVip = incognitaTeclado(gatoVip);
					if(gatoVip) {
						System.out.println("Introduzca el numero de carnet del gato");
						int carnetVip = teclado.nextInt();
						animal = new GatoVip(nNuevoAnimal,sexo,edad,sociable,apadrinado,esterilizado,carnetVip);
						lineaAnimal = caracterEspecie + " "+ nNuevoAnimal + " "+ sexoLinea +" "+ edad + " "+ sociable +" "+ apadrinado +" " +esterilizado+" "+ carnetVip;
						wFichero.escribirAnimal(".\\Animales.txt", lineaAnimal);
					}else {
					
					animal = new Gato(nNuevoAnimal,sexo,edad,sociable,apadrinado,esterilizado);
					lineaAnimal = caracterEspecie + " "+ nNuevoAnimal + " "+ sexoLinea +" "+ edad + " "+ sociable +" "+ apadrinado +" " +esterilizado;
					wFichero.escribirAnimal(".\\Animales.txt", lineaAnimal);
					}
					break;
				default: System.out.println("Opcion incorrecta");
				
					break;
				}
				protect.anadirAnimal(animal);
			} else {
				System.out.println("Ya existe un animal con este identificador");
				
			}
		}
		
	}
	public static Clinica_Veterinaria nuevaVeterinaria() {
		System.out.println("Introduzca el nombre de la clinica");
		String nombreClinica = teclado.next();
		
		long telVeterinaria = 0;
		double precioEsterilizacion;
		while((telVeterinaria <= 900000000 || telVeterinaria >= 999999999) && (telVeterinaria <= 600000000 || telVeterinaria >= 699999999)) {
		System.out.println("Introduzca el telefono de contacto de "+nombreClinica+ "[Recuerde debe ser un numero valido para España]:");
		 telVeterinaria = teclado.nextLong();
		}
		System.out.println("Introduzca el precio de la operación de esterilización:");
		precioEsterilizacion = teclado.nextDouble();
		
		Clinica_Veterinaria veterinaria = new Clinica_Veterinaria(nombreClinica,telVeterinaria,precioEsterilizacion);
		
		return veterinaria;
	}
	
    public static Ayuntamiento nuevoAyuntamiento() {
       
       
        long telContacto=0;
        double cantidad_variable;
        while((telContacto <= 900000000 || telContacto >= 999999999) && (telContacto <= 600000000 || telContacto >= 699999999)) {
        System.out.println("Introduzca el telefono de contacto del ayuntamieto");
        telContacto = teclado.nextLong();
        }
        System.out.println("Introduzca cantidad de subvención que concede por animal recogido.");
        cantidad_variable = teclado.nextDouble();
       
        Ayuntamiento ayuntamiento = new Ayuntamiento(telContacto,cantidad_variable);
       
        return ayuntamiento;
    }

	public static boolean incognitaTeclado(boolean incognita) {
		boolean opcionIncognita = false;
		
		while(!opcionIncognita) {
			String incognitaLinea = teclado.next();
			if(incognitaLinea.equalsIgnoreCase("Si")) {
				incognita = true;
				opcionIncognita = true;
			}else if(incognitaLinea.equalsIgnoreCase("No")) {
				opcionIncognita = true;
			}else  {
				System.out.println("Error, vuelva a introducir [Si/No]");
			}
		}
		return incognita;
	}
	

	
	
}
