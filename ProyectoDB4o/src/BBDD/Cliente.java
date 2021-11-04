package BBDD;

public class Cliente {
	
	private String nif;
	private String nombre;
	private String apellido;
	
	
	

	
	public Cliente(String nif,String nombre, String apellido) {
		super();
		this.nif=nif;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public  String getNif() {
		return nif;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "Cliente \nNombre: " + nombre + "\nApellidos: " + apellido + "\nNIF= "+nif;
	}
	
	
	
	

}
