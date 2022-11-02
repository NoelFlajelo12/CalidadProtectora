package protectora;

public class Perro extends Animal{

		private String raza;
		private int peso;
		private boolean peligroso;
		private boolean leishmania;
		
		public Perro (String nombre, TSexo sexo,int edad, boolean sociable, boolean apadrinado,String raza,int peso, boolean peligroso, boolean leishmania) {
			
			super(nombre,sexo,edad,sociable,apadrinado);
			this.raza = raza;
			this.peso = peso;
			this.peligroso = peligroso;
			this.leishmania = leishmania;
			
		}
		public String toString() {
			return "[PERRO: "+super.toString()+ " Raza: " +raza+" Peso: "+peso+" Peligroso: "+peligroso+" Leishmania: "+leishmania+"]";
		}
		public String getRaza() {
			return raza;
		}
		
		public void setRaza(String raza) {
			this.raza = raza;
		}
		
		public int getPeso() {
			return peso;
		}
		
		public void setPeso(int peso) {
			this.peso = peso;
		}
		
		public boolean getPeligroso() {
			return peligroso;
		}
		
		public void setPeligroso(boolean peligroso) {
			this.peligroso= peligroso;
		}
		
		public boolean getLeishmania() {
			return leishmania;
		}
		
		public void setLeishmania(boolean leishmania) {
			this.leishmania = leishmania;
		}
		public double cantidadComida() {
			double comida = 0;
			if (peso<=MAX_PESO_PERRO_P) {
				comida+=COMIDA_PERRO_P;
			}
			else if (peso <= MAX_PESO_PERRO_M) {
				comida+=COMIDA_PERRO_M;
			}else {
				comida+= peso*P_COMIDA_PERRO_G;
			}
			return comida;
		}
		public double costesVeterinarios() {
			double gastos = VACUNA;
			if(peligroso) {
				gastos+=SEDANTE;
			}if(leishmania) {
				gastos+=(PRECIO_LEHISMANIA*12);
			}
			return gastos;
		}
		
}
