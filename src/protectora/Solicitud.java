package protectora;
//un atributo estatico es el mismo para todos los metodos de la clase
public class Solicitud {

	private static int n_Solicitudes=0;   
	
	
	private int numero_Solicitud=0;
	private TSolicitud tipo_solicitud; 
	private long telefono;         
	
	public Solicitud (TSolicitud tipo_solicitud,long telefono) {
		n_Solicitudes++;
		this.numero_Solicitud=n_Solicitudes;                                    
		this.tipo_solicitud=tipo_solicitud;
		this.telefono=telefono;
		
	}
	public TSolicitud getTipoSolicitud() {
		return tipo_solicitud;
	}
	public void setTipoSolicitud(TSolicitud solicitud) {
		this.tipo_solicitud = solicitud;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String toString() {
		return "[SOLICITUD: numero_Solicitud: "+numero_Solicitud+ " tipo_Solicitud: "+tipo_solicitud+ " telefono: "+ telefono+"] ";
	}
}
