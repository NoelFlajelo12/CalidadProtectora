package protectora;

import java.io.*;

public class escribirFichero {

	public void escribirAnimal(String nombreFichero, String lineaAnimal) {
		//Esto lo que hace es escribir el nuevo animal en el fichero
		try {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, true));
		bw.write(lineaAnimal+"\n");
		bw.close(); 
		}catch(IOException e) {
			
		}
	}
}
