package Calidad.CalidadProtectora;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class leerFichero {
	
	public void leerSolicitudes(String nombreArchivoSolicitudes,Protectora protect) {
		BufferedReader objReader = null;
		String strCurrentLine;
		
		try {
			objReader = new BufferedReader(new FileReader(nombreArchivoSolicitudes));
			strCurrentLine = objReader.readLine();
			while ((strCurrentLine = objReader.readLine()) != null) {
				
				StringTokenizer st = new StringTokenizer(strCurrentLine);
				String nombre = st.nextToken();
				String tSolicitud = st.nextToken();
				TSolicitud tipoSolicitud = TSolicitud.ACOGIDA;
				try {
					if(tSolicitud.equalsIgnoreCase("ACOGIDA")) {
						tipoSolicitud=TSolicitud.ACOGIDA;
						throw new SolicitudException();
					}
					if (tSolicitud.equalsIgnoreCase("ADOPCION")) {
						tipoSolicitud=TSolicitud.ADOPCION;
						throw new SolicitudException();
					}
				}catch(SolicitudException SE) {		
				}
				
				long telefono = Long.parseLong(st.nextToken());
				
				//Exception si no existe el animal
				//Solicitud solicitud = new Solicitud(nombre,tipoSolicitud,telefono);
				try {
					Animal animal = protect.getAnimal(nombre);
				animal.addSolicitud(new Solicitud(tipoSolicitud,telefono));
				
				}catch(NullPointerException noExiste) {
					
				}
			}	
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void leerAnimales(String nombreArchivoAnimales, Protectora protect) {
		int contador_apadrinados=0;
		BufferedReader objReader = null;
		String strCurrentLine;
		
		try {
			objReader = new BufferedReader(new FileReader(nombreArchivoAnimales));
			while ((strCurrentLine = objReader.readLine()) != null) {
				
				StringTokenizer st = new StringTokenizer(strCurrentLine);
				String cadena = st.nextToken();
				char c_Mascota = cadena.charAt(0);
				
				String nombre = st.nextToken();
				String sexo_str = st.nextToken();
				TSexo sexo=TSexo.MACHO;
				
				try {
					if(sexo_str.equals("m")) {
						sexo=TSexo.MACHO;
						throw new SexoException();
					}
					if (sexo_str.equals("h")) {
						sexo=TSexo.HEMBRA;
						throw new SexoException();
					}
				}catch(SexoException SE) {
					
					}
					int edad = Integer.parseInt(st.nextToken());
				
					String sociable_str = st.nextToken();
					boolean sociable = Boolean.parseBoolean(sociable_str);
				
					String apadrinado_str = st.nextToken();
					boolean apadrinado = Boolean.parseBoolean(apadrinado_str);
					if(apadrinado==true) {
						contador_apadrinados++;
					}
								
				switch(c_Mascota) {
					
					case 'p':
					
						String raza=st.nextToken();
						
						String peso1=st.nextToken();
						int peso=Integer.parseInt(peso1);
					
						String peligroso1=st.nextToken();
						boolean peligroso = Boolean.parseBoolean(peligroso1);
					
						String lehismania1=st.nextToken();
						boolean lehismania = Boolean.parseBoolean(lehismania1);
					
						//String fecha = st.nextToken();

						//SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
						//Date fechaActualizada = null;
						//fechaActualizada = formatoDeFecha.parse(fecha);
					
					
						protect.anadirAnimal(new Perro(nombre,sexo,edad,sociable,apadrinado,raza,peso,peligroso,lehismania));
					
						break;
					case 'g':	
						String esterilizado_str = st.nextToken();
						boolean esterilizado = Boolean.parseBoolean(esterilizado_str);
						if(st.hasMoreTokens()) {
							String carnetVip_linea = st.nextToken();
							int carnetVip = Integer.parseInt(carnetVip_linea);
							protect.anadirAnimal(new GatoVip(nombre,sexo,edad,sociable,apadrinado,esterilizado,carnetVip));
						}else {
						protect.anadirAnimal(new Gato(nombre,sexo,edad,sociable,apadrinado,esterilizado));
						}
					
				}
		} 
		}catch (IOException e) {
			System.out.println(e.getMessage());
			}
	}
}

	

